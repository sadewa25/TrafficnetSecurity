package com.codedirect.menu.sensor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.codedirect.menu.sensor.detail.CCTVFragment
import com.codedirect.menu.sensor.detail.SensorsFragment

import com.codedirect.trafficnetsecurity.R
import kotlinx.android.synthetic.main.fragment_sensor.*

/**
 * A simple [Fragment] subclass.
 */
class SensorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sensor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager(sensor_viewpager,fragmentManager)
        sensor_tabs.setupWithViewPager(sensor_viewpager)
    }

    fun setupViewPager(viewPager: ViewPager, manager: FragmentManager?){
        var adapter: SensorViewPagerAdapter = SensorViewPagerAdapter(manager)
        adapter.addFragment(SensorsFragment(), context?.getString(R.string.title_sensors)!!)
        adapter.addFragment(CCTVFragment(),context?.getString(R.string.title_cctv)!!)
        viewPager.adapter = adapter
    }


}
