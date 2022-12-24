package com.example.kotlin_coroutine_mvvm.data.datasource

import android.util.Log
import com.example.kotlin_coroutine_mvvm.data.model.Movie
import com.example.kotlin_coroutine_mvvm.service.RetrofitService

class MovieApi(private val retrofitService: RetrofitService) {
    suspend fun fetchMovieList(): List<Movie> {
        val response = retrofitService.fetchAllMovie()
        Log.e("Mothi","sfb")
        return response.body()!!
    }
}