package com.padcx.mmz.podcast.delegate

import com.padcx.mmz.podcast.data.vos.EpisodeVO
import com.padcx.mmz.podcast.data.vos.PlaylistVO

/**
 * Created by Myint Myint Zaw on 8/29/2020.
 */
interface PodcastDelegate {
    fun onTapShowData()

    fun onTapPlayListItem(episodeVO: EpisodeVO)

    fun onTapDownloadItem(dataVO: EpisodeVO)

    /*fun onTapPlayListItem(playListVO: PlaylistVO)*/
}