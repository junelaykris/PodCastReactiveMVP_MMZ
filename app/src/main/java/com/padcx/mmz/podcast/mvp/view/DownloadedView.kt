package com.padcx.mmz.podcast.mvp.view

import com.padcx.mmz.podcast.data.vos.DownloadVO
import com.padcx.mmz.shared.views.BaseView

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
interface DownloadedView : BaseView {
    fun displayDownloadPodcastList(list: List<DownloadVO>)
    fun navigateToDetail(downloadVO: DownloadVO)
}