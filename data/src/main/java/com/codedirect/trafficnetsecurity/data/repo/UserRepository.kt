package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.local.prefs.DataCache
import com.codedirect.trafficnetsecurity.data.remote.APIEndpoint

class UserRepository(
    private val mAPIEndpoint: APIEndpoint,
    private val mDataCache: DataCache
) : IUserRepository {

    override suspend fun register(username: String, email: String, password: String): String? {
        return mAPIEndpoint.register(username, email, password).message
    }

    override suspend fun signIn(email: String, password: String): String? {
        return mAPIEndpoint.login(email, password).let { data ->
            data.token?.let { mDataCache.setToken(it) }
            data.message
        }
    }

    override suspend fun changePassword(currentPassword: String, newPassword: String): Boolean {
        return mAPIEndpoint.changePassword(currentPassword, newPassword).let { true }
    }

    override suspend fun isLoggedIn(): Boolean = mDataCache.getToken() != null

}