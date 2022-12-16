package com.example.kotlin_coroutine_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_coroutine_mvvm.R
import com.example.kotlin_coroutine_mvvm.databinding.ActivityMovieListBinding

class MovieListActivity : AppCompatActivity() {

    lateinit var viewModel: MovieViewModel
    lateinit var binding : ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)

        initObjects()
        initObserver()

        viewModel.fetchAllMovieList()
    }

    private fun initObjects() {
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
    }

    private fun initObserver() {
        viewModel.movieList.observe(this){

        }
    }
}
