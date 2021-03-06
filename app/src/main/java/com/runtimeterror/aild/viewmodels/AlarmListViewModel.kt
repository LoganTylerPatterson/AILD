package com.runtimeterror.aild.viewmodels

import androidx.lifecycle.ViewModel
import com.runtimeterror.aild.db.Repository

class AlarmListViewModel: ViewModel() {

    private val alarmRepository = Repository.get()
    val alarmListLiveData = alarmRepository.getAlarms()

}