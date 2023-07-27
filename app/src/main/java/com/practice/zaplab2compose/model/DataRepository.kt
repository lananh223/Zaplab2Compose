package com.practice.zaplab2compose.model

import com.google.gson.GsonBuilder
import com.practice.zaplab2compose.DataService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class DataRepository {

    private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val dataService = retrofit.create(DataService::class.java)

    fun getPhotoData(): Flow<List<PhotoData>> = flow {
        val result = dataService.getPhotoData()
        emit(result)
    }
}