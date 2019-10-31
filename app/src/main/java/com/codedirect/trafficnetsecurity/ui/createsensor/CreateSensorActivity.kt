package com.codedirect.trafficnetsecurity.ui.createsensor

import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.databinding.ActivityCreateSensorBinding
import com.codedirect.trafficnetsecurity.ui.AppActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateSensorActivity : AppActivity<ActivityCreateSensorBinding>() {

    override val viewModel by viewModel<CreateSensorViewModel>()

    override val layoutId by lazy { R.layout.activity_create_sensor }

    override fun chooseAction(action: Int) {
        when (action) {
            CreateSensorViewModel.OPEN_PREVIOUS_PAGE -> finish()
            else -> super.chooseAction(action)
        }
    }
}
