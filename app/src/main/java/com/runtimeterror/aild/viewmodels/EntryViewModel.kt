package com.runtimeterror.aild.viewmodels

import androidx.lifecycle.*
import com.runtimeterror.aild.db.Repository
import com.runtimeterror.aild.db.entities.Journal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntryViewModel: ViewModel() {

    private val repository = Repository.get()
    var entryIdLiveData = MutableLiveData<Int>()

    var entryLiveData: LiveData<Journal> =
        Transformations.switchMap(entryIdLiveData) { entryId ->
            repository.getJournal(entryId, viewModelScope)
        }

    fun loadEntry(entryId: Int) {
        entryIdLiveData.value = entryId
    }

    fun insertEntry(journal: Journal) {
        viewModelScope.launch(Dispatchers.IO){
            repository.insertJournal(journal)
        }
    }

    fun updateEntry(journal: Journal) {
        viewModelScope.launch(Dispatchers.IO){
            repository.insertJournal(journal)
        }
    }

    fun deleteEntry(journal: Journal){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteJournal(journal)
        }
    }
}
