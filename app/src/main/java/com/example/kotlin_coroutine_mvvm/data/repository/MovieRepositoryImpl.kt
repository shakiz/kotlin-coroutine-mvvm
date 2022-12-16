package com.example.kotlin_coroutine_mvvm.data.repository

import com.example.kotlin_coroutine_mvvm.data.datasource.MovieApi
import com.example.kotlin_coroutine_mvvm.data.model.Movie

class MovieRepositoryImpl(private val movieApi: MovieApi) : MovieRepository {
    override suspend fun fetchMovieList(): List<Movie> {
        return movieApi.fetchMovieList()
    }
}