package com.codedirect.trafficnetsecurity.ui.cctvlist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.ui.sensorlist.SensorListAdapter
import kotlinx.android.synthetic.main.fragment_cctv_list.*
import kotlin.random.Random

class CCTVListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cctv_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataItems = arrayListOf<DataModel?>()

        val info = arrayListOf<String>("Aman", "Indikasi", "Bahaya")
        val status = arrayListOf<String>("Online", "Offline")

        for (i in 0 until 10) {
            dataItems.add(
                DataModel(
                    "",
                    "CCTV Halaman",
                    info[Random.nextInt(0, 2)],
                    status[Random.nextInt(0, 1)]
                )
            )
        }
        val adapter = SensorListAdapter(dataItems) {}

        rv_cctv.layoutManager = LinearLayoutManager(context)
        rv_cctv.adapter = adapter
    }


}
