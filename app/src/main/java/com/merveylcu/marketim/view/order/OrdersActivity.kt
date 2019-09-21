package com.merveylcu.marketim.view.order

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.merveylcu.marketim.R
import com.merveylcu.marketim.databinding.ActivityOrdersBinding
import com.merveylcu.marketim.util.SharedPref
import com.merveylcu.marketim.util.Util

class OrdersActivity : AppCompatActivity() {

    private lateinit var ordersViewModel: OrdersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ordersViewModel = setupBinding()
        listenEvents()
    }

    private fun setupBinding(): OrdersViewModel {
        val binding = DataBindingUtil.setContentView<ActivityOrdersBinding>(this, R.layout.activity_orders)
        val viewModel = ViewModelProviders.of(this).get(OrdersViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return viewModel
    }

    private fun listenEvents() {
        ordersViewModel.toastMessage.observe(this, Observer { stringResId ->
            stringResId.let {
                Util.showToast(this, stringResId)
            }
        })
        ordersViewModel.logoutCallback.observe(this, Observer {
            showLogoutDialog()
        })
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
                .setMessage(resources.getString(R.string.dialog_title_logout))
                .setPositiveButton(resources.getString(R.string.yes)) { _, _ ->
                    SharedPref(this).clearCredentials()
                    this.finish()
                }
                .setNegativeButton(resources.getString(R.string.no)) { _, _ -> }
                .show()
    }

}
