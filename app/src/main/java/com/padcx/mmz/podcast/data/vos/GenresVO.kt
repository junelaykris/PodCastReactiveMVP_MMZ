package com.padcx.mmz.podcast.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
@Entity(tableName = "genres")
data class GenresVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("parent_id") val parent_id: String,
    @SerializedName("name") val name: String
) {
}