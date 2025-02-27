package com.android.roomtest.data.room

import com.android.roomtest.data.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun<T> roomResult(call: suspend() -> T) : Flow<ApiResponse<T?>> = flow {
    emit(ApiResponse.loading(true))

    try {
        val c = call()
        emit(ApiResponse.success(c))
    }catch(t:Throwable){
        t.printStackTrace()
        emit(ApiResponse.failure(t,null,0))
    }
}