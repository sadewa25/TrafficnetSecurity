package com.codedirect.trafficnetsecurity.data.repo

interface IUserRepository {

    suspend fun signIn(email: String, password: String): Boolean

    suspend fun changePassword(currentPassword: String, newPassword: String): Boolean

    suspend fun isLoggedIn(): Boolean

}