package com.codedirect.trafficnetsecurity.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.codedirect.trafficnetsecurity.BR
import org.jetbrains.anko.toast


abstract class AppFragment<T : ViewDataBinding> : Fragment() {

    protected abstract val layoutId: Int

    protected abstract val viewModel: AppViewModel

    protected val navigator by lazy { context?.let { AppNavigator(it) } }

    protected val binding by lazy {
        DataBindingUtil.inflate<T>(
            inflater,
            layoutId,
            container,
            false
        )
    }

    private lateinit var inflater: LayoutInflater
    private var container: ViewGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inflater = inflater
        this.container = container

        binding.lifecycleOwner = this
        binding.setVariable(BR.viewmodel, viewModel)
        binding.executePendingBindings()

        viewModel.action.observe(this, Observer { chooseAction(it) })
        viewModel.toast.observe(this, Observer { showMessage(it) })

        viewModel.init()

        return binding.root
    }

    protected open fun chooseAction(action: Int) {
        if (action != 0) viewModel.action.value = 0
    }

    protected open fun showMessage(message: String?) {
        message?.let {
            context?.toast(message)
            viewModel.toast.value = null
        }
    }

}