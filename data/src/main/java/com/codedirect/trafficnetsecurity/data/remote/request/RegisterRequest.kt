package com.codedirect.trafficnetsecurity.data.remote.request

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class RegisterRequest(
    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("username")
    val username: String? = null,

    @field:SerializedName("password")
    val password: String? = null
)