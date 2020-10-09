package com.padcx.mmz.podcast

import android.app.Application
import com.padcx.mmz.podcast.data.models.PodCastModelImpls
import com.padcx.mmz.podcast.data.models.PodcastFirebaseDataModelImpl

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
class PodCastApp: Application(){
    override fun onCreate() {
        super.onCreate()
       /* PodCastModelImpls.initDatabase(applicationContext)*/

        PodcastFirebaseDataModelImpl.initDatabase(applicationContext)
    }
}