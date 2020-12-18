package com.example.tvseries.api

import com.example.tvseries.MoviesM
import retrofit2.Call
import retrofit2.http.GET

interface MoviesService {
    @GET("nikoloz14/movies-db/db")
    fun getMovies(): Call<MoviesM>
}