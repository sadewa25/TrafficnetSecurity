package com.codedirect.trafficnetsecurity.ui.login

import androidx.lifecycle.MutableLiveData
import com.codedirect.trafficnetsecurity.data.repo.UserRepository
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class LoginViewModel(
    val userRepository: UserRepository
) : AppViewModel() {

    companion object {

        const val ACTION_OPEN_HOME = 20
        const val ACTION_OPEN_REGISTRATION = 21

    }

    val usernameField: MutableLiveData<String> by lazy { MutableLiveData("") }
    val passwordField: MutableLiveData<String> by lazy { MutableLiveData("") }
    val isLoading: MutableLiveData<Boolean> by lazy { MutableLiveData(false) }

    fun doSignIn() {
        launch {
            try {
                isLoading.value = true
                usernameField.value?.let { email ->
                    passwordField.value?.let { password ->
                        val result = userRepository.signIn(email, password)
                        if (result) action.value = ACTION_OPEN_HOME
                    }
                }
            } catch (e: Exception) {
                toast.value = e.message
            } finally {
                isLoading.value = false
            }
        }
    }

    fun openRegistration() {
        action.value = ACTION_OPEN_REGISTRATION
    }
}