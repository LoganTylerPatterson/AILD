package com.runtimeterror.aild.activities

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.runtimeterror.aild.databinding.ActivityRingBinding
import com.runtimeterror.aild.service.AlarmService

class RingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDismiss.setOnClickListener {
            //This turns of the service that we created in AlarmService, stops playing, vibrating,
            //And finishes this activity
            val intentService = Intent(applicationContext, AlarmService::class.java)
            applicationContext.stopService(intentService)
            finish()
        }

        animateClock()
    }

    private fun animateClock(){
        val rotateAnimation = ObjectAnimator.ofFloat(binding.ivAcClock, "rotation", 0f, 20f, 0f, -20f, 0f)
        rotateAnimation.repeatCount = ValueAnimator.INFINITE
        rotateAnimation.duration = 800
        rotateAnimation.start()
    }
}
