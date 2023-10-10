package com.practice.zaplab2compose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.zaplab2compose.model.DataRepository
import com.practice.zaplab2compose.model.DataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoViewModel(
    private val repository: DataRepository = DataRepository()
) : ViewModel() {

    private val _photoDataStateFlow: MutableStateFlow<DataResult> =
        MutableStateFlow(DataResult.Empty)
    val itemPhotoDataStateFlow: StateFlow<DataResult> = _photoDataStateFlow.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getPhotoData()
            }
            _photoDataStateFlow.emit(result)
        }
    }
}