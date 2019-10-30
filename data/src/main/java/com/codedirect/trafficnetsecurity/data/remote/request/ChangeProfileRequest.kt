package com.codedirect.trafficnetsecurity.data.remote.request

data class ChangeProfileRequest(
    val newUsername: String,
    val newEmail: String
)