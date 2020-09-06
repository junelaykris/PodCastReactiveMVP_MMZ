package com.padcx.mmz.podcast.mvp.presenterImpls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.podcast.data.PodCastModel
import com.padcx.mmz.podcast.data.models.PodCastModelImpls
import androidx.lifecycle.Observer
import com.padcx.mmz.podcast.data.vos.DownloadVO
import com.padcx.mmz.podcast.mvp.presenters.DownloadedPresenter
import com.padcx.mmz.podcast.mvp.view.DownloadedView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
class DownloadedPresenterImpl: DownloadedPresenter, AbstractBasePresenter<DownloadedView>() {

    var mPodCastModel: PodCastModel = PodCastModelImpls
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        mPodCastModel.getDownloadPodcastList( onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let { mView?.displayDownloadPodcastList(it) }
            })
    }


    override fun onTouchDownloadedItem(downloadVo: DownloadVO) {
        mView?.navigateToDetail(downloadVo)
    }
}