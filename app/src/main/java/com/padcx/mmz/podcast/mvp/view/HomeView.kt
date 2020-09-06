package com.padcx.mmz.podcast.mvp.view

import com.padcx.mmz.podcast.data.vos.DataVO
import com.padcx.mmz.podcast.data.vos.GenresVO
import com.padcx.mmz.podcast.data.vos.PlaylistVO
import com.padcx.mmz.podcast.data.vos.RandomPodCastVO
import com.padcx.mmz.shared.views.BaseView

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
interface HomeView  : BaseView {
    fun displayPlayList(playList:List<PlaylistVO>)
    fun showRandomEpisode(randomEp : RandomPodCastVO)

    fun onTouchPlayPause(audioUrl : String)
    fun onTouchForwardThirtySec()
    fun onTouchBackwardFifteenSec()

    fun selectedDownloadItem(data: DataVO)

    fun navigateToDetailScreen(episodeID : String)
}