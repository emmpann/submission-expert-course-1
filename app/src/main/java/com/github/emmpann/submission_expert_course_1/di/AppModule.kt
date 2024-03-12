package com.github.emmpann.submission_expert_course_1.di

import com.github.emmpann.core.domain.usecase.MovieInteractor
import com.github.emmpann.core.domain.usecase.MovieUseCase
import com.github.emmpann.submission_expert_course_1.detail.DetailViewModel
import com.github.emmpann.submission_expert_course_1.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel {  HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}