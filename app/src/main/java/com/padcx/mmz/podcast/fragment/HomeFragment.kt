package com.padcx.mmz.podcast.fragment

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.mmz.podcast.R
import com.padcx.mmz.podcast.activities.PodCastDetailActivity
import com.padcx.mmz.podcast.adapter.UpNextShowItemAdapter
import com.padcx.mmz.podcast.data.ShowVO
import com.padcx.mmz.podcast.data.vos.DataVO
import com.padcx.mmz.podcast.data.vos.PlaylistVO
import com.padcx.mmz.podcast.data.vos.RandomPodCastVO
import com.padcx.mmz.podcast.mvp.presenterImpls.HomePresenterImpl
import com.padcx.mmz.podcast.mvp.presenters.HomePresenter
import com.padcx.mmz.podcast.mvp.view.HomeView
import com.padcx.mmz.podcast.utils.HOMEPAGE
import com.padcx.mmz.podcast.utils.MyMediaPlayerHelper
import com.padcx.mmz.podcast.utils.PLAYER_TYPE_STREAMING
import com.padcx.mmz.podcast.views.viewpods.MediaPlayerViewPod
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * Created by Myint Myint Zaw on 8/23/2020.
 */
@Suppress("DEPRECATION")
class HomeFragment : Fragment(), HomeView {
    private lateinit var upnextShowAdapter: UpNextShowItemAdapter
    val upcominglist: ArrayList<ShowVO> = arrayListOf()
    private var initPlayer = false

    private lateinit var homePresenter: HomePresenter
    private lateinit var mPlayerViewPod: MediaPlayerViewPod

    private val PERMISSION_REQUEST_CODE = 1005

    companion object {
        lateinit var mContext: Context
        fun newInstance(context: Context): HomeFragment {
            mContext = context
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setUpPresenter()
        setUpViewPod(view)
        //  mPlayerViewPod = media_playback as ExoPlayerViewPodPOd
        homePresenter.onUiReady(this)

        upnextShowAdapter = UpNextShowItemAdapter(homePresenter)

        val linearLayoutManager =
            LinearLayoutManager(DownloadFragment.mContext, LinearLayoutManager.VERTICAL, false)
        view.rv_upcomingshow.layoutManager = linearLayoutManager
        view.rv_upcomingshow.adapter = upnextShowAdapter
        return view

    }

    private fun setUpViewPod(view: View) {
        mPlayerViewPod = view.mediaPlayBack_view as MediaPlayerViewPod
        mPlayerViewPod.setDelegate(homePresenter)
    }

    private fun setUpPresenter() {
        homePresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        homePresenter.initPresenter(this)
    }

    override fun displayPlayList(playList: List<PlaylistVO>) {
        upnextShowAdapter.setNewData(playList.toMutableList())
    }

    override fun showRandomEpisode(randomdata: RandomPodCastVO) {

        val htmlTextStr: String = Html.fromHtml(randomdata.description).toString()
        tvdescription.text = htmlTextStr
        mPlayerViewPod.setData(
            randomdata.podcast!!.title,
            randomdata.podcast!!.publisher,
            randomdata.audio_length_sec,
            randomdata.image,
            randomdata.audio
        )
    }

    override fun onTouchPlayPause(audioUrl: String) {
        if (!initPlayer) {
            MyMediaPlayerHelper.initMediaPlayer(
                activity as Activity, audioUrl,
                mPlayerViewPod.getSeekBar(),
                mPlayerViewPod.getPlayPauseImage(),
                mPlayerViewPod.getRemainingTime(),
                mPlayerViewPod.getRemainingTime(),
                PLAYER_TYPE_STREAMING
            )
            initPlayer = true
        } else {
            MyMediaPlayerHelper.playPauseMediaPlayBack(activity as Activity)
        }
    }

    override fun onTouchForwardThirtySec() {
        MyMediaPlayerHelper.backwardMediaPlayBack(activity as Activity)
    }

    override fun onTouchBackwardFifteenSec() {
        MyMediaPlayerHelper.forwardMediaPlayBack(activity as Activity)
    }

    override fun selectedDownloadItem(data: DataVO) {
        requestToDownloadPermissions(data)
    }

    private fun requestToDownloadPermissions(data: DataVO) {
        val permission = ContextCompat.checkSelfPermission(
            activity as Activity,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        } else {
            data?.let {  homePresenter?.onDownloadPodcastItem(activity as Context,it) }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            activity as Activity,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSION_REQUEST_CODE
        )
    }

    override fun navigateToDetailScreen(episodeID: String) {
        startActivity(PodCastDetailActivity.newIntent(activity as Context, episodeID, HOMEPAGE, ""))
    }

    override fun onDestroy() {
        super.onDestroy()
        if(initPlayer)  MyMediaPlayerHelper.mediaPlayerStopPlayBack(activity as Activity)
    }


}