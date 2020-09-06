package com.padcx.mmz.podcast.data

import android.content.Context
import com.padcx.mmz.podcast.network.PodCastApi
import com.padcx.mmz.podcast.persistance.db.PodCastDB
import com.padcx.mmz.podcast.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */

abstract class BaseModel {
    lateinit var mPodCastApi : PodCastApi
    lateinit var mTheDB: PodCastDB
    init {

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mPodCastApi = retrofit.create(PodCastApi::class.java)
    }
    fun initDatabase(context: Context){
        mTheDB = PodCastDB.getDBInstance(context)
    }
}