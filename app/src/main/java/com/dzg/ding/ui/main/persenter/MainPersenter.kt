package com.dzg.ding.ui.main.persenter

import com.dzg.ding.http.HttpUtils
import com.dzg.ding.http.ResponseListenter
import com.dzg.ding.http.UserApi
import com.dzg.ding.mvp.model.BaseModel
import com.dzg.ding.mvp.persenter.BasePersenter
import com.dzg.ding.ui.main.model.MainModel
import com.dzg.ding.ui.main.view.MainView

class MainPersenter : BasePersenter<MainView>() {
    fun getTest() {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(),
            object : ResponseListenter<BaseModel<MainModel>> {
                override fun onSuccess(data: BaseModel<MainModel>) {
                    if (data != null) {
                        getBaseView()!!.setData(data)
                    }
                }

                override fun onError(errorMessage: String) {
                    getBaseView()!!.setError(errorMessage)
                }

            })
    }
}