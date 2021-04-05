package com.runtimeterror.aild.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.runtimeterror.aild.db.dao.AlarmDao
import com.runtimeterror.aild.db.entities.Alarm

@Database(entities = [Alarm::class], version = 3)
@TypeConverters(AlarmTypeConverters::class)
abstract class AlarmDatabase: RoomDatabase() {
    abstract fun dao(): AlarmDao
}