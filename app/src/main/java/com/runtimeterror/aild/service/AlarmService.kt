package com.runtimeterror.aild.service

import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.os.Vibrator
import android.util.Log
import androidx.core.app.NotificationCompat
import com.runtimeterror.aild.CHANNEL_ID
import com.runtimeterror.aild.R
import com.runtimeterror.aild.RingActivity
import com.runtimeterror.aild.TITLE

private const val TAG = "AlarmService"
class AlarmService: Service() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var vibrator: Vibrator

    override fun onCreate() {
        /**
         * This instantiates a mediaplayer and a vibrator, it also attaches a sound(mp3) to the mediaPlayer
         * with the R.raw... reference
         * //TODO Need to make this something where I can pass in a unique sound
         */
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.bubble)
        mediaPlayer.isLooping = true
        Log.e(TAG, "In AlarmService onCreate")
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        /**
         * When somebody asks that this service gets done is when this is called.
         * Here the service is started, in our case, we play a sound, vibrate the phone, and
         * send a notification to the screen
         */
        Log.e(TAG, "In onStartCommand")
        val notificationIntent = Intent(this, RingActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val alarmTitle = String.format("${intent?.getStringExtra(TITLE)} Alarm")

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(alarmTitle)
            .setContentText("Are you dreaming?")
            .setSmallIcon(R.drawable.icon_alarm_small)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true) //Automatically removes the notification when the user taps it
            .build()

        mediaPlayer.start()

        val pattern = longArrayOf(0, 100, 1000)
        vibrator.vibrate(pattern, 0)//TODO replace this with api if block
        startForeground(2, notification)//TODO maybe change id to const var
        Log.e(TAG, "Do we get here?")

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        vibrator.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}