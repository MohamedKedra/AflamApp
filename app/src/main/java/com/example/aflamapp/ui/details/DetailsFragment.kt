package com.example.aflamapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.aflamapp.DI.Injectable
import com.example.aflamapp.Data.Models.Movie
import com.example.aflamapp.Data.Utils
import com.example.aflamapp.R
import kotlinx.android.synthetic.main.details_fragment.*
import javax.inject.Inject

class DetailsFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: DetailsViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews(){

        arguments?.getParcelable<Movie>(Utils.navKey)?.let {movie ->
            tv_title.text = movie.title
            tv_overview.text = movie.overview
            tv_date.text = movie.date
            tv_rate.text = movie.rate
            tv_lang.text = movie.language
            tv_popularity.text = movie.popularity.toInt().toString()

            Glide.with(this).load(Utils.posterImageUrl.plus(movie.poster)).into(iv_poster)
            Glide.with(this).load(Utils.bgImageUrl.plus(movie.backdrop)).into(iv_bg)
        }
    }
}