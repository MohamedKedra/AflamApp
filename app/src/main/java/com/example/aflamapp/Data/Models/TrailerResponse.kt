package com.example.aflamapp.Data.Models

import com.example.aflamapp.Data.Models.Trailer
import com.google.gson.annotations.SerializedName

class TrailerResponse(
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("results")
    val trailers: List<Trailer>)