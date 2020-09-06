package com.padcx.mmz.podcast.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.podcast.mvp.view.DetailView
import com.padcx.mmz.podcast.views.viewpods.MediaPlayerSmallViewPod
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
interface DetailPresenter : BasePresenter<DetailView>,MediaPlayerSmallViewPod.Delegate{
    fun onUiReady(lifeCycleOwner: LifecycleOwner, episodeID: String)
}
