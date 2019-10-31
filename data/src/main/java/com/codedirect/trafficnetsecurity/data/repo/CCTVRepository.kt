package com.codedirect.trafficnetsecurity.data.repo

import com.codedirect.trafficnetsecurity.data.Outcome
import com.codedirect.trafficnetsecurity.data.remote.request.CreateSensorRequest
import com.codedirect.trafficnetsecurity.data.remote.request.UpdateSensorRequest
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData

class CCTVRepository : ICCTVRepository {

    override suspend fun getCCTVList(): Outcome<List<SensorData>> = Outcome(listOf())

    override suspend fun getCCTV(cctvId: String): Outcome<SensorData> = Outcome(null)

    override suspend fun createCCTV(body: CreateSensorRequest): Outcome<SensorData> = Outcome(null)

    override suspend fun updateCCTV(
        body: UpdateSensorRequest,
        cctvId: String
    ): Outcome<SensorData> = Outcome(null)

    override suspend fun deleteCCTV(cctvId: String): Outcome<SensorData> = Outcome(null)

}