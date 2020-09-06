package com.padcx.mmz.podcast.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */

fun ImageView.load(url :String){
    Glide.with(context).load(url).into(this)
}


fun Int.checkTime():String{
    val min: Int = this / 60 % 60
    val hours: Int = this / 60 / 60
    if(hours <= 0){
        return "$min min"
    }
    return "$hours hr $min min"
}
