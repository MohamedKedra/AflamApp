package com.example.aflamapp.Data

class Utils {

    companion object {

        val navKey = "movie"


        const val base = "https://api.themoviedb.org/3/movie/"
        const val key = "d45f4694bfc80e05d2e035bedf5764c9"
        private const val ImageBase = "http://image.tmdb.org/t/p/"
        private const val posterSize = "w342"
        private val backDropSize = "w300"
        val posterImageUrl = ImageBase.plus(posterSize)
        val bgImageUrl = ImageBase.plus(backDropSize)
        val Popular = "popular"
        val Rated = "rated"
        val Movie = "movie"
        val Youtube = "http://www.youtube.com/watch?v="
    }
}