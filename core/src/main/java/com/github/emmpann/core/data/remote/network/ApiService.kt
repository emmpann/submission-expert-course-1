package com.github.emmpann.core.data.remote.network

import com.github.emmpann.core.BuildConfig
import com.github.emmpann.core.data.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("3/discover/movie")
    @Headers("Authorization: Bearer ${BuildConfig.API_KEY}")
    suspend fun getList(
        @Query("include_adult") includeAdult: Boolean,
        @Query("include_video") includeVideo: Boolean,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String,
    ): ListMovieResponse
}