package com.codedirect.trafficnetsecurity.data.remote.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class SensorData(

	@field:SerializedName("data")
	val data: List<Any?>? = null,

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("jenis")
	val jenis: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("long")
	val jsonMemberLong: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)