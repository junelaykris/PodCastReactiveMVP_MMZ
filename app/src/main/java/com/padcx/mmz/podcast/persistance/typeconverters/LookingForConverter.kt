package com.padcx.mmz.podcast.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LookingForConverter {
   /* @TypeConverter
    fun toString(dataList: LookingFor):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): LookingFor {
        val dataListType = object : TypeToken<LookingFor>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }*/
}