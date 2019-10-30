package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.local.prefs.DataCache
import com.codedirect.trafficnetsecurity.data.remote.APIEndpoint
import com.codedirect.trafficnetsecurity.data.remote.request.ChangePasswordRequest
import com.codedirect.trafficnetsecurity.data.remote.request.LoginRequest
import com.codedirect.trafficnetsecurity.data.remote.request.RegisterRequest

class UserRepository(
    private val mAPIEndpoint: APIEndpoint,
    private val mDataCache: DataCache
) : IUserRepository {

    override suspend fun register(registerRequest: RegisterRequest): String? {
        return mAPIEndpoint.register(
            registerRequest.username,
            registerRequest.email,
            registerRequest.password
        ).message
    }

    override suspend fun signIn(loginRequest: LoginRequest): String? {
        return mAPIEndpoint.login(loginRequest.email, loginRequest.password).let { data ->
            data.token?.let { mDataCache.setToken(it) }
            data.message
        }
    }

    override suspend fun changePassword(changePasswordRequest: ChangePasswordRequest): String? {
        return mAPIEndpoint.changePassword(
            changePasswordRequest.currentPassword,
            changePasswordRequest.newPassword
        ).message
    }

    override suspend fun isLoggedIn(): Boolean = mDataCache.getToken() != null

}