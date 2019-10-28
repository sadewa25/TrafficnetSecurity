package com.codedirect.trafficnetsecurity.data.repo

interface IUserRepository {

    suspend fun register(username: String, email: String, password: String): String?

    suspend fun signIn(email: String, password: String): String?

    suspend fun changePassword(currentPassword: String, newPassword: String): String?

    suspend fun isLoggedIn(): Boolean

}