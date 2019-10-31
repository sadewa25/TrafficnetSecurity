package com.codedirect.trafficnetsecurity.di

import com.codedirect.trafficnetsecurity.ui.cctvlist.CCTVListViewModel
import com.codedirect.trafficnetsecurity.ui.login.LoginViewModel
import com.codedirect.trafficnetsecurity.ui.register.RegisterViewModel
import com.codedirect.trafficnetsecurity.ui.sensorlist.SensorListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { SensorListViewModel(get()) }
    viewModel { CCTVListViewModel(get()) }

}