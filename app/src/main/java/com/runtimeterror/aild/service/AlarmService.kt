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
import com.runtimeterror.aild.*
import com.runtimeterror.aild.activities.RingActivity
import java.util.*
import java.util.concurrent.Executor

private const val TAG = "AlarmService"

/**
 * @autoDismiss decides whether the user wants to dismiss the alarm
 * @seconds determine how long before dismissing the alarm, default is five seconds
 */
class AlarmService: Service() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var vibrator: Vibrator

    override fun onCreate() {
        /**
         * This instantiates a mediaplayer and a vibrator, it also attaches a sound(mp3) to the mediaPlayer
         * with the R.raw... reference
         */
        super.onCreate()
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        /**
         * When somebody asks that this service gets done is when this is called.
         * Here the service is started, in our case, we play a sound, vibrate the phone, and
         * send a notification to the screen
         */
        Log.e(TAG, "In onStartCommand")
        val alarmSound = intent?.getIntExtra(SOUND, R.raw.bubble)
        if(alarmSound == R.raw.bubble){
            Log.e(TAG, "alarmSound was not passed in")
        }
        mediaPlayer = MediaPlayer.create(this, alarmSound ?: R.raw.slowmotion)
        mediaPlayer.isLooping = false
        val notificationIntent = Intent(this, RingActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val alarmTitle = String.format("${intent?.getStringExtra(TITLE)} Alarm")

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(alarmTitle)
            .setContentText("Are you dreaming?")
            .setSmallIcon(R.drawable.icon_alarm_small)
            .setContentIntent(pendingIntent)
            .setSound(null)
            .setAutoCancel(true) //Automatically removes the notification when the user taps it
            .build()

        mediaPlayer.start()

        val pattern = longArrayOf(0, 100, 1000)
        vibrator.vibrate(pattern, 0)//TODO replace this with api if block
        startForeground(2, notification)//TODO maybe change id to const var

        //Dismiss alarm after 5 seconds
        if(intent?.getBooleanExtra(AUTO_DISMISS, false) == true){
            dismiss(intent.getIntExtra(SECONDS, 5))
        }

        return START_STICKY
    }

    /**
     * Turn off the pinche alarm if they have autodismiss selected
     */
    fun dismiss(seconds: Int){
        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intentService = Intent(applicationContext, AlarmService::class.java)
                applicationContext.stopService(intentService)
            }
        },  seconds*1000L)
    }

    /**
     * Turn off the pinche alarm
     */
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        vibrator.cancel()
    }

    /**
     * Who the fuck knows what this does
     */
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}