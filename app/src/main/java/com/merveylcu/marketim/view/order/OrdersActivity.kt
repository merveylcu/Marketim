package com.merveylcu.marketim.view.order

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.merveylcu.marketim.R
import com.merveylcu.marketim.databinding.ActivityOrdersBinding
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
    }

}
