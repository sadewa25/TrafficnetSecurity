package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.prefs.DataCache

class UserRepository(
    private val mAPIEndpoint: APIEndpoint,
    private val mDataCache: DataCache
) : IUserRepository {

    override suspend fun signIn(email: String, password: String): Boolean {
        return mAPIEndpoint.login(email, password).token?.let {
            mDataCache.setToken(it)
            true
        } ?: false
    }

    override suspend fun changePassword(currentPassword: String, newPassword: String): Boolean {
        mAPIEndpoint.changePassword(currentPassword, newPassword)
        return true
    }

}