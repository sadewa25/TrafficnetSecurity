package com.codedirect.trafficnetsecurity.data.remote.request

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class UpdateSensorRequest(

    @field:SerializedName("jenis")
    val jenis: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("long")
    val jsonMemberLong: String,

    @field:SerializedName("lat")
    val lat: String
)