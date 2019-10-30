package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.remote.request.ChangePasswordRequest
import com.codedirect.trafficnetsecurity.data.remote.request.ChangeProfileRequest
import com.codedirect.trafficnetsecurity.data.remote.request.LoginRequest
import com.codedirect.trafficnetsecurity.data.remote.request.RegisterRequest

interface IUserRepository {

    suspend fun register(registerRequest: RegisterRequest): String?

    suspend fun signIn(loginRequest: LoginRequest): String?

    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest): String?

    suspend fun changeProfile(changeProfileRequest: ChangeProfileRequest): String?

    suspend fun isLoggedIn(): Boolean

}