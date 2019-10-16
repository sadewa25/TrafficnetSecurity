package com.codedirect.trafficnetsecurity

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codedirect.menu.HomeFragment
import com.codedirect.menu.ProfileFragment
import com.codedirect.menu.sensor.SensorFragment
import com.mapbox.mapboxsdk.maps.MapView
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when(menu?.itemId){
            R.id.navigation_home ->{
                changeFragment(HomeFragment(),R.id.frame_main)
                return true
            }
            R.id.navigation_sensor -> {
                changeFragment(SensorFragment(),R.id.frame_main)
                return true
            }
            R.id.navigation_profile -> {
                changeFragment(ProfileFragment(),R.id.frame_main)
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),10)
        }

        navView.setOnNavigationItemSelectedListener(this)
        changeFragment(HomeFragment(),R.id.frame_main)
    }


    fun changeFragment(fragment:Fragment, id:Int){
        supportFragmentManager.beginTransaction().replace(id,fragment).commit()
    }

}
