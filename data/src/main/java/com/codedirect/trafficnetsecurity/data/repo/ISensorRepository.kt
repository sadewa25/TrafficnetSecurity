package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.repo.request.CreateSensorRequest
import com.codedirect.trafficnetsecurity.data.repo.request.UpdateSensorRequest
import com.codedirect.trafficnetsecurity.data.repo.response.SensorData

interface ISensorRepository {

    suspend fun getSensorList(): List<SensorData>

    suspend fun getSensor(sensorId: String): SensorData

    suspend fun createSensor(body: CreateSensorRequest): SensorData

    suspend fun updateSensor(body: UpdateSensorRequest, sensorId: String): SensorData

    suspend fun deleteSensor(sensorId: String): SensorData

}