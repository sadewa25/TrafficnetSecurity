package com.codedirect.trafficnetsecurity.data.remote.response

import com.google.gson.annotations.SerializedName

data class MessageData(
    @field:SerializedName("message")
    val message: String? = null
)