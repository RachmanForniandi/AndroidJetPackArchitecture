package com.example.learnretrofitcoroutineapp.networkUtils

import com.example.learnretrofitcoroutineapp.models.Albums
import com.example.learnretrofitcoroutineapp.models.AlbumsItem
import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbumsData():Response<Albums>

    @GET("/albums")
    suspend fun getSortedAlbumsData(@Query("userId")userId:Int):Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value ="id")albumId:Int):Response<AlbumsItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album:AlbumsItem):Response<AlbumsItem>
}