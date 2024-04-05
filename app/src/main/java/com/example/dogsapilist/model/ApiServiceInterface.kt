package com.example.dogsapilist.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiServiceInterface {
    @Headers("X-Api-Key:yFW2n0hxh4nY1pvFOEKgOw==0JuYi25SkNyD3Cxo")
    @GET("dogs")
    fun getDogsByName(@Query("name") name: String): Call<List<Dog>>

}