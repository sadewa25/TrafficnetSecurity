package com.codedirect.trafficnetsecurity.ui.homeprofile

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.local.prefs.DataCache
import com.codedirect.trafficnetsecurity.data.remote.request.ChangePasswordRequest
import com.codedirect.trafficnetsecurity.data.remote.request.ChangeProfileRequest
import com.codedirect.trafficnetsecurity.data.remote.response.ProfileData
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

    private val mSignedInProfile by lazy { MutableLiveData<ProfileData>() }

    val usernameField by lazy { MutableLiveData("") }
    val emailField by lazy { MutableLiveData("") }
    val currentPasswordField by lazy { MutableLiveData("") }
    val newPasswordField by lazy { MutableLiveData("") }

    override fun init() {
        mSignedInProfile.observeForever {
            usernameField.value = it.username
            emailField.value = it.email
        }

        fetchProfile()
    }

    fun fetchProfile() {
        viewModelScope.launch {
            handle(userRepository.signedInProfile()) {
                mSignedInProfile.value = data
            }
        }
    }

    fun save() {
        viewModelScope.launch {
            updateProfile()
            changePassword()
        }
    }

    suspend fun updateProfile() {
        val changeProfileValidates = listOf(
            usernameField.value,
            emailField.value
        ).map { !TextUtils.isEmpty(it) }

        if (changeProfileValidates.contains(false)) return

        val request = ChangeProfileRequest(
            usernameField.value.orEmpty(),
            emailField.value.orEmpty()
        )
        handle(userRepository.changeProfile(request)) {
            data?.let { toast.value = it }
        }
    }

    suspend fun changePassword() {
        val changePasswordValidates = listOf(
            currentPasswordField.value,
            newPasswordField.value
        ).map { !TextUtils.isEmpty(it) }

        if (changePasswordValidates.contains(false)) return

        val request = ChangePasswordRequest(
            currentPasswordField.value.orEmpty(),
            newPasswordField.value.orEmpty()
        )
        handle(userRepository.changePassword(request)) {
            data?.let { toast.value = it }
        }
    }

    fun logout() {
        dataCache.clear()
        toast.value = "Logged out"
        action.value = OPEN_CLEAR_LOGIN_PAGE
    }

}