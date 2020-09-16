package com.dzg.ding.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dzg.ding.mvp.persenter.BasePersenter
import com.dzg.ding.mvp.view.BaseView

abstract class BaseActivity<V, P : BasePersenter<V>> : AppCompatActivity(), BaseView {
    private var mPersenter: P? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        if (mPersenter == null) {
            mPersenter = createPersenter() as P
        }
        mPersenter!!.bindView(this as V)
        initView()
        initData()
    }

    protected abstract fun getLayout(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun createPersenter(): P
    fun getPersenter() = mPersenter

    override fun onDestroy() {
        super.onDestroy()
        mPersenter!!.unBindView()
    }
}