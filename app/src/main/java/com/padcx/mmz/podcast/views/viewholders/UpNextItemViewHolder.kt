package com.padcx.mmz.podcast.views.viewholders

import android.text.Html
import android.view.View
import com.bumptech.glide.Glide
import com.padcx.mmz.podcast.data.vos.PlaylistVO
import com.padcx.mmz.podcast.delegate.PodcastDelegate
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.show_item.view.*
import kotlinx.android.synthetic.main.show_item.view.iv_show_image
import kotlinx.android.synthetic.main.show_item.view.tv_category
import kotlinx.android.synthetic.main.show_item.view.tv_detail
import kotlinx.android.synthetic.main.upnextitemview.view.*

/**
 * Created by Myint Myint Zaw on 8/29/2020.
 */
class UpNextItemViewHolder(
    itemView: View,
    mDelegate: PodcastDelegate
) :
    BaseViewHolder<PlaylistVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapPlayListItem(it)
            }
        }
        itemView.ivDownload.setOnClickListener {
            mData?.let {
                it?.let {
                 mdata->   mDelegate.onTapDownloadItem(mdata.data!!) }
            }
        }
    }

    override fun bindData(data: PlaylistVO) {
        mData = data
        itemView.tv_category.text = data.type
        val htmlTextStr: String = Html.fromHtml(data.data!!.description).toString()
        itemView.tv_detail.text = htmlTextStr

        Glide.with(itemView)
            .load(mData!!.data?.image)
            .into(itemView.iv_show_image)
    }
}