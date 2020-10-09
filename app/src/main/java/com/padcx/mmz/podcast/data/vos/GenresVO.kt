package com.padcx.mmz.podcast.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
@IgnoreExtraProperties
@Entity(tableName = "genres")
data class GenresVO(
    @PrimaryKey
    val id: Int? = 0,
    var name: String? = "",
    var parent_id: Int? = 0
)
/*
@IgnoreExtraProperties
@Entity(tableName = "genres")
data class GenresVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("parent_id") val parent_id: String,
    @SerializedName("image_url")   val image_url: String,
    @SerializedName("name") val name: String
) {
}*/
