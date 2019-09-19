package com.merveylcu.marketim.view.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.merveylcu.marketim.util.SharedPref
import com.merveylcu.marketim.view.orders.OrdersActivity

class SessionControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val hasSessionInfo = !SharedPref(this).username.isNullOrEmpty() && !SharedPref(this).password.isNullOrEmpty()

        val intent = if (hasSessionInfo) {
            Intent(this, OrdersActivity::class.java)
        } else {
            Intent(this, LoginActivity::class.java)
        }

        startActivity(intent)
        finish()

    }
}
