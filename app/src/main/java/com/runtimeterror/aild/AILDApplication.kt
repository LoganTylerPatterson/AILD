package com.runtimeterror.aild

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.runtimeterror.aild.db.Repository


class AILDApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        Repository.initialize(this)
        createNotificationChannel()
    }

    private fun createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Alarm Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
            
        }
    }
}