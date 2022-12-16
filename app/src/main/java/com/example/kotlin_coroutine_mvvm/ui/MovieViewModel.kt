package com.example.kotlin_coroutine_mvvm.ui

import androidx.lifecycle.ViewModel
import com.example.kotlin_coroutine_mvvm.data.repository.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun fetchAllMovieList(){
        movieRepository.fetchMovieList()
    }

}