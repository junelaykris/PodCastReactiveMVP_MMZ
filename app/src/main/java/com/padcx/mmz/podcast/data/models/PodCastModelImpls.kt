package com.padcx.mmz.podcast.data.models

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader
import com.padcx.mmz.podcast.data.BaseModel
import com.padcx.mmz.podcast.data.PodCastModel
import com.padcx.mmz.podcast.data.vos.*
import com.padcx.mmz.podcast.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
object PodCastModelImpls : BaseModel(), PodCastModel  {
    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenresVO>> {
        return mTheDB.podCastDao().getAllGenre()
    }

    override fun getAllDatasFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        mPodCastApi.getGenreList(PARAM_API_KEY,"0")
            .map { it.genres?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.podCastDao().insertAllGenre(it as List<GenresVO>)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getPlayListFromDB(onError: (String) -> Unit): LiveData<List<PlaylistVO>> {
        mPodCastApi.getPlayList(PODCAST_ID, VALUE_TYPE, VALUE_LAST_TIMESTAMP, VALUE_SORT,PARAM_API_KEY)
            .map {
                it.items
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mTheDB.podCastDao().insertPlayList(it)
            }
        return mTheDB.podCastDao().getPlayList()
    }

    @SuppressLint("CheckResult")
    override fun getRandomEpisodeFromDB(onError: (String) -> Unit): LiveData<RandomPodCastVO> {
        mPodCastApi.getRandomEpisode(PARAM_API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let {
                    mTheDB.podCastDao().setRandomEpisode(it)
                }
            }
        return mTheDB.podCastDao().getRandomEpisode()
    }

    override fun getDetailEpisodeData(
        episodeId: String,
        onError: (String) -> Unit
    ): LiveData<DetailPodCastVO> {
          return mTheDB.podCastDao().getAllDetailDataByEpisodeID()
      /*  return mTheDB.podCastDao().getAllDetailDataByEpisodeID(episodeId)*/
    }

    override fun startDownloadItem(context: Context, dataVO: DataVO) {
        startDownloading(context,dataVO)
    }

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
        mPodCastApi.getDetailEpisodeByID(PARAM_API_KEY,episodeId)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it?.let{data-> mTheDB.podCastDao().insertDetailPodCast(data) }
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    /* override fun getDetailEpisodeByIdFromDB(
         episodeId: String,
         onError: (String) -> Unit): LiveData<DetailPodCastVO> {
         mPodCastApi.getDetailEpisodeByID(PARAM_API_KEY,episodeId)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe {
                 it?.let {
                     mTheDB.podCastDao().insertDetailPodCast(it)
                 }
             }
         //return mTheDB.podCastDao().getDetail()
         return mTheDB.podCastDao().getAllDetailDataByEpisodeID(episodeId)
     }
 */

}