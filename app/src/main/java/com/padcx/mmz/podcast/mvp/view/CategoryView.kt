package com.padcx.mmz.podcast.mvp.view

import com.padcx.mmz.podcast.data.vos.GenresVO
import com.padcx.mmz.podcast.data.vos.PlaylistVO
import com.padcx.mmz.shared.views.BaseView

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
interface CategoryView : BaseView {
    fun displayGenre(genreList:List<GenresVO>)
}