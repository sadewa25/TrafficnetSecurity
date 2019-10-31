package com.codedirect.trafficnetsecurity.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.remote.request.LoginRequest
import com.codedirect.trafficnetsecurity.data.repo.UserRepository
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class LoginViewModel(val userRepository: UserRepository) : AppViewModel() {

    companion object {

        const val ACTION_OPEN_HOME = 20
        const val ACTION_OPEN_REGISTRATION = 21

    }

    val usernameField by lazy { MutableLiveData("") }
    val passwordField by lazy { MutableLiveData("") }
    val isLoading by lazy { MutableLiveData(false) }

    override fun init() {
        viewModelScope.launch {
            with(userRepository.isLoggedIn()) {
                data?.let { if (it) action.value = ACTION_OPEN_HOME }
                error?.let { toast.value = it }
            }
        }
    }

    fun doSignIn() {
        viewModelScope.launch {
            isLoading.value = true

            if (usernameField.value != null && passwordField.value != null) {
                val email = usernameField.value!!
                val password = passwordField.value!!
                val request = LoginRequest(password, email)
                handle(userRepository.signIn(request)) {
                    data?.let {
                        toast.value = it
                        action.value = ACTION_OPEN_HOME
                    }
                }
            } else toast.value = "Username dan password harus diisi"

            isLoading.value = false
        }
    }

    fun openRegistration() {
        action.value = ACTION_OPEN_REGISTRATION
    }
}