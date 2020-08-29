package com.example.aflamapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aflamapp.Data.Models.Movie
import com.example.aflamapp.Data.Utils
import com.example.aflamapp.R
import com.example.aflamapp.ui.main.OnMovieClickListener

class MovieAdapter(private val onMovieClickListener: OnMovieClickListener<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    lateinit var context: Context

    lateinit var movies: List<Movie>

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): MovieHolder {
        return MovieHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        Glide.with(context).load(Utils.posterImageUrl.plus(movies[position].poster)).into(holder.poster)
        holder.title.text = movies[position].title
    }

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        var poster: ImageView = itemView.findViewById(R.id.iv_poster)
        var title: TextView = itemView.findViewById(R.id.tv_title)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {

            onMovieClickListener.onItemClick(itemView,movies[adapterPosition])
        }
    }
}