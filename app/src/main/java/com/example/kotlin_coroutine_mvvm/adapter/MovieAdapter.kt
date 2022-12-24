package com.example.kotlin_coroutine_mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_coroutine_mvvm.R
import com.example.kotlin_coroutine_mvvm.data.model.Movie
import com.example.kotlin_coroutine_mvvm.databinding.AdapterRecyclerItemMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRecyclerItemMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.movieName.text = movie.name.trim()
        Glide.with(holder.itemView.context).load(movie.imageUrl)
            .placeholder(R.drawable.placeholder)
            .into(holder.binding.ivImageCategory)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setMovies(movieList: List<Movie>){
        this.movieList = movieList.toMutableList()
        notifyDataSetChanged()
    }
}

class MovieViewHolder(val binding : AdapterRecyclerItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {}