package com.codedirect.model

import java.math.BigInteger

data class UserModel(
    val name : String,
    val email : String,
    val password : String,
    val ktp : BigInteger,
    val kota : String
)