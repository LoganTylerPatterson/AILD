package com.runtimeterror.aild.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.runtimeterror.aild.db.entities.Alarm
import java.util.*

@Dao
interface AlarmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlarm(alarm: Alarm)

    @Delete
    fun deleteAlarm(alarm: Alarm)

    @Query("SELECT * FROM alarm")
    fun getAllAlarms(): LiveData<List<Alarm>>

    @Query("SELECT * FROM alarm WHERE id = :id")
    fun getAlarm(id: UUID): LiveData<Alarm>?

    @Update
    fun updateAlarm(alarm: Alarm)
}