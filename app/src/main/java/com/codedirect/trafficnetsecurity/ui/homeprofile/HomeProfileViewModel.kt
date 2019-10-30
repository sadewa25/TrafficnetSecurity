package com.codedirect.trafficnetsecurity.ui.homeprofile

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.local.prefs.DataCache
import com.codedirect.trafficnetsecurity.data.remote.request.ChangePasswordRequest
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
            val changePasswordValidates = listOf(
                currentPasswordField.value,
                newPasswordField.value
            ).map { !TextUtils.isEmpty(it) }

            if (!changePasswordValidates.contains(false)) {
                val request = ChangePasswordRequest(
                    currentPasswordField.value.orEmpty(),
                    newPasswordField.value.orEmpty()
                )
                handle(userRepository.changePassword(request)) {
                    data?.let { toast.value = it }
                }
            }
        }
    }

    fun logout() {
        dataCache.clear()
        action.value = OPEN_CLEAR_LOGIN_PAGE
    }

}