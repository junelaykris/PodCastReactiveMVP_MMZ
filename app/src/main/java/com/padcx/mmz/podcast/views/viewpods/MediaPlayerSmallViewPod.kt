package com.padcx.mmz.podcast.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.media_playback_small.view.*

class MediaPlayerSmallViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    private var mDelegate : Delegate? = null
    private var mAudioUrl : String ?=null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setUpData(audioUrl: String) {
        mAudioUrl=audioUrl
    }

    fun getPlayPauseImage() : ImageView {
        return play_view
    }
    fun getSeekBar() : SeekBar
    {
        return progressBar
    }

    fun getTotalTimeLabel() : TextView {
        return tvEndTime
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun getCurrentTimeLabel() : TextView {
        return tvStartTime
    }

    private fun setUpListener() {
        tvBackward.setOnClickListener {
            mDelegate?.onTouchFifteenSec()
        }
        tvForward.setOnClickListener {
            mDelegate?.onTouchThirtySec()
        }

        play_view.setOnClickListener {
            mAudioUrl?.let { it1 -> mDelegate?.onTouchPlayPause(it1) }
        }
    }

    interface Delegate{
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
        fun onTouchPlayPause(audioUrl : String)
    }
}