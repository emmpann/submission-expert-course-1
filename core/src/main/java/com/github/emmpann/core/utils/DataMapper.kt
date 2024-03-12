package com.github.emmpann.core.utils

import com.github.emmpann.core.data.local.entity.MovieEntity
import com.github.emmpann.core.data.remote.response.MovieResponse
import com.github.emmpann.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val tourism = MovieEntity(
                movieId = it.id,
                overview = it.overview,
                title = it.title,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                voteAverage = it.voteAverage,
                releaseDate = it.releaseDate,
                isFavorite = false
            )
            movieList.add(tourism)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                overview = it.overview,
                title = it.title,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                voteAverage = it.voteAverage.toString(),
                releaseDate = it.releaseDate,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        overview = input.overview,
        title = input.title,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        voteAverage = input.voteAverage,
        releaseDate = input.releaseDate,
        isFavorite = input.isFavorite
    )
}