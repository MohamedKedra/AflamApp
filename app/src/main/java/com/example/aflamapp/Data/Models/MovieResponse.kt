package com.example.aflamapp.Data.Models

import com.example.aflamapp.Data.Models.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>,
    val page: Int
)