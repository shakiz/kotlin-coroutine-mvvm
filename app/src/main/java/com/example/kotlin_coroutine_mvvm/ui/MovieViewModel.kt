package com.example.kotlin_coroutine_mvvm.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_coroutine_mvvm.data.model.Movie
import com.example.kotlin_coroutine_mvvm.data.repository.MovieRepository
import com.example.kotlin_coroutine_mvvm.network.NetworkState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val loading = MutableLiveData<Boolean>()

    private var exceptionHandler = CoroutineExceptionHandler{
        _, throwable -> onError(throwable.message)
    }

    fun fetchAllMovieList(){
        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            val response = movieRepository.fetchMovieList()
            loading.value = false
            movieList.postValue(response)
        }
    }

    private fun onError(message : String?){
        loading.value = false
    }

}