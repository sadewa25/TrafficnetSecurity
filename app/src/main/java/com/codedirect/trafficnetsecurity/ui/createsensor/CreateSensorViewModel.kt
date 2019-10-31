package com.codedirect.trafficnetsecurity.ui.createsensor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.remote.request.CreateSensorRequest
import com.codedirect.trafficnetsecurity.data.repo.SensorRepository
import com.codedirect.trafficnetsecurity.data.util.orZero
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class CreateSensorViewModel(private val mSensorRepository: SensorRepository) : AppViewModel() {

    companion object {

        const val OPEN_PREVIOUS_PAGE = 30

    }

    val sensorIdField by lazy { MutableLiveData<String>("") }
    val sensorTypeField by lazy { MutableLiveData<String>("") }
    val sensorLatField by lazy { MutableLiveData<String>("") }
    val sensorLngField by lazy { MutableLiveData<String>("") }
    val ssidNameField by lazy { MutableLiveData<String>("") }
    val ssidPasswordField by lazy { MutableLiveData<String>("") }

    fun create() {
        viewModelScope.launch {
            val request = CreateSensorRequest(
                sensorTypeField.value.orEmpty(),
                sensorIdField.value.orEmpty(),
                sensorLngField.value.orZero(),
                sensorLatField.value.orZero()
            )
            handle(mSensorRepository.createSensor(request)) {
                data?.let { toast.value = "Sensor '${it.id}' berhasil ditambahkan!" }
                action.value = OPEN_PREVIOUS_PAGE
            }
        }
    }

}