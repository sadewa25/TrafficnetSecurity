package com.codedirect.trafficnetsecurity.ui.homesensor


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.ui.cctvlist.CCTVListFragment
import com.codedirect.trafficnetsecurity.ui.createsensor.CreateSensorActivity
import com.codedirect.trafficnetsecurity.ui.sensorlist.SensorListFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home_sensor.*

/**
 * A simple [Fragment] subclass.
 */
class HomeSensorFragment : Fragment() {

    private lateinit var starterIntent: Intent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home_sensor, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add.setOnClickListener { startActivity(starterIntent) }

        setupViewPager(vp_sensor, tabs_sensor, fragmentManager)
    }

    private fun setupViewPager(
        viewPager: ViewPager,
        tabLayout: TabLayout,
        manager: FragmentManager?
    ) {

        viewPager.adapter = HomeSensorViewPagerAdapter(manager).apply {
            addFragment(SensorListFragment(), context?.getString(R.string.title_sensors)!!)
            addFragment(CCTVListFragment(), context?.getString(R.string.title_cctv)!!)
        }

        tabLayout.setupWithViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    tv_main_sensor_title.text = getString(R.string.main_title_sensor)
                    tv_main_sensor_subtitle.text = getString(R.string.subtitle_sensor)
                    btn_add.text = getString(R.string.btn_sensor)
                    starterIntent = Intent(activity, CreateSensorActivity::class.java)
                } else {
                    tv_main_sensor_title.text = getString(R.string.main_title_cctv)
                    tv_main_sensor_subtitle.text = getString(R.string.subtitle_cctv)
                    btn_add.text = getString(R.string.btn_cctv)
                    starterIntent = Intent(activity, CreateSensorActivity::class.java)
                }
            }
        })
    }

}
