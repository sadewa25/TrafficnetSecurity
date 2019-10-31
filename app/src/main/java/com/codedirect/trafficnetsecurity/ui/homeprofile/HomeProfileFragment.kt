package com.codedirect.trafficnetsecurity.ui.homeprofile


import androidx.fragment.app.Fragment
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.databinding.FragmentHomeProfileBinding
import com.codedirect.trafficnetsecurity.ui.AppFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeProfileFragment : AppFragment<FragmentHomeProfileBinding>() {

    override val layoutId by lazy { R.layout.fragment_home_profile }

    override val viewModel by viewModel<HomeProfileViewModel>()

    override fun chooseAction(action: Int) {
        when (action) {
            HomeProfileViewModel.OPEN_CLEAR_LOGIN_PAGE -> navigator?.openLogin()
            else -> super.chooseAction(action)
        }
    }

}
