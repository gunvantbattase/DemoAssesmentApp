package com.example.demo.network

import com.example.example.DataObjects
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    //@POST("login")
    //fun login(@Body user: User): Call<LoginResponse>

    @GET("objects")
    fun demoObjects(): Call<List<DataObjects>>
}