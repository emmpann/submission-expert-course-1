package com.github.emmpann.core.data.remote.network

import com.github.emmpann.core.data.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("3/discover/movie")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1ZjQwOGI0NWY4MWU5MmZmOTUyMTM3NDliYjE1OGY5NiIsInN1YiI6IjY1NzFiYmYyYjA0NjA1MDEwMDFiMGZhOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.UFPG90htB5yzR1LVucl78tuSVEHDcPCX-efotQwHErw")
    suspend fun getList(
        @Query("include_adult") includeAdult: Boolean,
        @Query("include_video") includeVideo: Boolean,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String,
    ): ListMovieResponse
}