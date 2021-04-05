package com.runtimeterror.aild.recievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.runtimeterror.aild.AUTO_DISMISS
import com.runtimeterror.aild.SECONDS
import com.runtimeterror.aild.SOUND
import com.runtimeterror.aild.TITLE
import com.runtimeterror.aild.service.AlarmService
import com.runtimeterror.aild.service.RescheduleAlarmService

private const val TAG = "AlarmBroadCastReciever"
class AlarmBroadCastReciever : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "AlarmBroadCast onRecieve called")
        startAlarmService(context, intent)
    }

    private fun startAlarmService(context: Context?, intent: Intent?) {
        Log.i(TAG, "Starting alarm Service")
        val intentService = Intent(context, AlarmService::class.java)
        intentService.putExtra(TITLE, intent?.getStringExtra(TITLE))
        intentService.putExtra(SOUND, intent?.getIntExtra(SOUND,0))
        intentService.putExtra(SECONDS, intent?.getIntExtra(SECONDS, 5))
        intentService.putExtra(AUTO_DISMISS, intent?.getBooleanExtra(AUTO_DISMISS, false))

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            context?.startForegroundService(intentService)
        } else {
            context?.startService(intentService)
        }
    }

    private fun startRescheduleAlarmService(context: Context?) {
        val intentService = Intent(context, RescheduleAlarmService::class.java)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            context?.startForegroundService(intentService)
        } else {
            context?.startService(intentService)
        }

    }

}
