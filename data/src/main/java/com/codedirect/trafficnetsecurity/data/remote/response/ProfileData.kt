package com.codedirect.trafficnetsecurity.data.remote.response

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ProfileData(

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("subscription")
    val subscription: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("username")
    val username: String? = null
)