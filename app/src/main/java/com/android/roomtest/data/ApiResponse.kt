package com.android.roomtest.data


sealed class ApiResponse<out T> {
    data class Progress<T>(var loading: Boolean) : ApiResponse<T>()
    data class Success<T>(var data: T) : ApiResponse<T>()
    data class Failure<T>(val e: Throwable, val body: BaseResponse<String>?=null, val errorCode:Int) : ApiResponse<T>()


    companion object {
        fun <T> loading(isLoading: Boolean): ApiResponse<T> = Progress(isLoading)
        fun <T> success(data: T): ApiResponse<T> = Success(data)
        fun <T> failure(e: Throwable, body: BaseResponse<String>?=null, errorCode:Int): ApiResponse<T> = Failure(e,body,errorCode)
    }
}