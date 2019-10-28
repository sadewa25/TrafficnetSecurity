package com.codedirect.trafficnetsecurity.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class AppViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext = Dispatchers.Main

    val action: MutableLiveData<Int> = MutableLiveData(0)
    val toast: MutableLiveData<String?> = MutableLiveData(null)

}