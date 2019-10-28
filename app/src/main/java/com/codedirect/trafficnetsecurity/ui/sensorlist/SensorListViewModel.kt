package com.codedirect.trafficnetsecurity.ui.sensorlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData
import com.codedirect.trafficnetsecurity.data.repo.SensorRepository
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class SensorListViewModel(val sensorRepository: SensorRepository) : AppViewModel() {

    private val mSensorList by lazy { MutableLiveData<List<SensorData>>() }

    val sensorList: LiveData<List<DataModel>> by lazy {
        Transformations.map(mSensorList) { source ->
            source.map {
                DataModel(
                    "",
                    it.username.orEmpty(),
                    it.jenis.orEmpty(),
                    it.status.orEmpty()
                )
            }
        }
    }

    override fun init() {
        fetchSensorList()
    }

    fun fetchSensorList() {
        viewModelScope.launch {
            try {
                mSensorList.value = sensorRepository.getSensorList()
            } catch (e: Exception) {
                toast.value = e.message
            }
        }
    }

}