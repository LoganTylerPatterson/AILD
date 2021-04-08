package com.runtimeterror.aild.db.entities

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "alarm")
data class Alarm(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var title: String? = "My Alarm",
        var hour: Int = 12,
        var minute: Int = 12,
        var dayHalf: String = "AM",
        var active: Boolean = true,
        var autoOff: Boolean = false,
        var autoOffDuration: Int = 5,
        var repeat: Boolean = false,
        var sound: Int = 0
)