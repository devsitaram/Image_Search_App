package com.edu.imagesearch.data.source.remote.network

import com.edu.imagesearch.data.source.remote.pojo.PixabayDTO
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://pixabay.com/"

// https://pixabay.com/api/?key=39343490-929c50e58ac235a67f48917fa&q=sunflower

interface ApiService {

    @GET("api/")
    suspend fun getSearchImage(@Query("key") key: String, @Query("q") query: String): PixabayDTO

}