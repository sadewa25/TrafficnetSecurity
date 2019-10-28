package com.codedirect.trafficnetsecurity.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class AppViewModel : ViewModel() {

    open fun init() {}

    val action: MutableLiveData<Int> = MutableLiveData(0)
    val toast: MutableLiveData<String?> = MutableLiveData(null)

}