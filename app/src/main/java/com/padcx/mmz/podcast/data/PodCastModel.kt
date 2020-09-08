package com.padcx.mmz.podcast.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.padcx.mmz.podcast.data.vos.*

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
interface PodCastModel {
    fun getAllGenres(onError: (String) -> Unit) : LiveData<List<GenresVO>>
    fun getAllDatasFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    /*podcast list*/
    fun getPlayListFromDB(onError: (String) -> Unit): LiveData<List<PlaylistVO>>
    fun getAllPlayListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)


    /*random podcast*/
    fun getRandomEpisodeFromDB(onError: (String) -> Unit):LiveData<RandomPodCastVO>
    fun getRandomPodCastFromApiAndSaveToDatabase( onSuccess: () -> Unit, onError: (String) -> Unit)

    //Detail Episode Data
    fun getDetailFromApiAndSaveToDatabase(episodeId : String, onSuccess: (detailVO :DetailPodCastVO) -> Unit, onError: (String) -> Unit)
    fun getDetailEpisodeData(episodeId : String, onError: (String) -> Unit) : LiveData<DetailPodCastVO>

   // fun getDetailEpisodeByIdFromDB(episodeId : String,onError: (String) -> Unit):LiveData<DetailPodCastVO>

    fun startDownloadItem(context: Context, dataVO: DataVO)
    fun getDownloadPodcastList(onError: (String) -> Unit) : LiveData<List<DownloadVO>>
    fun saveDownloadPodcastItem(donwloadVO: DownloadVO, onSuccess: () -> Unit, onError: (String) -> Unit)
}