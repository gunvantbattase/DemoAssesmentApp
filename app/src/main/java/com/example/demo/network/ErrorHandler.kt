package com.example.demo.network

// ErrorHandler.kt
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

object ErrorHandler {

    fun handleError(t: Throwable): String {
        return when (t) {
            is IOException -> "Network error"
            is SocketTimeoutException -> "Request timed out"
            is HttpException -> handleHttpException(t)
            else -> "Unknown error"
        }
    }

    private fun handleHttpException(exception: HttpException): String {
        return when (exception.code()) {
            400 -> "Bad request"
            401 -> "Unauthorized"
            403 -> "Forbidden"
            404 -> "Not found"
            500 -> "Internal server error"
            else -> "HTTP error: ${exception.code()}"
        }
    }
}
