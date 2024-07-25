package com.example.demo.network

// ErrorInterceptor.kt
import okhttp3.Interceptor
import okhttp3.Response

class ErrorInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        /*if (!response.isSuccessful) {
            val responseBody = response.body
            val responseString = responseBody?.string()
            val errorResponse = responseString?.let {
                Gson().fromJson<ErrorResponse>(it, object : TypeToken<ErrorResponse>() {}.type)
            }
            throw HttpException(
                //None of the following functions can be called with the arguments supplied.
                retrofit2.Response.error(errorResponse,response)
            )
        }*/

        return response
    }
}
