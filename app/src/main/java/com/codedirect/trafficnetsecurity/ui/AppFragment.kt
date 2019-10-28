package com.codedirect.trafficnetsecurity.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.codedirect.trafficnetsecurity.BR


abstract class AppFragment<T : ViewDataBinding> : Fragment() {

    protected abstract val layoutId: Int

    protected abstract val viewModel: AppViewModel

    private lateinit var inflater: LayoutInflater
    private var container: ViewGroup? = null

    protected val binding by lazy {
        DataBindingUtil.inflate<T>(
            inflater,
            layoutId,
            container,
            false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inflater = inflater
        this.container = container

        binding.setVariable(BR.viewmodel, viewModel)
        binding.executePendingBindings()

        viewModel.init()

        return binding.root
    }

}