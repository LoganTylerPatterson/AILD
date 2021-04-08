package com.runtimeterror.aild.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.runtimeterror.aild.R
import com.runtimeterror.aild.databinding.ActivityMainBinding
import com.runtimeterror.aild.fragments.AlarmListFragment
import com.runtimeterror.aild.fragments.EntryListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //This sets up the bottom navigation bar for our app
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_alarms -> {
                    //Open up the alarm fragment
                    supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, AlarmListFragment())
                    .addToBackStack(null)
                    .commit()
                    true
                }
                R.id.action_journal -> {
                    //Open up the journal fragment
                    supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragment_container, EntryListFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.action_how_to ->{
                    //Open up the how to fragment :D
                    true
                }
                //Bitch please there is no "else"
                else -> true
            }
        }

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