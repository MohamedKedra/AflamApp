package com.example.aflamapp.Data.Network

import com.example.aflamapp.Data.Models.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientApi {

    @GET("popular")
    fun getPopularMovies(@Query("api_key") key: String) : Single<MovieResponse>
}