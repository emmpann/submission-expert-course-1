package com.github.emmpann.submission_expert_course_1

import android.app.Application
import com.github.emmpann.core.di.databaseModule
import com.github.emmpann.core.di.networkModule
import com.github.emmpann.core.di.repositoryModule
import com.github.emmpann.submission_expert_course_1.di.useCaseModule
import com.github.emmpann.submission_expert_course_1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Application)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}