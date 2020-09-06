package com.padcx.mmz.podcast.delegate

import com.padcx.mmz.podcast.data.vos.DataVO
import com.padcx.mmz.podcast.data.vos.DownloadVO

/**
 * Created by Myint Myint Zaw on 9/6/2020.
 */
interface DownloadedItemDelegate {
    fun onTouchDownloadedItem(downloadVo: DownloadVO)
}