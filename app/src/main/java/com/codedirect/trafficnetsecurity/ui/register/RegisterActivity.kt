package com.codedirect.trafficnetsecurity.ui.register

import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.databinding.ActivityRegisterBinding
import com.codedirect.trafficnetsecurity.ui.AppActivity
import org.koin.android.ext.android.inject

class RegisterActivity : AppActivity<ActivityRegisterBinding>() {

    override val viewModel by inject<RegisterViewModel>()

    override val layoutId by lazy { R.layout.activity_register }

    override fun chooseAction(action: Int) {
        when (action) {
            RegisterViewModel.OPEN_LOGIN_PAGE -> navigator.openLogin()
            else -> super.chooseAction(action)
        }
    }

}
