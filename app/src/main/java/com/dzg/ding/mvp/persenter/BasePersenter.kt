package com.dzg.ding.mvp.persenter

open class BasePersenter<V> {
    private var mBaseView: V? = null;

    fun bindView(mBaseView: V) {
        this.mBaseView = mBaseView
    }

    fun unBindView() {
        this.mBaseView = null
    }

    fun getBaseView() = mBaseView

}