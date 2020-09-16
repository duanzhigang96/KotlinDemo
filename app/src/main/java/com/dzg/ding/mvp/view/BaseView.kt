package com.dzg.ding.mvp.view

interface BaseView {
    fun <T> setData(data: T)
    fun setError(err: String)
}