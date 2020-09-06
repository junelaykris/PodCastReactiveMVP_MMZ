package com.padcx.mmz.podcast.reponses

import com.google.gson.annotations.SerializedName
import com.padcx.mmz.podcast.data.vos.GenresVO

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
data class GenreResponse(
    @SerializedName("genres")
    val genres: ArrayList<GenresVO?>? = ArrayList()
) {

}