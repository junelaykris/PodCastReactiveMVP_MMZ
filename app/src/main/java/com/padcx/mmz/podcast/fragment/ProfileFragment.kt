package com.padcx.mmz.podcast.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.padcx.mmz.podcast.R

/**
 * Created by Myint Myint Zaw on 8/23/2020.
 */
class ProfileFragment :Fragment(){

    companion object {
        lateinit var mContext: Context
        fun newInstance(context: Context): ProfileFragment {
            mContext = context
            return ProfileFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_profile, container, false)

        return view

    }
}