package com.runtimeterror.aild.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.db.entities.Journal

@Dao
interface JournalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJournal(journal: Journal)

    @Delete
    fun deleteJournal(journal: Journal)

    @Query("SELECT * FROM journal")
    fun getAllJournals(): LiveData<List<Journal>>

    @Query("SELECT * FROM journal WHERE id = :id")
    fun getJournal(id: Int): LiveData<Journal>?

    @Update
    fun updateJournal(journal: Journal)

}