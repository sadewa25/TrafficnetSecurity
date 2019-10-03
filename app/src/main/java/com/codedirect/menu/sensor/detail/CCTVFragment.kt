package com.codedirect.menu.sensor.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedirect.model.DataModel

import com.codedirect.trafficnetsecurity.R
import kotlinx.android.synthetic.main.fragment_cctv.*

class CCTVFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cctv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataItems = arrayListOf<DataModel?>()
        for (i in 0 until 10)
            dataItems.add(DataModel("","CCTV Halaman"))
        val adapter = AdapterSensor(dataItems){}

        cctv_recycler.layoutManager = LinearLayoutManager(context)
        cctv_recycler.adapter = adapter
    }


}
