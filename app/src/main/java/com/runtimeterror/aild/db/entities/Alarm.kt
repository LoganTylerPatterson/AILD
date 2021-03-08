package com.runtimeterror.aild.db.entities

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarm")
data class Alarm(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        var title: String,
        var hour: Int,
        var minute: Int,
        var am: Boolean = true,
        var active: Boolean = true,
        var autoOff: Boolean = true,
        var repeat: Boolean = false,
        var sound: Uri
)