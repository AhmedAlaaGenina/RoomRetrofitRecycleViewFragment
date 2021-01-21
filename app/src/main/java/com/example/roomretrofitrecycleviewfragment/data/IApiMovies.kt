package com.example.roomretrofitrecycleviewfragment.data

import com.example.roomretrofitrecycleviewfragment.model.MoviesPogoResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiMovies {
    @GET("upcoming")
    suspend fun getMovies(
        @Query("api_key") key: String
    ): Response<MoviesPogoResult>
}