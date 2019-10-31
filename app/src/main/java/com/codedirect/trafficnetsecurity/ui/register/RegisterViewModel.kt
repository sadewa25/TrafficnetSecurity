package com.codedirect.trafficnetsecurity.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.remote.request.RegisterRequest
import com.codedirect.trafficnetsecurity.data.repo.UserRepository
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class RegisterViewModel(val userRepository: UserRepository) : AppViewModel() {

    companion object {

        const val OPEN_LOGIN_PAGE = 22

    }

    val usernameField by lazy { MutableLiveData<String>("") }
    val emailField by lazy { MutableLiveData<String>("") }
    val passwordField by lazy { MutableLiveData<String>("") }

    val isLoading by lazy { MutableLiveData<Boolean>(false) }

    fun register() {
        viewModelScope.launch {
            isLoading.value = true

            val request = RegisterRequest(
                emailField.value.orEmpty(),
                usernameField.value.orEmpty(),
                passwordField.value.orEmpty()
            )
            handle(userRepository.register(request)) {
                data?.let {
                    toast.value = it
                    action.value = OPEN_LOGIN_PAGE
                }
            }

            isLoading.value = false
        }
    }


}