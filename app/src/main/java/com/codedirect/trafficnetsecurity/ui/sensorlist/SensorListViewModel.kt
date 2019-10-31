package com.codedirect.trafficnetsecurity.ui.sensorlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData
import com.codedirect.trafficnetsecurity.data.repo.SensorRepository
import com.codedirect.trafficnetsecurity.model.SensorModel
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class SensorListViewModel(val sensorRepository: SensorRepository) : AppViewModel() {

    private val mSensorList by lazy { MutableLiveData<List<SensorData>>() }

    val sensorList: LiveData<List<SensorModel>> by lazy {
        Transformations.map(mSensorList) { source ->
            source.map {
                SensorModel(
                    it.id.orEmpty(),
                    it.jenis.orEmpty(),
                    it.lat?.toDoubleOrNull() ?: 0.0,
                    it.jsonMemberLong?.toDoubleOrNull() ?: 0.0,
                    it.status?.toIntOrNull() == 1
                )
            }
        }
    }

    val isLoading by lazy { MutableLiveData(false) }
    val isEmpty by lazy { Transformations.map(mSensorList) { it.isEmpty() } }

    override fun init() {
        fetchSensorList()
    }

    fun fetchSensorList() {
        viewModelScope.launch {
            handle(sensorRepository.getSensorList()) {
                data?.let { mSensorList.value = it }
            }
        }
    }

}