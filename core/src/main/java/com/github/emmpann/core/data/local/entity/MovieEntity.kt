package com.github.emmpann.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(

    @PrimaryKey
    @ColumnInfo(name = "movieId")
    var movieId: Int,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "posterPath")
    var posterPath: String,

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean
)