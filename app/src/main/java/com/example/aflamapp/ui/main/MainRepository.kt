package com.example.aflamapp.ui.main

import com.example.aflamapp.Data.Models.MovieResponse
import com.example.aflamapp.Data.Network.ClientApi
import com.example.aflamapp.Data.Utils
import io.reactivex.Single
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: ClientApi) {

    fun getListMovies(): Single<MovieResponse> {

        return api.getPopularMovies(Utils.key)
    }
}