package com.padcx.mmz.shared.presenter

import com.padcx.mmz.shared.views.BaseView


interface BasePresenter<T: BaseView> {
    fun initPresenter(view:T)
}