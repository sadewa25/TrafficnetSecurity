package com.codedirect.trafficnetsecurity.ui.home

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codedirect.trafficnetsecurity.R
import com.codedirect.trafficnetsecurity.ui.homedashboard.HomeDashboardFragment
import com.codedirect.trafficnetsecurity.ui.homeprofile.HomeProfileFragment
import com.codedirect.trafficnetsecurity.ui.homesensor.HomeSensorFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when (menu.itemId) {
            R.id.navigation_home -> {
                changeFragment(HomeDashboardFragment(), R.id.frame_main)
                return true
            }
            R.id.navigation_sensor -> {
                changeFragment(HomeSensorFragment(), R.id.frame_main)
                return true
            }
            R.id.navigation_profile -> {
                changeFragment(HomeProfileFragment(), R.id.frame_main)
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 10)
        }

        navView.setOnNavigationItemSelectedListener(this)
        changeFragment(HomeDashboardFragment(), R.id.frame_main)
    }


    fun changeFragment(fragment: Fragment, id: Int) {
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }

}
