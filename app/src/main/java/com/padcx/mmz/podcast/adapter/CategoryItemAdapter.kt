package com.padcx.mmz.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.podcast.R
import com.padcx.mmz.podcast.data.ShowVO
import com.padcx.mmz.podcast.data.vos.GenresVO
import com.padcx.mmz.podcast.views.viewholders.CategoryViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 8/29/2020.
 */
class CategoryItemAdapter:
    BaseRecyclerAdapter<CategoryViewHolder, GenresVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_item_view,parent,false)
        return CategoryViewHolder(view)
    }
}