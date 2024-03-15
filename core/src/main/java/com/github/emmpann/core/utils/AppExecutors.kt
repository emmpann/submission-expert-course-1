package com.github.emmpann.core.utils

import androidx.annotation.VisibleForTesting

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors @VisibleForTesting constructor(
    private val diskIO: Executor = Executors.newSingleThreadExecutor(),
) {
    fun diskIO(): Executor = diskIO
}