package com.padcx.mmz.podcast.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.podcast.delegate.DownloadedItemDelegate
import com.padcx.mmz.podcast.mvp.view.DownloadedView
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
interface DownloadedPresenter: BasePresenter<DownloadedView>, DownloadedItemDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}