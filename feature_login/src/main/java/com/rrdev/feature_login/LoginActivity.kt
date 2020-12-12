package com.rrdev.feature_login

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.rrdev.base_feature.extensions.*
import com.rrdev.base_feature.navigationIntent
import com.rrdev.base_presentation.onPostValue
import com.rrdev.feature_login.databinding.ActivityLoginBinding
import com.rrdev.feature_login.navigation.LoginNavigation
import com.rrdev.presentation_login.LogInViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class LoginActivity : AppCompatActivity(), LifecycleOwner, KoinComponent {

    private val viewModel: LogInViewModel by viewModel()
    private val navigation: LoginNavigation by navigationIntent()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        addObservers()
    }

    private fun setupView() = binding.run {
        buttonConfirm.setOnClickListener {
            viewModel.authUser(
                editTextEmail.asString(),
                editTextPassword.asString()
            )
        }

        editTextPassword.handleImeOption(EditorInfo.IME_ACTION_DONE) {
            viewModel.authUser(
                editTextEmail.asString(),
                editTextPassword.asString()
            )
        }
    }

    private fun addObservers(){
        viewModel.logInViewState.onPostValue(this,
            onSuccess = {
                loadDialogDismiss()
                navigation.navigateToEnterprises()
            },
            onError = {
                loadDialogDismiss()
                binding.textMessage.text = it.message
                binding.textMessage.setVisible()
            },
            onLoading = {
                loadDialogShow()
            }
        )
    }
}