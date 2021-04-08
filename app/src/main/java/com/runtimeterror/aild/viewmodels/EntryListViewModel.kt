package com.runtimeterror.aild.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.runtimeterror.aild.db.Repository

class EntryListViewModel: ViewModel() {

    private val repository = Repository.get()
    var journalListLiveData = repository.getJournals()
}