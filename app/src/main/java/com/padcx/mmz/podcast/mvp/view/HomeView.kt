package com.padcx.mmz.podcast.mvp.view

import com.padcx.mmz.podcast.data.vos.*
import com.padcx.mmz.shared.views.BaseView

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
interface HomeView  : BaseView {
    fun displayPlayList(playList:List<EpisodeVO>)
    fun showRandomEpisode(randomEp : EpisodeVO)

    fun onTouchPlayPause(audioUrl : String)
    fun onTouchForwardThirtySec()
    fun onTouchBackwardFifteenSec()

    fun selectedDownloadItem(data: EpisodeVO)

    fun navigateToDetailScreen(episodeID : String?)
}