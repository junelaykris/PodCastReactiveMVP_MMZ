package com.padcx.mmz.podcast.mvp.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.mmz.podcast.data.PodCastModel
import com.padcx.mmz.podcast.data.models.PodCastModelImpls
import com.padcx.mmz.podcast.mvp.presenters.GenresPresenter
import com.padcx.mmz.podcast.mvp.view.CategoryView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
class GenresPresenterImpl : GenresPresenter, AbstractBasePresenter<CategoryView>() {
    var mPodCastModel: PodCastModel = PodCastModelImpls

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

        loadAllGenreFromAPI()

        mPodCastModel.getAllGenres(onError = {
        }).observe(lifecycleOwner, Observer {
            mView?.displayGenre(it)
        })
    }


    private fun loadAllGenreFromAPI() {
        mPodCastModel.getAllDatasFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )

    }

}
