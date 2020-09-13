package com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl

import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowLocalDataSource
import com.anushka.tmdbclient.local.TvShowDao
import com.anushka.tmdbclient.models.tvshow.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDb(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDb(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch{
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}