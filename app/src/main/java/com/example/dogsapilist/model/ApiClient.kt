package com.example.dogsapilist.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiServiceInterface by lazy {
        retrofit.create(ApiServiceInterface::class.java)
    }
}