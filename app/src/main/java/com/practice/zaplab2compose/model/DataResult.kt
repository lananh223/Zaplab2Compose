package com.practice.zaplab2compose.model

sealed class DataResult {
    object Empty: DataResult()
    data class Success(val dataList: List<PhotoData>) : DataResult()
    data class Error(val error: Throwable): DataResult()
}