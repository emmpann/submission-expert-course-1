package com.github.emmpann.submission_expert_course_1.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.emmpann.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovie().asLiveData()
}