package com.runtimeterror.aild.util

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.runtimeterror.aild.*
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.recievers.AlarmBroadCastReciever
import java.util.*


/**This method is used to make other methods cleaner, all it does is replace the current fragment
 * ...with a destination fragment
 **/
private val TAG = "Util"
fun replaceFragment(fm: FragmentManager, frag: Fragment) {
    fm
        .beginTransaction()
        .replace(R.id.fragment_container, frag)
        .addToBackStack(null)
        .commit()
}

/**
 * Formats the date from the hour and minute given
 */
fun getDateString(hour: Int, min: Int): String {
    return if (min < 10 && hour > 12) { //if min is less than ten and we are in pm
        "${(hour - 12)}:0$min"
    } else if (min < 10) { //If min is less than ten but we arent in pm
        "$hour:0$min"
    } else if (hour > 12) { //Only if we are in pm
        "${hour - 12}:$min"
    } else if (hour == 0 && min < 10) {//This is to handle the 12 hour in the am and minutes are less than ten
        "12:0$min"
    } else if (hour == 0) { //If 12 am(hour ==0) and the min is over 10
        "12:$min"
    } else { //Everything else
        "$hour:$min"
    }
}

/**
 * Do to lovely android deprecation every 6 months, this is a util object to
 * deal with different build versions for getting a time from a time picker
 */
object TimePickerUtil {
    fun getTimePickerHour(tp: TimePicker): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tp.hour
        } else {
            tp.currentHour
        }
    }

    fun getTimePickerMinute(tp: TimePicker): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tp.minute
        } else {
            tp.currentMinute
        }
    }
}

/**
 * This creates and alarm with alarmManager and uses a pending intent to start the alarm
 * using the alarm service from the android system
 */
fun setAlarm(alarm: Alarm, context: Context?) {
    val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmBroadCastReciever::class.java)

    intent.putExtra(RECURRING, false)
    intent.putExtra(TITLE, alarm.title)
    intent.putExtra(SOUND, alarm.sound)

    val alarmPendingIntent = PendingIntent.getBroadcast(context, alarm.id, intent, 0)
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, alarm.hour)
    calendar.set(Calendar.MINUTE, alarm.minute)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)

    //TODO make this bitch work right when the time set is before the current system time
    Log.e(TAG, "Alarm time is ${calendar.timeInMillis} System time is ${System.currentTimeMillis()}")
    if(calendar.timeInMillis < System.currentTimeMillis()){
        Log.e(TAG, "Less than now big dummy, set it for tomorrow")
        calendar.set(Calendar.DAY_OF_WEEK, calendar.get(Calendar.DAY_OF_WEEK) + 1)
    }

    alarmManager.setExact(
        AlarmManager.RTC_WAKEUP,
        calendar.timeInMillis,
        alarmPendingIntent
    )
}

/**
 * This cancels an existing alarm, very similar to creating an alarm service
 */
fun cancelAlarm(alarm: Alarm, context: Context?) {
    val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmBroadCastReciever::class.java)
    val alarmPendingIntent = PendingIntent.getBroadcast(context, alarm.id, intent, 0)
    alarmManager.cancel(alarmPendingIntent)
}