package com.codedirect.trafficnetsecurity.data.remote.response

import com.google.gson.annotations.SerializedName

data class GeneralData<T>(
    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("data")
    val data: T? = null,

    @field:SerializedName("token")
    val token: String? = null,

    @field:SerializedName("auth")
    val auth: Boolean? = null
)