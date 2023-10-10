package com.practice.zaplab2compose.model

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class DataRepository {

    private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    private val dataService = retrofit.create(DataService::class.java)

    suspend fun getPhotoData(): DataResult {
        return kotlin.runCatching {
            dataService.getPhotoData()
        }.fold(
            onSuccess = { dataList ->
                DataResult.Success(dataList)
            },
            onFailure = { DataResult.Error(it) }
        )
    }
}