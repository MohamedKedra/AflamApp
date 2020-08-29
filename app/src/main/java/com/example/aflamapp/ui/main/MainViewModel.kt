package com.example.aflamapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aflamapp.Data.Models.Movie
import com.example.aflamapp.Data.Models.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val disposable = CompositeDisposable()
    private val moviesResult = MutableLiveData<List<Movie>>()
    private val isLoading = MutableLiveData<Boolean>()
    private val messageError = MutableLiveData<String>()

    fun getMoviesResult() : MutableLiveData<List<Movie>>
    {
        observeData()
        return moviesResult
    }

    private fun observeData() {
        isLoading.value = true
        disposable.add(
            repository.getListMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MovieResponse>() {
                    override fun onSuccess(response: MovieResponse) {
                        moviesResult.value = response.movies
                        isLoading.value = false
                    }

                    override fun onError(error: Throwable) {
                        messageError.value = error.message
                        isLoading.value = false
                    }
                })
        )
    }

    fun getIsLoading() : MutableLiveData<Boolean> = isLoading
    fun getMessageError() : MutableLiveData<String> = messageError
}