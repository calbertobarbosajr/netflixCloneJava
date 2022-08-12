package com.example.netflixclone.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.databinding.ListedMoviesBinding
import com.example.netflixclone.list.Movies

class MoviesAdapter (val movies: MutableList<Movies>): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    inner class MoviesViewHolder(val binding: ListedMoviesBinding): RecyclerView.ViewHolder(binding.root){  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ListedMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        with(holder){
            with(movies[position]){
                binding.movieCover.setImageResource(movieCover)
            }
        }
    }

    override fun getItemCount() = movies.size


}