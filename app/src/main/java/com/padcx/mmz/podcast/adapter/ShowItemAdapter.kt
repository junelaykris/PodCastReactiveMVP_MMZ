package com.padcx.mmz.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.podcast.R
import com.padcx.mmz.podcast.data.ShowVO
import com.padcx.mmz.podcast.data.vos.DownloadVO
import com.padcx.mmz.podcast.delegate.DownloadedItemDelegate
import com.padcx.mmz.podcast.delegate.PodcastDelegate
import com.padcx.mmz.podcast.views.viewholders.ShowItemViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 8/23/2020.
 */
class ShowItemAdapter(private val delegate:DownloadedItemDelegate) :
    BaseRecyclerAdapter<ShowItemViewHolder, DownloadVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.show_item,parent,false)
        return ShowItemViewHolder(view,delegate)
    }
}