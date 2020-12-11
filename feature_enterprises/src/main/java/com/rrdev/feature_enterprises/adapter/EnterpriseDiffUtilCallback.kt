package com.rrdev.feature_enterprises.adapter

import androidx.recyclerview.widget.DiffUtil
import com.rrdev.base_presentation.model.EnterpriseBinding

class EnterpriseDiffUtilCallback(private val oldList: List<EnterpriseBinding>, private val newList: List<EnterpriseBinding>): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].hashCode() == newList[newItemPosition].hashCode()
}