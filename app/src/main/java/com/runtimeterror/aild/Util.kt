package com.runtimeterror.aild

import android.os.Build
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


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

fun getDateString(hour: Int? = 0, min: Int? = 0): String{
    val str = "${hour.toString()}:${min.toString()}"
    return str
}

/**Do to lovely android deprecation every 6 months, this is a util object to
 * ... deal with different build versions for getting a time from a time picker
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
