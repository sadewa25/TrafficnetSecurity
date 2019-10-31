package com.codedirect.trafficnetsecurity.ui.login

import android.os.Bundle
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.databinding.ActivityLoginBinding
import com.codedirect.trafficnetsecurity.ui.AppActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppActivity<ActivityLoginBinding>() {

    override val viewModel by viewModel<LoginViewModel>()

    override val layoutId by lazy { R.layout.activity_login }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.init()
        shouldInit = false

        super.onCreate(savedInstanceState)
    }

    override fun chooseAction(action: Int) {
        when (action) {
            LoginViewModel.ACTION_OPEN_HOME -> navigator.openHome()
            LoginViewModel.ACTION_OPEN_REGISTRATION -> navigator.openRegistration()
            else -> super.chooseAction(action)
        }
    }
}
