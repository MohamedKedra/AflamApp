package com.example.aflamapp.ui.main

import com.example.aflamapp.Data.Models.MovieResponse
import com.example.aflamapp.Data.Network.ClientApi
import com.example.aflamapp.Data.Utils
import io.reactivex.Observable

class MainRepository {

    lateinit var api: ClientApi

    fun getListMovies(type: String): Observable<MovieResponse> {

        return if (type == Utils.Popular) {

            api.getPopularMovies(Utils.key)
        }else{

            api.getTopMovies(Utils.key)
        }
    }
}