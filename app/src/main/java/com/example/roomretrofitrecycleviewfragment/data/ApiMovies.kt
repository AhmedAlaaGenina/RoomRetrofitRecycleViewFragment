package com.example.roomretrofitrecycleviewfragment.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiMovies {

    private val BASE_URL: String = "https://api.themoviedb.org/3/movie/"
    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): IApiMovies {
        return getInstance().create(IApiMovies::class.java)
    }
}