package com.padcx.mmz.podcast.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.padcx.mmz.podcast.data.vos.*
import com.padcx.mmz.podcast.network.FirebaseApi

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
interface PodCastModel {

    var mFirebaseApi: FirebaseApi

    fun getCategoryListFromFirebaseData(
        onSuccess: (categories: List<GenresVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getAllEpisodesFromFirebase(
        onSuccess: (episodes: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    )


    /*podcastapi*/

    fun getAllGenres(onError: (String) -> Unit) : LiveData<List<GenresVO>>
    fun getAllDatasFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    /*episodes list*/
    fun getAllEpisodesFromDB(onError: (String) -> Unit): LiveData<List<EpisodeVO>>

    //Podcast Data
    fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>>

    //Detail Episode Data
    fun getDetailEpisodeDataByID(episodeId: String, onError: (String) -> Unit): LiveData<EpisodeVO>


    /*podcasts list*/
    fun getPlayListFromDB(onError: (String) -> Unit): LiveData<List<PlaylistVO>>
    fun getAllPlayListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)


    /*random podcast*/
    fun getRandomEpisodeFromDB(onError: (String) -> Unit):LiveData<RandomPodCastVO>
    fun getRandomPodCastFromApiAndSaveToDatabase( onSuccess: () -> Unit, onError: (String) -> Unit)

    //Detail Episode Data
    fun getDetailFromApiAndSaveToDatabase(episodeId : String, onSuccess: (detailVO :DetailPodCastVO) -> Unit, onError: (String) -> Unit)
    fun getDetailEpisodeData(episodeId : String, onError: (String) -> Unit) : LiveData<DetailPodCastVO>

   // fun getDetailEpisodeByIdFromDB(episodeId : String,onError: (String) -> Unit):LiveData<DetailPodCastVO>

    fun startDownloadItem(context: Context, dataVO: EpisodeVO)
    fun getDownloadPodcastList(onError: (String) -> Unit) : LiveData<List<DownloadVO>>
    fun saveDownloadPodcastItem(donwloadVO: DownloadVO, onSuccess: () -> Unit, onError: (String) -> Unit)
}