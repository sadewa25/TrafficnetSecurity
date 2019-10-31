package com.codedirect.trafficnetsecurity.ui.sensordetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.codedirect.trafficnetsecurity.model.SensorModel
import com.codedirect.trafficnetsecurity.ui.AppViewModel

class SensorDetailViewModel : AppViewModel() {

    val sensorData by lazy { MutableLiveData<SensorModel>() }

    val sensorId by lazy { Transformations.map(sensorData) { it.id } }
    val sensorType by lazy { Transformations.map(sensorData) { it.type } }
    val sensorStatus by lazy { Transformations.map(sensorData) { if (it.status) "Online" else "Offline" } }
    val sensorLocation by lazy { Transformations.map(sensorData) { "${it.lat}, ${it.lng}" } }

}