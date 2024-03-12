package com.github.emmpann.submission_expert_course_1.detail

import androidx.lifecycle.ViewModel
import com.github.emmpann.core.domain.model.Movie
import com.github.emmpann.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavorite(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}