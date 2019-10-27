package com.codedirect.trafficnetsecurity.ui.sensorlist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedirect.trafficnetsecurity.model.DataModel
import com.codedirect.trafficnetsecurity.R
import kotlinx.android.synthetic.main.fragment_home_sensor.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class SensorListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_sensor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataItems = arrayListOf<DataModel?>()

        val info = arrayListOf<String>("Aman", "Indikasi", "Bahaya")
        val status = arrayListOf<String>("Online", "Offline")

        for (ite in 0..10) {
            dataItems.add(
                DataModel(
                    "",
                    "Pintu " + ite,
                    info[Random.nextInt(0, 2)],
                    status[Random.nextInt(0, 1)]
                )
            )
        }

        val adapter = SensorListAdapter(dataItems) {}

        rv_sensor.layoutManager = LinearLayoutManager(context)
        rv_sensor.adapter = adapter

    }


}
