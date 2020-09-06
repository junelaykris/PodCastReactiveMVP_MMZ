package com.padcx.mmz.podcast.views.viewholders

import android.view.View
import com.padcx.mmz.podcast.data.ShowVO
import com.padcx.mmz.podcast.data.vos.DownloadVO
import com.padcx.mmz.podcast.delegate.DownloadedItemDelegate
import com.padcx.mmz.podcast.delegate.PodcastDelegate
import com.padcx.mmz.podcast.utils.load
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.activity_detail_show.*
import kotlinx.android.synthetic.main.show_item.view.*

/**
 * Created by Myint Myint Zaw on 8/23/2020.
 */
class ShowItemViewHolder(
    itemView: View,
    mDelegate: DownloadedItemDelegate
) : BaseViewHolder<DownloadVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTouchDownloadedItem(it)
            }
        }
    }

    override fun bindData(data: DownloadVO) {
        mData = data
        itemView.tv_category.text = data.donwload_podcast_title
        itemView.tv_detail.text = data.download_podcast_description
      /*  itemView.tv_hint.text = data.download_podcast_description*/

        itemView.iv_show_image.load(data.download_podcast_url)
    }
}