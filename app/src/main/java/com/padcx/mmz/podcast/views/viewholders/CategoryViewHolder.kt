package com.padcx.mmz.podcast.views.viewholders

import android.view.View
import com.padcx.mmz.podcast.data.ShowVO
import com.padcx.mmz.podcast.data.vos.GenresVO
import com.padcx.mmz.podcast.utils.load
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.activity_detail_show.*

import kotlinx.android.synthetic.main.categories_item_view.view.*

/**
 * Created by Myint Myint Zaw on 8/29/2020.
 */
class CategoryViewHolder(itemView: View) :
    BaseViewHolder<GenresVO>(itemView) {

    override fun bindData(data: GenresVO) {
        mData = data
       /* data.image_url?.let { itemView.iv_podcast.load(it) }*/
        itemView.cateogry_title.text=data.name
    }
}