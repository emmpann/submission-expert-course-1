package com.github.emmpann.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.emmpann.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}