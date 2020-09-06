package com.padcx.mmz.podcast.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.mmz.podcast.data.vos.DataVO

class DataConverter {
    @TypeConverter
    fun toString(dataList: DataVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): DataVO {
        val dataListType = object : TypeToken<DataVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}