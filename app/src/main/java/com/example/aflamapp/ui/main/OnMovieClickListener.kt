package com.example.aflamapp.ui.main

import android.view.View

interface OnMovieClickListener<T> {

    fun onItemClick(view: View, model: T)
}