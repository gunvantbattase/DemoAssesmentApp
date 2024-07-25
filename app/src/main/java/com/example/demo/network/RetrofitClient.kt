package com.example.demo.network

import com.example.demo.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitClient {


    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    //private val errorInterceptor = ErrorInterceptor()

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        //.addInterceptor(errorInterceptor)
        .build()


    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}