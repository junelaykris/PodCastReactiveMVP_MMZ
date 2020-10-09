package com.padcx.mmz.podcast.network

import com.padcx.mmz.podcast.data.vos.EpisodeVO
import com.padcx.mmz.podcast.data.vos.GenresVO

/**
 * Created by Myint Myint Zaw on 9/27/2020.
 */
interface FirebaseApi {

    fun getCategoryList(
        onSuccess: (podcast: List<GenresVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getAllEpisodes(
        onSuccess: (playlist: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    )

}