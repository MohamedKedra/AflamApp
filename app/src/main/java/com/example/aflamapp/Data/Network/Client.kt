package com.example.aflamapp.Data.Network

import com.example.aflamapp.Data.Utils
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Client {

    companion object {

        fun getInstance() : ClientApi {

            return Retrofit.Builder()
                .baseUrl(Utils.base)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ClientApi::class.java)
        }
    }
}