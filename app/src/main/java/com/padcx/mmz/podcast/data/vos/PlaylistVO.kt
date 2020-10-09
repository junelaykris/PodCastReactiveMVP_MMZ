package com.padcx.mmz.podcast.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import com.padcx.mmz.podcast.persistance.typeconverters.DataConverter
import com.padcx.mmz.podcast.persistance.typeconverters.GenreIdListConverter
import com.padcx.mmz.podcast.persistance.typeconverters.PodCastVOConverter

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */

@IgnoreExtraProperties
@Entity(tableName = "playlist_entity")
@TypeConverters(GenreIdListConverter::class)
data class PlaylistVO(
    @PrimaryKey
    var id: String = "",
    var image: String? = "",
    var listennotes_url: String? = "",
    var publisher: String? = "",
    var thumbnail: String? = "",
    var title: String? = ""
)

/*
@Entity(tableName = "playlist_entity")
@TypeConverters(DataConverter::class, PodCastVOConverter::class)
data class PlaylistVO(

    @SerializedName("added_at_ms") var added_at_ms: Long = 0L,
    @SerializedName("data") var data: DataVO? = null,

    @PrimaryKey
    @SerializedName("id") var id: Int = 0,
    @SerializedName("notes") var notes: String = "",
    @SerializedName("type") var type: String = ""
)

data class DataVO(
    @SerializedName("audio")var audio: String,
    @SerializedName("audio_length_sec")var audio_length_sec: Int,
    @SerializedName("description")var description: String,
    @SerializedName("explicit_content")var explicit_content: Boolean,

    @PrimaryKey
    @SerializedName("id")var dataId: String,
    @SerializedName("image")var image: String,
    @SerializedName("link")var link: String,
    @SerializedName("listennotes_edit_url")var listennotes_edit_url: String,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("maybe_audio_invalid")var maybe_audio_invalid: Boolean,

    @SerializedName("podcast")var podcast: PodcastVO,
    @SerializedName("pub_date_ms")var pub_date_ms: Long,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("title")var title: String
)*/
