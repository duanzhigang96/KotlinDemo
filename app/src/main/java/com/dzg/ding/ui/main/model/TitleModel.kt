package com.dzg.ding.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

data class TitleMode(val title: String, val select: Int, val unSelect: Int) : CustomTabEntity {

    override fun getTabUnselectedIcon(): Int = unSelect

    override fun getTabSelectedIcon(): Int = select

    override fun getTabTitle(): String = title
}

