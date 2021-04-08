package com.runtimeterror.aild.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.db.entities.Journal
import kotlinx.coroutines.*
import java.lang.IllegalStateException
import java.util.*

//This was effed up, it really should just be named database
private const val DATABASE_ALARM = "alarm-database"

class Repository private constructor(context: Context) {

    private val database: Database = Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            DATABASE_ALARM
    ).build()

    private val alarmDao = database.alarmDao()

    private val journalDao = database.journalDao()

    /**
     * ALARM FUNCTIONS
     */
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

    /**
     * JOURNAL FUNCTIONS
     */
    fun getJournals(): LiveData<List<Journal>> = journalDao.getAllJournals()

    fun getJournal(id: Int, scope: CoroutineScope): LiveData<Journal>?{
        var journalLiveData: LiveData<Journal>? = null
        scope.launch(Dispatchers.IO) {
            journalLiveData = journalDao.getJournal(id)
        }
        return journalLiveData
    }

    fun insertJournal(journal: Journal) = journalDao.insertJournal(journal)

    fun updateJournal(journal: Journal) = journalDao.updateJournal(journal)

    fun deleteJournal(journal: Journal) = journalDao.deleteJournal(journal)


    /**
     * Instatiates the repository upon app creation
     */
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