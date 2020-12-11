package com.rrdev.feature_enterprises

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rrdev.base_feature.extensions.loadImageUrl
import com.rrdev.base_feature.extensions.setToolbar
import com.rrdev.base_presentation.model.EnterpriseBinding
import com.rrdev.feature_enterprises.databinding.LayoutDetailEnterpriseBinding

class EnterpriseDetailActivity : AppCompatActivity() {

    private lateinit var enterprise: EnterpriseBinding
    private lateinit var binding: LayoutDetailEnterpriseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutDetailEnterpriseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enterprise = intent?.getParcelableExtra(PARCELABLE_KEY) ?: throw Exception("Enterprise can't be null")

        setupView()
    }

    private fun setupView() = binding.run {
        setToolbar(toolbar, navigationUp = true, title = enterprise.enterpriseName)
        textDescription.text = enterprise.description
        imgLogo.loadImageUrl(applicationContext, enterprise.photo)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object{
        private const val PARCELABLE_KEY = "ENTERPRISE_KEY"

        fun newActivityInstance(context: Context, enterprise: EnterpriseBinding) {
            val intent = Intent(context, EnterpriseDetailActivity::class.java).apply {
                putExtra(PARCELABLE_KEY, enterprise)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }

}