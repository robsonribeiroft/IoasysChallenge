package com.rrdev.base_feature.extensions

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rrdev.base_feature.R

fun View.setVisible(){
    visibility = View.VISIBLE
}

fun View.setInVisible(){
    visibility = View.INVISIBLE
}

fun View.setGone(){
    visibility = View.GONE
}

fun ImageView.loadImageUrl(
    context: Context,
    url: String,
    placeholder: Int = R.drawable.logo_home,
    error: Int = R.drawable.logo_home
){
    Glide.with(context)
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .into(this)
}

fun ImageView.loadImageUrl(
    view: View,
    url: String,
    placeholder: Int = R.drawable.logo_home,
    error: Int = R.drawable.logo_home
){
    Glide.with(view)
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .into(this)
}