package com.padcx.mmz.podcast.views.viewpods

import android.content.Context
import android.text.Html
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import com.padcx.mmz.podcast.utils.checkTime
import com.padcx.mmz.podcast.utils.load
import kotlinx.android.synthetic.main.media_playback_view.view.*

class MediaPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    private var mDelegate : Delegate? = null
    private var mAudioUrl : String ?=null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setData(
        title: String,
        desc: String,
        duration: Int,
        url: String,
        audio: String
    ){
        iv_show_title.text = title
        tv_playing.text=desc
        ivPodcast.load(url)
        tv_time.text = duration.checkTime()
        mAudioUrl=audio
    }

    fun getPlayPauseImage() : ImageView {
        return iv_play_pause
    }
    fun getSeekBar() : SeekBar
    {
        return progressBar
    }
    fun getRemainingTime() : TextView {
        return tv_time
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }



    private fun setUpListener() {
        tvBackward.setOnClickListener {
            mDelegate?.onTouchFifteenSec()
        }
        tvForward.setOnClickListener {
            mDelegate?.onTouchThirtySec()
        }

        iv_play_pause.setOnClickListener {
            mAudioUrl?.let { it1 -> mDelegate?.onTouchPlayPause(it1) }
        }
    }

    interface Delegate{
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
        fun onTouchPlayPause(audioUrl : String)
    }
}