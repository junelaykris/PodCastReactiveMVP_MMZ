package com.padcx.mmz.podcast.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcx.mmz.podcast.persistance.typeconverters.PodCastVOConverter

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
@Entity(tableName = "detail_entity")
@TypeConverters(PodCastVOConverter::class)
data class DetailPodCastVO(
    @SerializedName("audio")var audio: String="",
    @SerializedName("audio_length_sec")var audio_length_sec: Int=0,
    @SerializedName("description")var description: String="",
    @SerializedName("explicit_content")var explicit_content: Boolean=false,
    @PrimaryKey
    @SerializedName("id")var id: String="",
    @SerializedName("image")var image: String="",
    @SerializedName("link")var link: String="",
    @SerializedName("listennotes_edit_url")var listennotes_edit_url: String="",
    @SerializedName("listennotes_url")var listennotes_url: String="",
    @SerializedName("maybe_audio_invalid")var maybe_audio_invalid: Boolean=false,

    @SerializedName("podcast")var podcast: PodcastVO,
    @SerializedName("pub_date_ms")var pub_date_ms: Long = 0L,
    @SerializedName("thumbnail")var thumbnail: String="",
    @SerializedName("title")var title: String=""
)
