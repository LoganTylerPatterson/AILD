package com.runtimeterror.aild.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.runtimeterror.aild.db.dao.AlarmDao
import com.runtimeterror.aild.db.dao.JournalDao
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.db.entities.Journal

@Database(entities = [Alarm::class, Journal::class], version = 5)
@TypeConverters(com.runtimeterror.aild.db.TypeConverters::class)
abstract class Database: RoomDatabase() {
    abstract fun alarmDao(): AlarmDao
    abstract fun journalDao(): JournalDao
}