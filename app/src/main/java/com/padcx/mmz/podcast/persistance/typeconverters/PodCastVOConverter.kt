package com.padcx.mmz.podcast.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.mmz.podcast.data.vos.PodcastVO

class PodCastVOConverter {
    @TypeConverter
    fun toString(dataList: PodcastVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): PodcastVO {
        val dataListType = object : TypeToken<PodcastVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}