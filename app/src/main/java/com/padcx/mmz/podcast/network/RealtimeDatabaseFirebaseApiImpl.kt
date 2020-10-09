package com.padcx.mmz.podcast.network

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.padcx.mmz.podcast.data.vos.*

/**
 * Created by Myint Myint Zaw on 9/27/2020.
 */
object RealtimeDatabaseFirebaseApiImpl : FirebaseApi {

    private val database: DatabaseReference = Firebase.database.reference

    override fun getCategoryList(
        onSuccess: (podcast: List<GenresVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("genres").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val categoryList = arrayListOf<GenresVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(GenresVO::class.java)?.let {
                        categoryList.add(it)
                    }
                }
                onSuccess(categoryList)
            }
        })
    }

    override fun getAllEpisodes(
        onSuccess: (playlist: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("latest_episodes").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val playlists = arrayListOf<EpisodeVO>()

                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(EpisodeVO::class.java)?.let {
                        playlists.add(it)
                    }
                }
                onSuccess(playlists)
            }
        })
    }

}