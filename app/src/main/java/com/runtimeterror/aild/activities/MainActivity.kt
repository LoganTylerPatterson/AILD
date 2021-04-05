package com.runtimeterror.aild.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.runtimeterror.aild.R
import com.runtimeterror.aild.databinding.ActivityMainBinding
import com.runtimeterror.aild.fragments.AlarmListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Sets up the top app bar and enables an upp arrow
        setSupportActionBar(binding.toolbar)

        //Places the AlarmListFragment on top
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, AlarmListFragment())
            .addToBackStack(null)
            .commit()
    }
}