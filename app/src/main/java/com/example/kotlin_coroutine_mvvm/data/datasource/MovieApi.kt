package com.example.kotlin_coroutine_mvvm.data.datasource

import com.example.kotlin_coroutine_mvvm.data.model.Movie
import com.example.kotlin_coroutine_mvvm.service.RetrofitService

class MovieApi(private val retrofitService: RetrofitService) {
    fun fetchMovieList(): List<Movie> {
        return retrofitService.fetchAllMovie()
    }
}