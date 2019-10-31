package com.codedirect.trafficnetsecurity.ui.sensordetail

import android.os.Bundle
import android.view.View
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.databinding.DialogSensorDetailBinding
import com.codedirect.trafficnetsecurity.model.SensorModel
import com.codedirect.trafficnetsecurity.ui.AppDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SensorDetailDialogFragment : AppDialogFragment<DialogSensorDetailBinding>() {

    override val layoutId by lazy { R.layout.dialog_sensor_detail }

    override val viewModel by viewModel<SensorDetailViewModel>()

    private lateinit var sensorData: SensorModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.sensorData.value = this.sensorData
    }

    fun setSensorData(data: SensorModel): SensorDetailDialogFragment {
        this.sensorData = data
        return this
    }

}