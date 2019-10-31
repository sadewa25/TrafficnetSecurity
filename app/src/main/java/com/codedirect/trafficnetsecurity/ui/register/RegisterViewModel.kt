package com.codedirect.trafficnetsecurity.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.repo.UserRepository
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class RegisterViewModel(val userRepository: UserRepository) : AppViewModel() {

    val usernameField by lazy { MutableLiveData<String>("") }
    val emailField by lazy { MutableLiveData<String>("") }
    val passwordField by lazy { MutableLiveData<String>("") }

    fun register() {
        viewModelScope.launch {
            userRepository
                .register(
                    usernameField.value.orEmpty(),
                    emailField.value.orEmpty(),
                    passwordField.value.orEmpty()
                )?.let { toast.value = it }
        }
    }


}