package com.padcx.mmz.podcast.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Layout
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.padcx.mmz.podcast.R
import com.padcx.mmz.podcast.data.vos.DetailPodCastVO
import com.padcx.mmz.podcast.data.vos.PodcastVO
import com.padcx.mmz.podcast.mvp.presenterImpls.DetailPresenterImpl
import com.padcx.mmz.podcast.mvp.presenters.DetailPresenter
import com.padcx.mmz.podcast.mvp.view.DetailView
import com.padcx.mmz.podcast.utils.*
import com.padcx.mmz.podcast.views.viewpods.MediaPlayerSmallViewPod
import kotlinx.android.synthetic.main.activity_detail_content.*
import kotlinx.android.synthetic.main.activity_detail_show.*

/**
 * Created by Myint Myint Zaw on 8/29/2020.
 */
@Suppress("DEPRECATION")
class PodCastDetailActivity : AppCompatActivity(), DetailView {

    private lateinit var mPresenter: DetailPresenter
    private var initPlayer = false
    private lateinit var miniPlayerViewPod: MediaPlayerSmallViewPod

    companion object {
        const val EPISODE_ID = "dataId"
        const val FROMPAGE = "fromPage"
        const val DOWNLOAD_AUDI_FILE_PATH = "audio_file_path"
        fun newIntent(
            context: Context,
            episodeID: String,
            page: String,
            filepath: String
        ): Intent {
            val intent = Intent(context, PodCastDetailActivity::class.java)
            intent.putExtra(EPISODE_ID, episodeID)
            intent.putExtra(FROMPAGE, page)
            intent.putExtra(DOWNLOAD_AUDI_FILE_PATH, filepath)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_show)
        setUpPresenter()
        setUpViewPod()
        setUpListener()
        mPresenter.onUiReady(this, intent.getStringExtra(EPISODE_ID).toString())
    }

    private fun setUpListener() {
        toolbar.setNavigationOnClickListener {
            onBackPressed()
            if (initPlayer) MyMediaPlayerHelper.mediaPlayerStopPlayBack(this)
        }
    }

    private fun setUpViewPod() {
        miniPlayerViewPod = media_playsmall as MediaPlayerSmallViewPod
        miniPlayerViewPod.setDelegate(mPresenter)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayDetailData(data: DetailPodCastVO) {
        tvCategoriesType.text = data.podcast.type
        podCastTitle.text = data.title
        ivDetail.load(data.thumbnail)
        miniPlayerViewPod.setUpData(data.audio)
        tv_description.text = Html.fromHtml(data.description)
    }

    override fun onTouchPlayPauseIcon(audioUri: String) {
        if (intent.getStringExtra(FROMPAGE).equals(DOWNLOADPAGE)) {
            tryToStepUpMediaPlayer(audioUri)
        } else {
            if (!verifyAvailableNetwork()) {
                Toast.makeText(
                    this,
                    "Please Check Internet Connection!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                tryToStepUpMediaPlayer(audioUri)
            }
        }

    }

    private fun verifyAvailableNetwork(): Boolean {
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun tryToStepUpMediaPlayer(audioUri: String) {

        if (!initPlayer) {

            var type = PLAYER_TYPE_STREAMING
            var mAudioUrl = audioUri

            if (intent.getStringExtra(FROMPAGE).toString().equals(DOWNLOADPAGE)) {
                type = FILE_TYPE
                mAudioUrl = intent.getStringExtra(DOWNLOAD_AUDI_FILE_PATH).toString()
            }

            MyMediaPlayerHelper.initMediaPlayer(
                this, mAudioUrl,
                miniPlayerViewPod.getSeekBar(),
                miniPlayerViewPod.getPlayPauseImage(),
                miniPlayerViewPod.getCurrentTimeLabel(),
                miniPlayerViewPod.getTotalTimeLabel(), type
            )
            initPlayer = true
        } else {
            MyMediaPlayerHelper.playPauseMediaPlayBack(this)
        }

    }

    override fun onTouchForwardThirtySecIcon() {
        MyMediaPlayerHelper.forwardMediaPlayBack(this)
    }

    override fun onTouchBackwardFifteenSecIcon() {
        MyMediaPlayerHelper.backwardMediaPlayBack(this)
    }

}