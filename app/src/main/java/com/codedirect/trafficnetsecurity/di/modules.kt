package com.codedirect.trafficnetsecurity.di

import com.codedirect.trafficnetsecurity.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel { LoginViewModel(get()) }

}