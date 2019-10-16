package com.codedirect.menu.sensor.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedirect.model.DataModel
import com.codedirect.trafficnetsecurity.R
import kotlinx.android.synthetic.main.fragment_sensors.*
import kotlin.random.Random

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

        val adapter = AdapterSensor(dataItems) {}

        sensor_recycler.layoutManager = LinearLayoutManager(context)
        sensor_recycler.adapter = adapter

    }


}
