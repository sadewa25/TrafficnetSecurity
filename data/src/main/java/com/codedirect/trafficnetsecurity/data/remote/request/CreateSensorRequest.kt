package com.codedirect.trafficnetsecurity.data.remote.request

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class CreateSensorRequest(

	@field:SerializedName("jenis")
	val jenis: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("long")
	val jsonMemberLong: String,

	@field:SerializedName("lat")
	val lat: String
)