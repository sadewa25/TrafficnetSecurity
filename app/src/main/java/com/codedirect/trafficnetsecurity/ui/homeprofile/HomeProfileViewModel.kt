package com.codedirect.trafficnetsecurity.ui.homeprofile

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.local.prefs.DataCache
import com.codedirect.trafficnetsecurity.data.repo.UserRepository
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class HomeProfileViewModel(
    val dataCache: DataCache,
    val userRepository: UserRepository
) : AppViewModel() {

    companion object {

        const val OPEN_CLEAR_LOGIN_PAGE = 20

    }

    val usernameField by lazy { MutableLiveData("") }
    val emailField by lazy { MutableLiveData("") }
    val currentPasswordField by lazy { MutableLiveData("") }
    val newPasswordField by lazy { MutableLiveData("") }

    fun save() {
        viewModelScope.launch {
            try {
                val changePasswordValidates = listOf(
                    currentPasswordField.value,
                    newPasswordField.value
                ).map { !TextUtils.isEmpty(it) }

                if (!changePasswordValidates.contains(false)) {
                    userRepository.changePassword(
                        currentPasswordField.value.orEmpty(),
                        newPasswordField.value.orEmpty()
                    )?.let { toast.value = it }
                }
            } catch (e: Exception) {
                toast.value = e.message
            }
        }
    }

    fun logout() {
        dataCache.clear()
        action.value = OPEN_CLEAR_LOGIN_PAGE
    }

}