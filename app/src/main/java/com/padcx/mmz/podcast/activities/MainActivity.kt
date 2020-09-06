package com.padcx.mmz.podcast.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcx.mmz.podcast.R
import com.padcx.mmz.podcast.fragment.DownloadFragment
import com.padcx.mmz.podcast.fragment.HomeFragment
import com.padcx.mmz.podcast.fragment.ProfileFragment
import com.padcx.mmz.podcast.fragment.SearchFragment
import com.padcx.mmz.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swapFragment(HomeFragment.newInstance(this))

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_home -> {
                        swapFragment(HomeFragment.newInstance(this@MainActivity))
                        return true
                    }
                    R.id.action_search -> {
                        swapFragment(SearchFragment.newInstance(this@MainActivity))
                        return true
                    }
                    R.id.action_download -> {
                        swapFragment(DownloadFragment.newInstance(this@MainActivity))
                        return true
                    }
                    R.id.action_profile -> {
                        swapFragment(ProfileFragment.newInstance(this@MainActivity))
                        return true
                    }
                }
                return false
            }

        })


    }

    private fun swapFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flBottomNavigationContainer, fragment)
            .commit()

    }
}