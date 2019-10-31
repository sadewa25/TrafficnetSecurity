package com.codedirect.trafficnetsecurity.data.remote.request

import com.google.gson.annotations.SerializedName

data class ChangePasswordRequest(

    @field:SerializedName("current_password")
    val currentPassword: String,

    @field:SerializedName("new_password")
    val newPassword: String

)