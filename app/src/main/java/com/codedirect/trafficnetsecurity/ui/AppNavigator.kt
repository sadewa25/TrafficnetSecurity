package com.codedirect.trafficnetsecurity.ui

import android.content.Context
import android.content.Intent
import com.codedirect.trafficnetsecurity.ui.home.HomeActivity
import com.codedirect.trafficnetsecurity.ui.login.LoginActivity
import com.codedirect.trafficnetsecurity.ui.register.RegisterActivity
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

}