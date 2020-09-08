package com.padcx.mmz.podcast.mvp.presenterImpls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.podcast.data.PodCastModel
import com.padcx.mmz.podcast.data.models.PodCastModelImpls
import com.padcx.mmz.podcast.mvp.presenters.HomePresenter
import com.padcx.mmz.podcast.mvp.view.HomeView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter
import androidx.lifecycle.Observer
import com.padcx.mmz.podcast.data.vos.DataVO
import com.padcx.mmz.podcast.data.vos.DownloadVO
import com.padcx.mmz.podcast.data.vos.PlaylistVO

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    var mPodCastModel: PodCastModel = PodCastModelImpls

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mPodCastModel.getAllPlayListFromApiAndSaveToDatabase(onSuccess = {}, onError = {})
        mPodCastModel.getRandomPodCastFromApiAndSaveToDatabase(onSuccess = {}, onError = {})
        loadPlayList(lifecycleOwner)
        loadRandomPodcast(lifecycleOwner)
    }

    override fun onDownloadPodcastItem(context: Context, dataVO: DataVO) {
        mPodCastModel.startDownloadItem(context, dataVO)
    }

    override fun onTouchFifteenSec() {
        mView?.onTouchForwardThirtySec()
    }

    override fun onTouchThirtySec() {
        mView?.onTouchBackwardFifteenSec()
    }

    override fun onTouchPlayPause(audioUrl: String) {
        mView?.onTouchPlayPause(audioUrl)
    }

    override fun onTapShowData() {

    }

    override fun onTapPlayListItem(playListVO: PlaylistVO) {
        mView?.navigateToDetailScreen(playListVO.data!!.dataId)
    }

    override fun onTapDownloadItem(dataVO: DataVO) {
        val downloadVO = DownloadVO(
            dataVO.dataId, dataVO.title, dataVO.description,
            dataVO.thumbnail, dataVO.title.trim().substring(0, 8)
        )

        mPodCastModel?.saveDownloadPodcastItem(downloadVO, onSuccess = {}, onError = {})
        mView?.selectedDownloadItem(dataVO)
    }

    private fun loadPlayList(lifecycleOwner: LifecycleOwner) {
        mPodCastModel.getPlayListFromDB(onError = {
        }).observe(lifecycleOwner, Observer {
            mView?.displayPlayList(it)
        })
    }


    private fun loadRandomPodcast(lifecycleOwner: LifecycleOwner) {
        mPodCastModel.getRandomEpisodeFromDB(onError = {
        }).observe(lifecycleOwner, Observer {
            if (it != null) {
                mView?.showRandomEpisode(it)
            }
        })
    }
}