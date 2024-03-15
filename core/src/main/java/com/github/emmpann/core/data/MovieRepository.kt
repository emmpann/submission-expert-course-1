package com.github.emmpann.core.data

import com.github.emmpann.core.data.local.LocalDataSource
import com.github.emmpann.core.data.remote.RemoteDataSource
import com.github.emmpann.core.data.remote.network.ApiResponse
import com.github.emmpann.core.data.remote.response.MovieResponse
import com.github.emmpann.core.domain.model.Movie
import com.github.emmpann.core.domain.repository.IMovieRepository
import com.github.emmpann.core.utils.AppExecutors
import com.github.emmpann.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : IMovieRepository {
    override fun getAllMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = data.isNullOrEmpty()
        }.asFlow()


    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state) }
    }

}