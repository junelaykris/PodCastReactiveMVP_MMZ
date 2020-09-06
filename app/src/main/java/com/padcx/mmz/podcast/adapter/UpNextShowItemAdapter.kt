package com.padcx.mmz.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.podcast.R
import com.padcx.mmz.podcast.data.vos.PlaylistVO
import com.padcx.mmz.podcast.delegate.PodcastDelegate
import com.padcx.mmz.podcast.views.viewholders.UpNextItemViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 8/29/2020.
 */
class UpNextShowItemAdapter(private val mDelegate : PodcastDelegate):
    BaseRecyclerAdapter<UpNextItemViewHolder, PlaylistVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpNextItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upnextitemview,parent,false)
        return UpNextItemViewHolder(view,mDelegate)
    }
}