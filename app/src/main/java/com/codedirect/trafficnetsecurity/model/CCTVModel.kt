package com.codedirect.trafficnetsecurity.model

data class CCTVModel(
    val id : Int,
    val ssid : String,
    val pass : String,
    val info: String,
    val status: String
)