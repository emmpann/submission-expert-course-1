package com.github.emmpann.core.data.remote

import android.util.Log
import com.github.emmpann.core.data.remote.network.ApiResponse
import com.github.emmpann.core.data.remote.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAllMovie() = flow {
        try {
            val response = apiService.getList(false, false, "en-US", 1, "popularity.desc")
            val dataArray = response.results
            if (dataArray.isNotEmpty()) {
                emit(ApiResponse.Success(response.results))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.toString()))
            Log.e("RemoteDataSource", e.toString())
        }
    }.flowOn(Dispatchers.IO)
}