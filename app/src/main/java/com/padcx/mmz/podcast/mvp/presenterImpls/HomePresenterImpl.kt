package com.padcx.mmz.podcast.mvp.presenterImpls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.podcast.mvp.presenters.HomePresenter
import com.padcx.mmz.podcast.mvp.view.HomeView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter
import androidx.lifecycle.Observer
import com.padcx.mmz.podcast.data.models.PodcastFirebaseDataModelImpl
import com.padcx.mmz.podcast.data.vos.DownloadVO
import com.padcx.mmz.podcast.data.vos.EpisodeVO
import com.padcx.mmz.podcast.utils.randomNumber

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    /*  var mPodCastModel: PodCastModel = PodCastModelImpls*/
    var mPodCastModel: PodcastFirebaseDataModelImpl = PodcastFirebaseDataModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mPodCastModel.getAllEpisodesFromFirebase(onSuccess = {
        }, onFailure = {})

        mPodCastModel.getAllEpisodesFromDB(onError = {})
            .observe(lifecycleOwner, Observer {
                mView?.displayPlayList(it)
                it?.let {
                    val result = randomNumber(it.size)
                    showrandomPodCast(lifecycleOwner, it.get(result).id)
                }
            })

    }

    private fun showrandomPodCast(lifecycleOwner: LifecycleOwner, epId: String) {
        mPodCastModel.getDetailEpisodeDataByID(epId, onError = {})
            .observe(lifecycleOwner, Observer {
                mView?.showRandomEpisode(it)
            })
    }


    /* mPodCastModel.getRandomPodcast(onSuccess = {
         mView?.showRandomEpisode(it)
     }, onFialure = {})
*/
    /* mPodCastModel.getAllPlayListFromApiAndSaveToDatabase(onSuccess = {}, onError = {})
     mPodCastModel.getRandomPodCastFromApiAndSaveToDatabase(onSuccess = {}, onError = {})
     loadPlayList(lifecycleOwner)
     loadRandomPodcast(lifecycleOwner)*/


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

      override fun onTapPlayListItem(episode: EpisodeVO) {
          mView?.navigateToDetailScreen(episode.id)
      }

     override fun onTapDownloadItem(dataVO: EpisodeVO) {
         val downloadVO = DownloadVO(
             dataVO.id, dataVO.title, dataVO.description,
             dataVO.thumbnail, dataVO.title?.trim()?.substring(0, 8)
         )

         mPodCastModel?.saveDownloadPodcastItem(downloadVO, onSuccess = {}, onError = {})
         mView?.selectedDownloadItem(dataVO)
     }

    override fun onDownloadPodcastItem(context: Context, dataVO: EpisodeVO) {
        mPodCastModel.startDownloadItem(context, dataVO)
    }


    /* private fun loadPlayList(lifecycleOwner: LifecycleOwner) {
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
     }*/
}