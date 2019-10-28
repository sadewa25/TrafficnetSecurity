package com.codedirect.trafficnetsecurity.ui.cctvlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.codedirect.trafficnetsecurity.data.remote.response.SensorData
import com.codedirect.trafficnetsecurity.data.repo.SensorRepository
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.ui.AppViewModel
import kotlinx.coroutines.launch

class CCTVListViewModel(val sensorRepository: SensorRepository) : AppViewModel() {

    private val mCCTVList by lazy { MutableLiveData<List<SensorData>>() }

    val cctvList: LiveData<List<DataModel>> by lazy {
        Transformations.map(mCCTVList) { source ->
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
        fetchCCTVList()
    }

    fun fetchCCTVList() {
        viewModelScope.launch {
            try {
                mCCTVList.value = sensorRepository.getSensorList()
            } catch (e: Exception) {
                toast.value = e.message
            }
        }
    }

}