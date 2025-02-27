package com.android.roomtest.data

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("success") var success: Boolean,
    @SerializedName("message") var message: String?,
    @SerializedName("data") val data: T?
){
    fun serilize(): String{
        return  Gson().toJson(this)
    }
}
