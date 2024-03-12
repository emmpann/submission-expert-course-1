package com.github.emmpann.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("vote_average")
    val voteAverage: String,

    @field:SerializedName("id")
    val id: Int,
)