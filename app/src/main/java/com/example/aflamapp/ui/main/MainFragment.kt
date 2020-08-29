package com.example.aflamapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aflamapp.DI.Injectable
import com.example.aflamapp.Data.Models.Movie
import com.example.aflamapp.Data.Utils
import com.example.aflamapp.R
import com.example.aflamapp.ui.MovieAdapter
import kotlinx.android.synthetic.main.loading_message_layout.*
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : Fragment() ,Injectable,OnMovieClickListener<Movie>{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var navigationController: NavController

    private val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }

    lateinit var adapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        adapter = MovieAdapter(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationController = view.findNavController()
        adapter.context = activity?.applicationContext!!
        viewModel.getMoviesResult().observe(viewLifecycleOwner,
            { movies ->
                adapter.movies = movies
                rv_movies.layoutManager = GridLayoutManager(activity,2)
                rv_movies.adapter = adapter
            })

        viewModel.getIsLoading().observe(viewLifecycleOwner,
            { isLoading ->

                if(isLoading){
                    pb_progressbar.visibility = View.VISIBLE
                    tv_error.visibility = View.GONE
                }else{
                    pb_progressbar.visibility = View.GONE
                }

            })

        viewModel.getMessageError().observe(viewLifecycleOwner,
            { error ->
                tv_error.text = error
                tv_error.visibility = View.GONE
            })
    }

    override fun onItemClick(view: View, model: Movie) {
        val bundle = Bundle()
        bundle.putParcelable(Utils.navKey,model)
        navigationController.navigate(R.id.action_homeFragment_to_DetailsFragment,bundle)
    }
}