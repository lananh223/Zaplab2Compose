package com.practice.zaplab2compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.practice.zaplab2compose.model.DataRepository
import com.practice.zaplab2compose.model.PhotoData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class PhotoViewModel : ViewModel() {
    lateinit var photoData: LiveData<List<PhotoData>>
    fun getDataFomRepository(repository: DataRepository): LiveData<List<PhotoData>> {

        //Convert flow to livedata using asLiveData()
        viewModelScope.launch {
            photoData = repository.getPhotoData().asLiveData(Dispatchers.IO)
        }
        return photoData
    }
}