package com.padcx.mmz.podcast.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.mmz.podcast.R
import com.padcx.mmz.podcast.adapter.CategoryItemAdapter
import com.padcx.mmz.podcast.adapter.UpNextShowItemAdapter
import com.padcx.mmz.podcast.data.ShowVO
import com.padcx.mmz.podcast.data.vos.GenresVO
import com.padcx.mmz.podcast.data.vos.PlaylistVO
import com.padcx.mmz.podcast.mvp.presenterImpls.GenresPresenterImpl
import com.padcx.mmz.podcast.mvp.presenters.GenresPresenter
import com.padcx.mmz.podcast.mvp.view.CategoryView
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_search.view.*

/**
 * Created by Myint Myint Zaw on 8/23/2020.
 */
@Suppress("DEPRECATION")
class SearchFragment : Fragment(), CategoryView {

    private lateinit var categoryAdapter: CategoryItemAdapter
    val categorylist: ArrayList<ShowVO> = arrayListOf()

    private lateinit var generePresenter: GenresPresenter

    companion object {
        lateinit var mContext: Context
        fun newInstance(context: Context): SearchFragment {
            mContext = context
            return SearchFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        setUpPresenter()
        generePresenter.onUiReady(this)

        categoryAdapter = CategoryItemAdapter()
        val linearLayoutManager =
            LinearLayoutManager(DownloadFragment.mContext, LinearLayoutManager.HORIZONTAL, false)
        view.rv_category.layoutManager = linearLayoutManager
        view.rv_category.adapter = categoryAdapter

        /*   categorylist.add(
               ShowVO(
                   "",
                   "",
                   "",
                   R.drawable.podcastimage
               )
           )


           categorylist.add(
               ShowVO(
                   "",
                   "",
                   "",
                   R.drawable.podcastimage
               )
           )

           categoryAdapter.setNewData(categorylist)*/

        return view

    }

    private fun setUpPresenter() {
        generePresenter = ViewModelProviders.of(this).get(GenresPresenterImpl::class.java)
        generePresenter.initPresenter(this)
    }

    override fun displayGenre(genreList: List<GenresVO>) {
        categoryAdapter.setNewData(genreList.toMutableList())
    }

}