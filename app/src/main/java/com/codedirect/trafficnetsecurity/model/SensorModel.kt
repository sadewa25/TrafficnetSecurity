package com.codedirect.trafficnetsecurity.model

data class SensorModel(
    val id: String,
    val type: String,
    val lat: Double,
    val lng: Double,
    val status: Boolean
)