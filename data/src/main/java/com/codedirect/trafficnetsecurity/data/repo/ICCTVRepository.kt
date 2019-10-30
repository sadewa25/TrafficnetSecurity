package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.Outcome
import com.codedirect.trafficnetsecurity.data.remote.request.CreateSensorRequest
import com.codedirect.trafficnetsecurity.data.remote.request.UpdateSensorRequest
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData

/**
 * TODO change *Sensor* to *CCTV* instead
 */
interface ICCTVRepository : IRepository {

    suspend fun getCCTVList(): Outcome<List<SensorData>>

    suspend fun getCCTV(cctvId: String): Outcome<SensorData>

    suspend fun createCCTV(body: CreateSensorRequest): Outcome<SensorData>

    suspend fun updateCCTV(body: UpdateSensorRequest, cctvId: String): Outcome<SensorData>

    suspend fun deleteCCTV(cctvId: String): Outcome<SensorData>

}