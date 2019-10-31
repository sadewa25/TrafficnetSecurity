package com.codedirect.trafficnetsecurity.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codedirect.trafficnetsecurity.data.Outcome

abstract class AppViewModel : ViewModel() {

    open fun init() {}

    val action: MutableLiveData<Int> = MutableLiveData(0)
    val toast: MutableLiveData<String?> = MutableLiveData(null)

    fun <T> handle(outcome: Outcome<T>, success: Outcome<T>.() -> Unit) {
        with(outcome) {
            error?.let { toast.value = it }
            success()
        }
    }

}