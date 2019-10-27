package com.codedirect.trafficnetsecurity.model

data class SensorModel(
    val id: Int,
    val ssid: String,
    val pass: String,
    val info: String,
    val status: String
)