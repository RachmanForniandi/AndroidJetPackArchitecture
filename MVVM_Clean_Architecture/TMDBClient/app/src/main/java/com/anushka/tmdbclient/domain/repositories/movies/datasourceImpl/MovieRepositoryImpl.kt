package com.anushka.tmdbclient.domain.repositories.movies.datasourceImpl

import android.util.Log
import com.anushka.tmdbclient.domain.repositories.movies.MovieRepository
import com.anushka.tmdbclient.models.movie.Movie
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieRemoteDataSource

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource,
                          private val movieLocalDataSource: MovieLocalDataSource,
                          private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {


    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDb(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }


        return movieList
    }

     suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDb()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDb(movieList)
        }
        return movieList
    }


}