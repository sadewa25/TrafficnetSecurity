package com.codedirect.trafficnetsecurity.data

open class Outcome<T>(
    val data: T? = null,
    val error: String? = null
)