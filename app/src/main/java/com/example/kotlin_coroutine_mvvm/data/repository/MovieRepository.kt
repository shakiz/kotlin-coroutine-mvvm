package com.example.kotlin_coroutine_mvvm.data.repository

import com.example.kotlin_coroutine_mvvm.data.model.Movie

interface MovieRepository {
    suspend fun fetchMovieList() : List<Movie>
}