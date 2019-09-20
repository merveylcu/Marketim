package com.merveylcu.marketim.view.orders

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.merveylcu.marketim.model.Order
import com.merveylcu.marketim.model.ProductDetail

class OrdersViewModel(application: Application) : AndroidViewModel(application) {

    val orderList = arrayListOf<Order>().apply { this.add(Order("20", "09", "MarketA", "Asdasd", 50.0, "Yolda", ProductDetail("detail", 50.0))) }
    val orderListAdapter = OrderListAdapter(orderList)

}