package com.codedirect.trafficnetsecurity.ui.sensorlist


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.databinding.FragmentSensorListBinding
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.ui.AppFragment
import com.codedirect.trafficnetsecurity.ui.AppListAdapter
import kotlinx.android.synthetic.main.fragment_sensor_list.*
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class SensorListFragment : AppFragment<FragmentSensorListBinding>() {

    override val layoutId by lazy { R.layout.fragment_sensor_list }

    override val viewModel by viewModel<SensorListViewModel>()

    private val sensorListAdapter by lazy {
        SensorListAdapter(object : AppListAdapter.ItemViewClickListener<DataModel> {
            override fun onClick(data: DataModel, position: Int) {
                toast(data.title)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv_sensor.layoutManager = LinearLayoutManager(context)
        rv_sensor.adapter = sensorListAdapter

        viewModel.sensorList.observe(this, Observer {
            with(sensorListAdapter) {
                dataList.clear()
                dataList.addAll(it)
                notifyDataSetChanged()
            }
        })
    }

}
