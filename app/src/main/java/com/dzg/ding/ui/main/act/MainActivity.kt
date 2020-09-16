package com.dzg.ding.ui.main.act

import android.util.Log
import androidx.fragment.app.Fragment
import com.dzg.ding.R
import com.dzg.ding.base.BaseActivity
import com.dzg.ding.ui.main.adpater.HomeAdapter
import com.dzg.ding.ui.main.frg.FindFragment
import com.dzg.ding.ui.main.frg.FriendFragment
import com.dzg.ding.ui.main.frg.HomeFragment
import com.dzg.ding.ui.main.frg.MeFragment
import com.dzg.ding.ui.main.model.TitleMode
import com.dzg.ding.ui.main.persenter.MainPersenter
import com.dzg.ding.ui.main.view.MainView
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPersenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()

    override fun getLayout(): Int = R.layout.activity_main

    override fun initView() {
        val titles = resources.getStringArray(R.array.title)
        val selectIds = resources.obtainTypedArray(R.array.select)
        val unSelectIds = resources.obtainTypedArray(R.array.unSelect)
        for (i: Int in titles.indices) {
            titleTabs.add(
                TitleMode(
                    titles[i],
                    selectIds.getResourceId(i, 0),
                    unSelectIds.getResourceId(i, 0)
                )
            )
        }
        fragments.add(HomeFragment())
        fragments.add(FriendFragment())
        fragments.add(FindFragment())
        fragments.add(MeFragment())
        vp_home.adapter = HomeAdapter(supportFragmentManager, fragments)
        //预加载长度
        vp_home.offscreenPageLimit = fragments.size
        footer_home.setTabData(titleTabs)
        footer_home.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //smoothScroll 去除点击动画
                vp_home.setCurrentItem(position,false)
            }
            override fun onTabReselect(position: Int) {

            }

        })
    }

    override fun initData() {
    }

    override fun createPersenter() = MainPersenter()

    override fun <T> setData(data: T) {
        Log.e("test", "========== $data")
    }

    override fun setError(err: String) {
    }
}