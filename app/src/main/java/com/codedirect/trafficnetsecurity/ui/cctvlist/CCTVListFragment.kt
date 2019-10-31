package com.codedirect.trafficnetsecurity.ui.cctvlist


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.databinding.FragmentCctvListBinding
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.ui.AppFragment
import com.codedirect.trafficnetsecurity.ui.AppListAdapter
import kotlinx.android.synthetic.main.fragment_cctv_list.*
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class CCTVListFragment : AppFragment<FragmentCctvListBinding>() {

    override val layoutId by lazy { R.layout.fragment_cctv_list }

    override val viewModel by viewModel<CCTVListViewModel>()

    private val cctvListAdapter by lazy {
        CCTVListAdapter(object : AppListAdapter.ItemViewClickListener<DataModel> {
            override fun onClick(data: DataModel, position: Int) {
                toast(data.title)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv_cctv.layoutManager = LinearLayoutManager(context)
        rv_cctv.adapter = cctvListAdapter

        viewModel.cctvList.observe(this, Observer {
            with(cctvListAdapter) {
                dataList.clear()
                dataList.addAll(it)
                notifyDataSetChanged()
            }
        })
    }

}
