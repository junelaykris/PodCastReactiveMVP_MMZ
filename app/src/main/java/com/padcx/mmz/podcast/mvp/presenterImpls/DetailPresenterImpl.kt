package com.padcx.mmz.podcast.mvp.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.mmz.podcast.data.PodCastModel
import com.padcx.mmz.podcast.data.models.PodcastFirebaseDataModelImpl
import com.padcx.mmz.podcast.mvp.presenters.DetailPresenter
import com.padcx.mmz.podcast.mvp.view.DetailView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {
   /* var mPodCastModel: PodCastModel = PodCastModelImpls*/

    var mPodCastModel: PodcastFirebaseDataModelImpl = PodcastFirebaseDataModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, episodeID: String) {

        mPodCastModel.getDetailEpisodeDataByID(episodeID, onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayDetailData(it)
                }
            })

        /* mPodCastModel.getDetailFromApiAndSaveToDatabase(episodeID, onSuccess = {
         }, onError = {})


         mPodCastModel.getDetailEpisodeData(episodeID, onError = {})
             .observe(lifeCycleOwner, Observer {
                 it?.let {
                     mView?.displayDetailData(it) }
             })*/
    }

    override fun onTouchFifteenSec() {
        mView?.onTouchBackwardFifteenSecIcon()
    }

    override fun onTouchThirtySec() {
        mView?.onTouchForwardThirtySecIcon()
    }

    override fun onTouchPlayPause(audioUrl: String) {
        mView?.onTouchPlayPauseIcon(audioUrl)
    }

}