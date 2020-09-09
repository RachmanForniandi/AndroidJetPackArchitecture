package com.anushka.tmdbclient.models.artist


import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val results: List<Artist>,


    @SerializedName("page")
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)