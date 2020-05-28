package com.example.learnretrofitcoroutineapp.networkUtils

import com.example.learnretrofitcoroutineapp.models.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbumsData():Response<Albums>

    @GET("/albums")
    suspend fun getSortedAlbumsData(@Query("userId")userId:Int):Response<Albums>
}