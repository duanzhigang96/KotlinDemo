package com.dzg.ding.http

import com.dzg.ding.mvp.model.BaseModel
import com.dzg.ding.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {
    @GET("recommendPoetry")
    fun getTest():Observable<BaseModel<MainModel>>
}