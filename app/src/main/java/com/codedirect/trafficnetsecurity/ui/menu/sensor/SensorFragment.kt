package com.codedirect.trafficnetsecurity.ui.menu.sensor


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.codedirect.trafficnetsecurity.ui.menu.RegisterSensorActivity
import com.codedirect.trafficnetsecurity.ui.menu.sensor.detail.CCTVFragment
import com.codedirect.trafficnetsecurity.ui.menu.sensor.detail.SensorsFragment
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
        return inflater.inflate(R.layout.fragment_sensor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var starterIntent: Intent = Intent(activity, RegisterSensorActivity::class.java)

        btn_add.setOnClickListener {
            startActivity(starterIntent)

        }

        setupViewPager(vp_sensor, fragmentManager)
        tabs_sensor.setupWithViewPager(vp_sensor)
        vp_sensor.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    tv_main_sensor_title.text = getString(R.string.main_title_sensor)
                    tv_main_sensor_subtitle.text = getString(R.string.subtitle_sensor)
                    btn_add.text = getString(R.string.btn_sensor)
                    starterIntent = Intent(activity, RegisterSensorActivity::class.java)
                } else {
                    tv_main_sensor_title.text = getString(R.string.main_title_cctv)
                    tv_main_sensor_subtitle.text = getString(R.string.subtitle_cctv)
                    btn_add.text = getString(R.string.btn_cctv)
//                   starterIntent = Intent(activity, RegisterCctvActivity::class.java)
                }
            }

        })

    }

    fun setupViewPager(viewPager: ViewPager, manager: FragmentManager?) {
        var adapter: SensorViewPagerAdapter = SensorViewPagerAdapter(manager)
        adapter.addFragment(SensorsFragment(), context?.getString(R.string.title_sensors)!!)
        adapter.addFragment(CCTVFragment(), context?.getString(R.string.title_cctv)!!)

        viewPager.adapter = adapter
    }


}
