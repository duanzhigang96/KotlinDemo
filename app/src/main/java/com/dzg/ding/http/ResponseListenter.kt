package com.dzg.ding.http

interface ResponseListenter<T> {
    fun onSuccess(data:T)
    fun onError(errorMessage:String)
}
