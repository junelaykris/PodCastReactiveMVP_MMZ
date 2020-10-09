package com.padcx.mmz.podcast.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.podcast.data.vos.EpisodeVO
import com.padcx.mmz.podcast.delegate.PodcastDelegate
import com.padcx.mmz.podcast.mvp.view.CategoryView
import com.padcx.mmz.podcast.mvp.view.HomeView
import com.padcx.mmz.podcast.views.viewpods.MediaPlayerViewPod
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
interface HomePresenter: BasePresenter<HomeView>,MediaPlayerViewPod.Delegate,PodcastDelegate  {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onDownloadPodcastItem(context: Context, dataVO: EpisodeVO)
}