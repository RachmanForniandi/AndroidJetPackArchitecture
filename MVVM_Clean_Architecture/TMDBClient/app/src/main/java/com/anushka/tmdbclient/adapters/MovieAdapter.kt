package com.anushka.tmdbclient.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding: ListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item,parent,false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList[position])
    }

    class MovieHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movie:Movie){
            binding.titleTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview
            val imgUrl = "https://image.tmdb.org/t/p/w500"+movie.posterPath
            Glide.with(binding.imageView.context)
                .load(imgUrl)
                .into(binding.imageView)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}

