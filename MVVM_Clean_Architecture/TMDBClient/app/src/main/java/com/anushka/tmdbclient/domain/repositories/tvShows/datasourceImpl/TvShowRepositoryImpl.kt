package com.anushka.tmdbclient.domain.repositories.TvShow.datasourceImpl

import android.util.Log
import com.anushka.tmdbclient.domain.repositories.tvShows.TvShowRepository
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowCacheDataSource
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowLocalDataSource
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowRemoteDataSource
import com.anushka.tmdbclient.models.tvshow.TvShow

class TvShowRepositoryImpl(private val tvShowRemoteDataSource: TvShowRemoteDataSource,
                           private val tvShowLocalDataSource: TvShowLocalDataSource,
                           private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {


    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDb(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try{
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if(body != null){
                tvShowList = body.tvShows
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow>? {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getArtistsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }

    suspend fun getArtistsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDb()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDb(tvShowList)
        }
        return tvShowList
    }


}