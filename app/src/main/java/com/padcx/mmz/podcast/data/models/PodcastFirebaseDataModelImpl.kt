package com.padcx.mmz.podcast.data.models

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.padcx.mmz.podcast.data.BaseModel
import com.padcx.mmz.podcast.data.PodCastModel
import com.padcx.mmz.podcast.data.vos.*
import com.padcx.mmz.podcast.network.FirebaseApi
import com.padcx.mmz.podcast.network.RealtimeDatabaseFirebaseApiImpl
import com.padcx.mmz.podcast.utils.startDownloading

/**
 * Created by Myint Myint Zaw on 9/27/2020.
 */
object PodcastFirebaseDataModelImpl : PodCastModel, BaseModel() {
    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl

    override fun getCategoryListFromFirebaseData(
        onSuccess: (categories: List<GenresVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getCategoryList(onSuccess = {
            mTheDB.podCastDao().insertAllGenre(it)
        }, onFailure = { onFailure(it) })
    }

    override fun getAllEpisodesFromFirebase(
        onSuccess: (episodes: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getAllEpisodes(onSuccess = {
            mTheDB.podCastDao().insertAllEpisodes(it)
        }, onFailure =
        { onFailure(it) })
    }


    override fun getAllEpisodesFromDB(onError: (String) -> Unit): LiveData<List<EpisodeVO>> {
        return mTheDB.podCastDao().getAllEpisodes()
    }

    override fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>> {
        return mTheDB.podCastDao().getAllPodcastData()
    }

    override fun getDetailEpisodeDataByID(
        episodeId: String,
        onError: (String) -> Unit
    ): LiveData<EpisodeVO> {
        return mTheDB.podCastDao().getAllDetailDataByEpisodeID(episodeId)
    }

    override fun getPlayListFromDB(onError: (String) -> Unit): LiveData<List<PlaylistVO>> {
        TODO("Not yet implemented")
    }


    override fun getAllDatasFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }


    override fun getAllPlayListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getRandomEpisodeFromDB(onError: (String) -> Unit): LiveData<RandomPodCastVO> {
        TODO("Not yet implemented")
    }

    override fun getRandomPodCastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getDetailFromApiAndSaveToDatabase(
        episodeId: String,
        onSuccess: (detailVO: DetailPodCastVO) -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getDetailEpisodeData(
        episodeId: String,
        onError: (String) -> Unit
    ): LiveData<DetailPodCastVO> {
        TODO("Not yet implemented")
    }

     override fun startDownloadItem(context: Context, dataVO: EpisodeVO) {
         Toast.makeText(context, "Start Downloading", Toast.LENGTH_LONG).show()
         startDownloading(context, dataVO)
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

    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenresVO>> {
        return mTheDB.podCastDao().getAllGenre()
    }

}