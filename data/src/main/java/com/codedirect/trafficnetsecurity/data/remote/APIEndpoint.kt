package com.codedirect.trafficnetsecurity.data.remote

import com.codedirect.trafficnetsecurity.data.remote.response.LoginData
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData
import retrofit2.http.*

interface APIEndpoint {

    @FormUrlEncoded
    @POST("user/login/resident")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginData

    @FormUrlEncoded
    @POST("user/changePassword")
    suspend fun changePassword(
        @Field("current_password") currentPassword: String,
        @Field("new_password") newPassword: String
    )

    @GET("sensor/getByUsername")
    suspend fun getMySensorList(): List<SensorData>

    @GET("sensor/getById/{sensorId}")
    suspend fun getSensorById(@Path("sensorId") sensorId: String): SensorData

    @POST("sensor/create")
    suspend fun createSensor(
        @Field("id") id: String,
        @Field("jenis") type: String,
        @Field("long") lng: String,
        @Field("lat") lat: String
    ): SensorData

    @POST("sensor/updateById/{sensorId}")
    suspend fun updateSensor(
        @Path("sensorId") sensorId: String,
        @Field("id") id: String,
        @Field("jenis") type: String,
        @Field("long") lng: String,
        @Field("lat") lat: String
    ): SensorData

    @DELETE("sensor/deleteById/{sensorId}")
    suspend fun deleteSensor(@Path("sensorId") sensorId: String): SensorData


}