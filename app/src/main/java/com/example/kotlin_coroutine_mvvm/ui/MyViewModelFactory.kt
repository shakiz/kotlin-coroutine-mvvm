package com.example.kotlin_coroutine_mvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_coroutine_mvvm.data.repository.MovieRepository

class MyViewModelFactory constructor(private val movieRepository: MovieRepository):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            MovieViewModel(this.movieRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}