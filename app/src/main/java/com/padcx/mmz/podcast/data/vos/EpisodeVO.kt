package com.padcx.mmz.podcast.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import com.padcx.mmz.podcast.persistance.typeconverters.PodCastVOConverter

/**
 * Created by Myint Myint Zaw on 10/9/2020.
 */
@IgnoreExtraProperties
@Entity(tableName = "episodes")
@TypeConverters(PodCastVOConverter::class)
data class EpisodeVO(
    @PrimaryKey
    var id: String = "",
    var audio: String? = "",
    var audio_length_sec: Int? = 0,
    var description: String? = "",
    var explicit_content: Boolean? = false,
    var image: String? = "",
    var link: String? = "",
    var listennotes_edit_url: String? = "",
    var listennotes_url: String? = "",
    var maybe_audio_invalid: Boolean? = false,
    var podcast: PodcastVO? = null,
    var pub_date_ms: Long? = 0,
    var thumbnail: String? = "",
    var title: String? = ""
)