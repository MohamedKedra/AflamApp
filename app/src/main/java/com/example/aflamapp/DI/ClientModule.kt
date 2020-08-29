package com.example.aflamapp.DI

import com.example.aflamapp.Data.Network.ClientApi
import com.example.aflamapp.Data.Utils
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ClientModule {

    @Singleton
    @Provides
    fun getInstance() : ClientApi {

        return Retrofit.Builder()
            .baseUrl(Utils.base)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ClientApi::class.java)
    }
}