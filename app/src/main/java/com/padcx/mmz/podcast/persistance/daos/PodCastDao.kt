package com.padcx.mmz.podcast.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.mmz.podcast.data.vos.*

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
@Dao
interface PodCastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGenre(genres: List<GenresVO>)

    @Query("SELECT * FROM genres")
    fun getAllGenre(): LiveData<List<GenresVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayList(list: List<PlaylistVO>)

    @Query("SELECT * FROM playlist_entity")
    fun getPlayList(): LiveData<List<PlaylistVO>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setRandomEpisode(randomEpisode: RandomPodCastVO)

    @Query("SELECT * FROM random_entity")
    fun getRandomEpisode(): LiveData<RandomPodCastVO>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailPodCast(detail: DetailPodCastVO)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailData(data: DetailPodCastVO)

    @Query("select * from detail_entity")
    fun getAllDetailDataByEpisodeID(): LiveData<DetailPodCastVO>

    /*   @Query("select * from detail_entity WHERE id = :detail_id")
       fun getAllDetailDataByEpisodeID(detail_id : String): LiveData<DetailPodCastVO>*/


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDownloadPodcastData(podcasts: DownloadVO)

  /*  @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDownloadPodCastList(podCast: List<DownloadVO>)*/

    @Query("select * from download_entity")
    fun getAllDownloadedPodcastList(): LiveData<List<DownloadVO>>


}