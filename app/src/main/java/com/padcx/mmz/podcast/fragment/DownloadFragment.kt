package com.padcx.mmz.podcast.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.mmz.podcast.R
import com.padcx.mmz.podcast.activities.PodCastDetailActivity
import com.padcx.mmz.podcast.adapter.ShowItemAdapter
import com.padcx.mmz.podcast.data.ShowVO
import com.padcx.mmz.podcast.data.vos.DownloadVO
import com.padcx.mmz.podcast.mvp.presenterImpls.DownloadedPresenterImpl
import com.padcx.mmz.podcast.mvp.presenters.DownloadedPresenter
import com.padcx.mmz.podcast.mvp.view.DownloadedView
import com.padcx.mmz.podcast.utils.DOWNLOADPAGE
import kotlinx.android.synthetic.main.fragment_download.view.*

/**
 * Created by Myint Myint Zaw on 8/23/2020.
 */
class DownloadFragment: Fragment(),DownloadedView{

    private lateinit var showsAdapter: ShowItemAdapter
    val showslist: ArrayList<ShowVO> = arrayListOf()
    private lateinit var mPresenter: DownloadedPresenter

    companion object {
        var mContext: Context?=null
        fun newInstance(context: Context): DownloadFragment {
            mContext = context
            return DownloadFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_download, container, false)
        setUpPresenter()
        mPresenter.onUiReady(this)
        showsAdapter = ShowItemAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        view.rv_show_items.layoutManager = linearLayoutManager
        view.rv_show_items.adapter = showsAdapter
        return view

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DownloadedPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayDownloadPodcastList(showlist: List<DownloadVO>) {
        Toast.makeText(context,"Download list "+showlist.size,Toast.LENGTH_SHORT).show()
        showsAdapter.setNewData(showlist.toMutableList())
    }

    override fun navigateToDetail(downloadVO: DownloadVO) {
        startActivity(PodCastDetailActivity.newIntent(activity as Context, downloadVO.download_id,
            DOWNLOADPAGE,downloadVO.download_audio_path!!))
    }

}