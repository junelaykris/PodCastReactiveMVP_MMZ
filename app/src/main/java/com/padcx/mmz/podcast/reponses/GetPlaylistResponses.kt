package com.padcx.mmz.podcast.reponses

import com.google.gson.annotations.SerializedName
import com.padcx.mmz.podcast.data.vos.PlaylistVO

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
data class GetPlaylistResponses(
    @SerializedName("description")var description: String,
    @SerializedName("id")var id: String,
    @SerializedName("image")var image: String,
    @SerializedName("items")var items: List<PlaylistVO>,
    @SerializedName("last_timestamp_ms")var last_timestamp_ms: Long,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("name")var name: String,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("total")var total: Int,
    @SerializedName("type")var type: String,
    @SerializedName("visibility")var visibility: String
) {

}