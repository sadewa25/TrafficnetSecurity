package com.codedirect.trafficnetsecurity.ui.homedashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData
import com.codedirect.trafficnetsecurity.data.repo.SensorRepository
import com.codedirect.trafficnetsecurity.data.util.orZero
import com.codedirect.trafficnetsecurity.model.MarkerModel
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class HomeDashboardViewModel(val sensorRepository: SensorRepository) : AppViewModel() {

    private val mSensorList by lazy { MutableLiveData<List<SensorData>>() }

    val sensorList by lazy {
        Transformations.map(mSensorList) { data ->
            data.map {
                MarkerModel(
                    it.id.orEmpty(),
                    it.lat.orZero().toDouble(),
                    it.jsonMemberLong.orZero().toDouble()
                )
            }
        }
    }

    override fun init() {
        fetchSensorList()
    }

    private fun fetchSensorList() {
        viewModelScope.launch {
            with(sensorRepository.getSensorList()) {
                data?.let { mSensorList.value = it }
                error?.let { toast.value = it }
            }
        }
    }

}