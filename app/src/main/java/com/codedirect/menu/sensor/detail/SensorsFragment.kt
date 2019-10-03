package com.codedirect.menu.sensor.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedirect.model.DataModel

import com.codedirect.trafficnetsecurity.R
import kotlinx.android.synthetic.main.fragment_sensors.*

/**
 * A simple [Fragment] subclass.
 */
class SensorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sensors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataItems = arrayListOf<DataModel?>()
        for (i in 0 until 10)
            dataItems.add(DataModel("","Pintu 1"))
        val adapter = AdapterSensor(dataItems){}

        sensor_recycler.layoutManager = LinearLayoutManager(context)
        sensor_recycler.adapter = adapter

    }


}
