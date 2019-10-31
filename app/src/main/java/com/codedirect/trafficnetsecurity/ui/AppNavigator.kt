package com.codedirect.trafficnetsecurity.ui

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import com.codedirect.trafficnetsecurity.model.SensorModel
import com.codedirect.trafficnetsecurity.ui.home.HomeActivity
import com.codedirect.trafficnetsecurity.ui.login.LoginActivity
import com.codedirect.trafficnetsecurity.ui.register.RegisterActivity
import com.codedirect.trafficnetsecurity.ui.sensordetail.SensorDetailDialogFragment
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class AppNavigator(
    val context: Context
) {

    private val newTaskFlags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

    fun openHome(newTask: Boolean = true) {
        context.startActivity(context.intentFor<HomeActivity>().apply {
            if (newTask) addFlags(newTaskFlags)
        })
    }

    fun openLogin(newTask: Boolean = true) {
        context.startActivity(context.intentFor<LoginActivity>().apply {
            if (newTask) addFlags(newTaskFlags)
        })
    }

    fun openRegistration() {
        context.startActivity<RegisterActivity>()
    }

    fun showSensorDetail(fragmentManager: FragmentManager, sensorData: SensorModel) {
        SensorDetailDialogFragment()
            .setSensorData(sensorData)
            .show(fragmentManager, null)
    }

}