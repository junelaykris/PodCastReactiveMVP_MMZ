package com.padcx.mmz.podcast.mvp.view

import com.padcx.mmz.podcast.data.vos.DetailPodCastVO
import com.padcx.mmz.shared.views.BaseView

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
interface DetailView: BaseView {
    fun displayDetailData(data: DetailPodCastVO)
    fun onTouchPlayPauseIcon(audioUri : String)
    fun onTouchForwardThirtySecIcon()
    fun onTouchBackwardFifteenSecIcon()
}