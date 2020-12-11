package com.rrdev.base_feature.extensions

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.Adapter<*>.setDiffUtil(diffUtilCallback: DiffUtil.Callback){
    DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
}