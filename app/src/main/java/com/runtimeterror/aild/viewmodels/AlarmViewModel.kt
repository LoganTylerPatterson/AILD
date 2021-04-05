package com.runtimeterror.aild.viewmodels

import androidx.lifecycle.*
import com.runtimeterror.aild.db.Repository
import com.runtimeterror.aild.db.entities.Alarm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class AlarmViewModel : ViewModel() {

    private val alarmRepository = Repository.get()
    var alarmIdLiveData = MutableLiveData<Int>()

    val alarmLiveData: LiveData<Alarm> =
        Transformations.switchMap(alarmIdLiveData) { alarmId ->
            alarmRepository.getAlarm(alarmId,viewModelScope)
        }

    fun loadAlarm(alarmId: Int) {
        alarmIdLiveData.value = alarmId
    }

    fun insertAlarm(alarm: Alarm) {
        viewModelScope.launch(Dispatchers.IO)
        { alarmRepository.insertAlarm(alarm) }
    }

    fun updateAlarm(alarm: Alarm) {
        viewModelScope.launch(Dispatchers.IO){
            alarmRepository.updateAlarm(alarm)
        }
    }

    fun deleteAlarm(alarm: Alarm){
        viewModelScope.launch(Dispatchers.IO) {
            alarmRepository.deleteAlarm(alarm)
        }
    }

}