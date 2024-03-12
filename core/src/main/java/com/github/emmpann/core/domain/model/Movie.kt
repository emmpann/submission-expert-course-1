package com.github.emmpann.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var movieId: Int,
    var overview: String,
    var title: String,
    var posterPath: String,
    var backdropPath: String,
    var releaseDate: String,
    var voteAverage: String,
    var isFavorite: Boolean
) : Parcelable
