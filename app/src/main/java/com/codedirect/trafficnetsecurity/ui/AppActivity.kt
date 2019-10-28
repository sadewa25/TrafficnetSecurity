package com.codedirect.trafficnetsecurity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.codedirect.trafficnetsecurity.BR
import org.jetbrains.anko.toast

abstract class AppActivity<T : ViewDataBinding> : AppCompatActivity() {

    protected val navigator by lazy { AppNavigator(this) }

    protected val binding by lazy { DataBindingUtil.setContentView<T>(this, layoutId) }

    protected abstract val viewModel: AppViewModel

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.setVariable(BR.viewmodel, viewModel)
        binding.executePendingBindings()

        viewModel.action.observe(this, Observer { chooseAction(it) })
        viewModel.toast.observe(this, Observer { showMessage(it) })

        viewModel.init()
    }

    protected open fun chooseAction(action: Int) {
        if (action != 0) viewModel.action.value = 0
    }

    protected open fun showMessage(message: String?) {
        message?.let {
            toast(message)
            viewModel.toast.value = null
        }
    }

}