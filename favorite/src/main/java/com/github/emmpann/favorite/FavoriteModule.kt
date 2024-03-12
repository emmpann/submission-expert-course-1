package com.github.emmpann.favorite

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieFavoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}