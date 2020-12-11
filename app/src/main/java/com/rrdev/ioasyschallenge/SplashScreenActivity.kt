package com.rrdev.ioasyschallenge

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rrdev.base_presentation.onPostValue
import com.rrdev.feature_enterprises.EnterprisesListActivity
import com.rrdev.feature_login.LoginActivity
import com.rrdev.presentation_splashscreen.SplashScreenViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SplashScreenActivity : AppCompatActivity() {

    private val viewModel: SplashScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        viewModel.allEnterprisesViewState.onPostValue(this,
            onSuccess = {
                startActivity(Intent(applicationContext, EnterprisesListActivity::class.java))
                finish()
            },
            onError = {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                finish()
            }
        )
        viewModel.fetchEnterprises()
    }
}