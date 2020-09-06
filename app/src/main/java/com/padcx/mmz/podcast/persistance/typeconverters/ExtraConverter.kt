package com.padcx.mmz.podcast.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.mmz.podcast.data.vos.Extra

class ExtraConverter {
    @TypeConverter
    fun toString(dataList: Extra):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): Extra{
        val dataListType = object : TypeToken<Extra>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}