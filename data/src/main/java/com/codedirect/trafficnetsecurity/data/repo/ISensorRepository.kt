package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.Outcome
import com.codedirect.trafficnetsecurity.data.remote.request.CreateSensorRequest
import com.codedirect.trafficnetsecurity.data.remote.request.UpdateSensorRequest
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData

interface ISensorRepository : IRepository {

    suspend fun getSensorList(): Outcome<List<SensorData>>

    suspend fun getSensor(sensorId: String): Outcome<SensorData>

    suspend fun createSensor(body: CreateSensorRequest): Outcome<SensorData>

    suspend fun updateSensor(body: UpdateSensorRequest, sensorId: String): Outcome<SensorData>

    suspend fun deleteSensor(sensorId: String): Outcome<SensorData>

}