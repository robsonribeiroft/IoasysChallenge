package com.rrdev.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.rrdev.feature_enterprises.EnterprisesListActivity
import com.rrdev.feature_login.navigation.LoginNavigation

class LoginNavigationImpl(private val activity: AppCompatActivity): LoginNavigation {
    override fun navigateToEnterprises() {
        activity.startActivity(
            Intent(
                activity.applicationContext,
                EnterprisesListActivity::class.java
            )
        )
    }
}