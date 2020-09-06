package com.padcx.mmz.podcast.network

import com.padcx.mmz.podcast.data.vos.DetailPodCastVO
import com.padcx.mmz.podcast.data.vos.RandomPodCastVO
import com.padcx.mmz.podcast.reponses.GenreResponse
import com.padcx.mmz.podcast.reponses.GetPlaylistResponses
import com.padcx.mmz.podcast.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
interface PodCastApi {

    @GET(GET_CATEGORIES)
    fun getGenreList(@Header("X-ListenAPI-Key") api_key: String,
                     @Query("top_level_only") value: String) : Observable<GenreResponse>

    @GET(GET_UPNEXT)
    fun getPlayList(@Path("PODCAST_ID") id: String,
                    @Query(PARAM_TYPE) type:String,
                    @Query(PARAM_LAST_TIMESTAMP) last:Int,
                    @Query(PARAM_SORT) sort:String,
                    @Header(PARAM_API_KEY) apiKey: String): Observable<GetPlaylistResponses>


    @GET(GET_RAMDOM)
    fun getRandomEpisode(@Header(PARAM_API_KEY) apiKey: String)
            : Observable<RandomPodCastVO>

    @GET(GET_DETAIL)
    fun getDetailEpisodeByID(
        @Header("X-ListenAPI-Key") api_key: String,
        @Path(ID_PARAM) id: String
    ): Observable<DetailPodCastVO>

}