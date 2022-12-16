package com.example.kotlin_coroutine_mvvm.data.repository

import com.example.kotlin_coroutine_mvvm.data.model.Movie

interface MovieRepository {
    fun fetchMovieList() : List<Movie>
}