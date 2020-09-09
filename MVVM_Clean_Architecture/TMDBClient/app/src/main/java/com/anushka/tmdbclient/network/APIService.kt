package com.anushka.tmdbclient.network

import com.anushka.tmdbclient.models.artist.ArtistList
import com.anushka.tmdbclient.models.movie.MovieList
import com.anushka.tmdbclient.models.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apiKey:String):Response<TvShowList>

    @GET("artist/popular")
    suspend fun getPopularArtist(@Query("api_key")apiKey:String):Response<ArtistList>
}