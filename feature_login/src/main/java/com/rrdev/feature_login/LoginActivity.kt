package com.rrdev.feature_login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.rrdev.base_feature.navigationIntent
import com.rrdev.base_presentation.onPostValue
import com.rrdev.feature_login.navigation.LoginNavigation
import com.rrdev.presentation_login.LogInViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class LoginActivity : AppCompatActivity(), LifecycleOwner, KoinComponent {

    private val viewModel: LogInViewModel by viewModel()
    private val navigation: LoginNavigation by navigationIntent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupView()
        addObservers()
    }

    private fun setupView(){
        button_confirm.setOnClickListener {
            viewModel.authUser(
                edit_text_email.text.toString(),
                edit_text_password.text.toString()
            )
        }
    }

    private fun addObservers(){
        viewModel.logInViewState.onPostValue(this,
            onSuccess = {
                Log.d("loginViewState", "DEU CERTO !!!!")
                navigation.navigateToEnterprises()
            },
            onError = {
                Log.d("loginViewState", "error: ${it.message}")
            },
            onLoading = {
                Log.d("loginViewState", "load...")
            }
        )
    }
}