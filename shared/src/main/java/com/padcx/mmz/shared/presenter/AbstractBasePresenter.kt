package com.padcx.mmz.shared.presenter

import androidx.lifecycle.ViewModel
import com.padcx.mmz.shared.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>:BasePresenter<T>,ViewModel() {
    var mView : T? = null
    override fun initPresenter(view: T) {
        mView = view
    }
}