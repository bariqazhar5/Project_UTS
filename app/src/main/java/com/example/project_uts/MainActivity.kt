package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstfragment = firstfragment()
        val secondfragment = secondfragment()
        val thirdfragment = thirdfragment()

        setCurrentFragment(firstfragment)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.mUnit -> setCurrentFragment(firstfragment)
                R.id.mMoney -> setCurrentFragment(secondfragment)
                R.id.mSetting -> setCurrentFragment(thirdfragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}