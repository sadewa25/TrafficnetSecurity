package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.Outcome
import com.codedirect.trafficnetsecurity.data.remote.request.ChangePasswordRequest
import com.codedirect.trafficnetsecurity.data.remote.request.ChangeProfileRequest
import com.codedirect.trafficnetsecurity.data.remote.request.LoginRequest
import com.codedirect.trafficnetsecurity.data.remote.request.RegisterRequest
import com.codedirect.trafficnetsecurity.data.remote.response.ProfileData

interface IUserRepository : IRepository {

    suspend fun register(registerRequest: RegisterRequest): Outcome<String>

    suspend fun signIn(loginRequest: LoginRequest): Outcome<String>

    suspend fun signedInProfile(): Outcome<ProfileData>

    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest): Outcome<String>

    suspend fun changeProfile(changeProfileRequest: ChangeProfileRequest): Outcome<String>

    suspend fun isLoggedIn(): Outcome<Boolean>

}