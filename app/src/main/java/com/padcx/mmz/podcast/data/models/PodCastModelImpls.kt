package com.padcx.mmz.podcast.data.models

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader
import com.padcx.mmz.podcast.BuildConfig
import com.padcx.mmz.podcast.data.BaseModel
import com.padcx.mmz.podcast.data.PodCastModel
import com.padcx.mmz.podcast.data.vos.*
import com.padcx.mmz.podcast.network.FirebaseApi
import com.padcx.mmz.podcast.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
object PodCastModelImpls : BaseModel(), PodCastModel {
    override lateinit var mFirebaseApi: FirebaseApi
    override fun getCategoryListFromFirebaseData(
        onSuccess: (categories: List<GenresVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

    override fun getAllEpisodesFromFirebase(
        onSuccess: (episodes: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }


    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenresVO>> {
        return mTheDB.podCastDao().getAllGenre()
    }

    override fun getAllDatasFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        mPodCastApi.getGenreList(BuildConfig.PODCAST_APIKEY, "0")
            .map { it.genres?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.podCastDao().insertAllGenre(it as List<GenresVO>)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllEpisodesFromDB(onError: (String) -> Unit): LiveData<List<EpisodeVO>> {
        TODO("Not yet implemented")
    }

    override fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>> {
        TODO("Not yet implemented")
    }

    override fun getDetailEpisodeDataByID(
        episodeId: String,
        onError: (String) -> Unit
    ): LiveData<EpisodeVO> {
        TODO("Not yet implemented")
    }

    override fun getPlayListFromDB(onError: (String) -> Unit): LiveData<List<PlaylistVO>> {
        TODO("Not yet implemented")
    }

    override fun getAllPlayListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        /* mPodCastApi.getPlayList(PODCAST_ID, VALUE_TYPE, VALUE_LAST_TIMESTAMP, VALUE_SORT,BuildConfig.PODCAST_APIKEY)
             .map {
                 it.items
             }
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe ({
                 mTheDB.podCastDao().insertPlayList(it)
             },{
                 onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
             })*/
    }


    @SuppressLint("CheckResult")
    override fun getRandomEpisodeFromDB(onError: (String) -> Unit): LiveData<RandomPodCastVO> {
        TODO("Not yet implemented")
        /*  return mTheDB.podCastDao().getRandomEpisode()*/
    }

    override fun getRandomPodCastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
        /*  mPodCastApi.getRandomEpisode(BuildConfig.PODCAST_APIKEY)
              .map { it }
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe ({
                  it?.let {
                      mTheDB.podCastDao().setRandomEpisode(it)
                  }
              },{
                  onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
              })*/
    }

    /* override fun startDownloadItem(context: Context, dataVO: DataVO) {
         startDownloading(context,dataVO)
     }*/

    override fun getDownloadPodcastList(onError: (String) -> Unit): LiveData<List<DownloadVO>> {
        return mTheDB.podCastDao().getAllDownloadedPodcastList()
    }

    override fun saveDownloadPodcastItem(
        donwloadVO: DownloadVO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mTheDB.podCastDao().insertDownloadPodcastData(donwloadVO)
    }

    override fun getDetailFromApiAndSaveToDatabase(
        episodeId: String,
        onSuccess: (detailVO: DetailPodCastVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mPodCastApi.getDetailEpisodeByID(BuildConfig.PODCAST_APIKEY, episodeId)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { data -> mTheDB.podCastDao().insertDetailPodCast(data) }
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getDetailEpisodeData(
        episodeId: String,
        onError: (String) -> Unit
    ): LiveData<DetailPodCastVO> {
        TODO("Not yet implemented")
    }

    override fun startDownloadItem(context: Context, dataVO: EpisodeVO) {
    }


    /*  override fun getDetailEpisodeData(
          episodeId: String,
          onError: (String) -> Unit
      ): LiveData<DetailPodCastVO> {
          return mTheDB.podCastDao().getAllDetailDataByEpisodeID(episodeId)
      }*/
}
