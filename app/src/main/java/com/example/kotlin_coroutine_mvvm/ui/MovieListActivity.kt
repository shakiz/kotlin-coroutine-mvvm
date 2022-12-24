package com.example.kotlin_coroutine_mvvm.ui

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_coroutine_mvvm.adapter.MovieAdapter
import com.example.kotlin_coroutine_mvvm.data.datasource.MovieApi
import com.example.kotlin_coroutine_mvvm.data.repository.MovieRepositoryImpl
import com.example.kotlin_coroutine_mvvm.databinding.ActivityMovieListBinding
import com.example.kotlin_coroutine_mvvm.service.RetrofitService

class MovieListActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel
    lateinit var binding : ActivityMovieListBinding
    private val movieAdapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObjects()
        setAdapter()
        initObserver()

        viewModel.fetchAllMovieList()
    }

    private fun initObjects() {
        val retrofitService = RetrofitService.getInstance()
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(MovieRepositoryImpl(MovieApi(retrofitService)))
        )[MovieViewModel::class.java]
    }

    private fun setAdapter(){
        binding.rvMovie.adapter = movieAdapter
    }

    private fun initObserver() {
        viewModel.movieList.observe(this){
            movieAdapter.setMovies(it)
        }

        viewModel.loading.observe(this){
            isLoading ->
            if(isLoading) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        }
    }
}
