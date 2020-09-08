package com.padcx.mmz.podcast.persistance.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcx.mmz.podcast.data.vos.*
import com.padcx.mmz.podcast.persistance.daos.PodCastDao

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */
@Database(
    entities = [GenresVO::class, PlaylistVO::class, RandomPodCastVO::class, DetailPodCastVO::class,PodcastVO::class, DownloadVO::class],
    version = 17,
    exportSchema = false
)
abstract class PodCastDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADC_X_PodCast.DB"
        var dbInstance: PodCastDB? = null

        fun getDBInstance(context: Context): PodCastDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, PodCastDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun podCastDao(): PodCastDao
}