package com.padcx.mmz.podcast.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
@IgnoreExtraProperties
@Entity(tableName = "download_entity")
data class DownloadVO(
    @PrimaryKey
    val download_id: String,
    val download_podcast_title: String? = "",
    val download_podcast_description: String? = "",
    val download_podcast_url: String? = "",
    val download_audio_path: String? = ""
) {

}