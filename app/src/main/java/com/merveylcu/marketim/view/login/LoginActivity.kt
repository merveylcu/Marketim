package com.merveylcu.marketim.view.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.merveylcu.marketim.R
import com.merveylcu.marketim.databinding.ActivityLoginBinding
import com.merveylcu.marketim.util.Util
import com.merveylcu.marketim.view.login.LoginScreenResult.*
import com.merveylcu.marketim.view.order.OrdersActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = setupBinding()
        listenEvents()
    }

    private fun setupBinding(): LoginViewModel {
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return viewModel
    }

    private fun listenEvents() {
        loginViewModel.loginScreenResult.observe(this, Observer { loginScreenResult ->
            when (loginScreenResult) {
                EMPTY_INFO -> Util.showToast(this, R.string.empty_info)
                WRONG_USER_INFO -> Util.showToast(this, R.string.wrong_user_info)
                SUCCESSFUL -> openNextScreen()
                else -> {
                }
            }
        })
    }

    private fun openNextScreen() {
        val intent = Intent(this, OrdersActivity::class.java)
        startActivity(intent)
        this.finish()
    }

}
