package com.example.aflamapp.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun getListMovies(type: String) = MainRepository().getListMovies(type)
}