package com.example.retrofit.data

import com.example.retrofit.data.model.RemoteResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {



    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMovies(
        @Query("api_key") apiKey:String,
        @Query("language") language: String
    ): RemoteResult

    object RetrofitServiceFactory {
        fun makeRetrofitService(): RetrofitService {
            return  Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitService::class.java)
        }
    }
}