package com.anushka.tmdbclient.domain.repositories.TvShow.datasourceImpl

import com.anushka.tmdbclient.models.movie.Movie
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowCacheDataSource
import com.anushka.tmdbclient.models.tvshow.TvShow

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}