package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.remote.APIEndpoint
import com.codedirect.trafficnetsecurity.data.remote.request.CreateSensorRequest
import com.codedirect.trafficnetsecurity.data.remote.request.UpdateSensorRequest
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData
import com.codedirect.trafficnetsecurity.data.util.orZero

class SensorRepository(private val mApiEndpoint: APIEndpoint) : ISensorRepository {

    override suspend fun getSensorList(): List<SensorData> {
        return mApiEndpoint.getMySensorList()
    }

    override suspend fun getSensor(sensorId: String): SensorData {
        return mApiEndpoint.getSensorById(sensorId)
    }

    override suspend fun createSensor(body: CreateSensorRequest): SensorData {
        return mApiEndpoint.createSensor(
            body.id,
            body.jenis,
            body.jsonMemberLong.orZero(),
            body.lat.orZero()
        )
    }

    override suspend fun updateSensor(body: UpdateSensorRequest, sensorId: String): SensorData {
        return mApiEndpoint.updateSensor(
            sensorId,
            body.id,
            body.jenis,
            body.jsonMemberLong.orZero(),
            body.lat.orZero()
        )
    }

    override suspend fun deleteSensor(sensorId: String): SensorData {
        return mApiEndpoint.deleteSensor(sensorId)
    }


}