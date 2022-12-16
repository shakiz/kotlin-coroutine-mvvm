package com.example.kotlin_coroutine_mvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_coroutine_mvvm.data.model.Movie
import com.example.kotlin_coroutine_mvvm.data.repository.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()

    fun fetchAllMovieList(){
        movieRepository.fetchMovieList()
    }

}