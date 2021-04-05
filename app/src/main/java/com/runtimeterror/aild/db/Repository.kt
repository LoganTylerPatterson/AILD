package com.runtimeterror.aild.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.room.CoroutinesRoom
import androidx.room.Room
import com.runtimeterror.aild.db.AlarmDatabase
import com.runtimeterror.aild.db.entities.Alarm
import kotlinx.coroutines.*
import java.lang.IllegalStateException
import java.util.*
import kotlin.coroutines.CoroutineContext

private const val DATABASE_ALARM = "alarm-database"

class Repository private constructor(context: Context) {

    private val alarmDatabase: AlarmDatabase = Room.databaseBuilder(
            context.applicationContext,
            AlarmDatabase::class.java,
            DATABASE_ALARM
    ).build()

    private val alarmDao = alarmDatabase.dao()

    fun getAlarms(): LiveData<List<Alarm>> = alarmDao.getAllAlarms()

    fun getAlarm(id: Int, scope: CoroutineScope): LiveData<Alarm>?{
        var alarmLiveData:LiveData<Alarm>?= null
        scope.launch(Dispatchers.IO) {
            alarmLiveData = alarmDao.getAlarm(id)
        }
        return alarmLiveData
    }

    fun insertAlarm(alarm: Alarm) = alarmDao.insertAlarm(alarm)

    fun updateAlarm(alarm: Alarm) = alarmDao.updateAlarm(alarm)

    fun deleteAlarm(alarm: Alarm) = alarmDao.deleteAlarm(alarm)

    companion object {
        private var INSTANCE: Repository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = Repository(context)
            }
        }

        fun get(): Repository {
            return INSTANCE ?:
            throw IllegalStateException("Repository must be initialized")
        }
    }
}