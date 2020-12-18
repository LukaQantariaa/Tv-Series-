package com.example.tvseries.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tvseries.MoviesM
import com.example.tvseries.MoviesModel
import com.example.tvseries.api.MoviesService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel: ViewModel() {


    private val _moviesLiveData = MutableLiveData<MoviesM>()
    val moviesLiveData: LiveData<MoviesM>
        get() = _moviesLiveData


//    https://my-json-server.typicode.com/

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/")
        .client(
            OkHttpClient.Builder()
                .build()
        )
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

    private val moviesService = retrofit.create(MoviesService::class.java)

    fun getMovies() {

        moviesService.getMovies().enqueue(object : Callback<MoviesM> {

            override fun onResponse(call: Call<MoviesM>, response: Response<MoviesM>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _moviesLiveData.postValue(it)
                    }
                } else {
//
                }
            }

            override fun onFailure(call: Call<MoviesM>, t: Throwable) {

            }

        })
    }

//    fun getMovie(index: Int) {
//        moviesService.getMovies().enqueue(object : Callback<MoviesM> {
//
//            override fun onResponse(call: Call<MoviesM>, response: Response<MoviesM>) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        for (i in it.movies.indices) {
//                            if(it.movies[i].id == index) {
//                                _movieDetailedLiveData.postValue(it.movies[i]);
//                                // for loop-ის გაჩერება ვერ ვნახე თუ როგორ არის. აქ უნდა ჩამესვა.
//                            }
//                        }
//                    }
//                } else {
////                    _errorLiveData.postValue("Error Occurred")
//                }
//            }
//
//            override fun onFailure(call: Call<MoviesM>, t: Throwable) {
//
//            }
//
//        })
//    }



}