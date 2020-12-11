package com.rrdev.feature_enterprises.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rrdev.base_feature.extensions.loadImageUrl
import com.rrdev.base_feature.extensions.setDiffUtil
import com.rrdev.base_presentation.model.EnterpriseBinding
import com.rrdev.feature_enterprises.R
import kotlinx.android.synthetic.main.adapter_enterprise_layout.view.*

class EnterpriseAdapter: RecyclerView.Adapter<EnterpriseAdapter.ViewHolder>() {

    var onItemSelect: ((Int) -> Unit)? = null
    var enterpriseList = emptyList<EnterpriseBinding>()
        set(value) {
            setDiffUtil(EnterpriseDiffUtilCallback(enterpriseList, value))
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.adapter_enterprise_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindContent(enterpriseList[position])

    override fun getItemCount(): Int = enterpriseList.size

    fun getItemByPosition(position: Int) = enterpriseList[position]

    inner class ViewHolder(
        private val view: View
    ): RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener { onItemSelect?.invoke(adapterPosition) }
        }

        fun bindContent(enterprise: EnterpriseBinding) = view.run {

            img_logo.loadImageUrl(view, enterprise.photo)

            text_name.text = enterprise.enterpriseName
            text_content.text = enterprise.enterpriseType.enterpriseTypeName
            text_location.text = enterprise.country
        }
    }

}