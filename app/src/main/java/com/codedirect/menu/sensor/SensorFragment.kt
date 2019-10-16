package com.codedirect.menu.sensor


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.codedirect.menu.RegisterSensorActivity
import com.codedirect.menu.sensor.detail.CCTVFragment
import com.codedirect.menu.sensor.detail.SensorsFragment

import com.codedirect.trafficnetsecurity.R
import kotlinx.android.synthetic.main.fragment_sensor.*
import org.jetbrains.anko.sdk27.coroutines.onLayoutChange

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

        var starterIntent : Intent = Intent(getActivity(), RegisterSensorActivity::class.java)

        btn_add.setOnClickListener{
            startActivity(starterIntent)
        }

        setupViewPager(sensor_viewpager,fragmentManager)
        sensor_tabs.setupWithViewPager(sensor_viewpager)
        sensor_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
               if (position == 0){
                   title_fragment.text = "Sensor Pintu Rumah Anda"
                   subtitle_fragment.text = "Halaman ini menunjukkan semua status sensor pintu di rumah anda"
                   btn_add.text = "Tambah Sensor"
                   starterIntent = Intent(getActivity(), RegisterSensorActivity::class.java)
               } else {
                   title_fragment.text = "Semua Laporan CCTV Anda"
                   subtitle_fragment.text = "Halaman ini menunjukkan semua kegiatan dan status dari kegiatan yang telah dilakukan"
                   btn_add.text = "Tambah CCTV"
//                   starterIntent = Intent(getActivity(), RegisterCctvActivity::class.java)
               }
            }

        })

    }

    fun setupViewPager(viewPager: ViewPager, manager: FragmentManager?){
        var adapter: SensorViewPagerAdapter = SensorViewPagerAdapter(manager)
        adapter.addFragment(SensorsFragment(), context?.getString(R.string.title_sensors)!!)
        adapter.addFragment(CCTVFragment(),context?.getString(R.string.title_cctv)!!)

        viewPager.adapter = adapter
    }


}
