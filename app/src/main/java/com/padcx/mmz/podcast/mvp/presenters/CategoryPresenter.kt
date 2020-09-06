package com.padcx.mmz.podcast.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.podcast.mvp.view.CategoryView
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
interface GenresPresenter  : BasePresenter<CategoryView>{
    fun onUiReady(lifecycleOwner: LifecycleOwner)

}