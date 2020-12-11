package com.rrdev.base_feature.core

import androidx.recyclerview.widget.DiffUtil

class GenericDiffUtilCallback(private val oldList: List<Any>, private val newList: List<Any>): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].hashCode() == newList[newItemPosition].hashCode()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].hashCode() == newList[newItemPosition].hashCode()
}