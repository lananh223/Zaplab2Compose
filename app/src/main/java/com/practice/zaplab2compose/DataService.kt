package com.practice.zaplab2compose

import com.practice.zaplab2compose.model.PhotoData
import retrofit2.http.GET

interface DataService {
    @GET("albums/1/photos")
    suspend fun getPhotoData(): List<PhotoData>
}