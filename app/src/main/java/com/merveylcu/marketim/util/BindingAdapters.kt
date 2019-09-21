package com.merveylcu.marketim.util

import android.graphics.Color
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.merveylcu.marketim.R
import com.merveylcu.marketim.data.model.Order
import com.merveylcu.marketim.data.model.ProductState.*
import com.merveylcu.marketim.view.order.OrderListAdapter

@BindingAdapter("adapter_order_list")
fun setAdapterOrderList(expandableListView: ExpandableListView, orderList: MutableLiveData<ArrayList<Order>>) {
    orderList.value?.let {
        val adapter = OrderListAdapter(it)
        expandableListView.setAdapter(adapter)
        adapter.notifyDataSetChanged()
    }
}

@BindingAdapter("icon_product_state")
fun setIconProductState(imageView: ImageView, productState: String) {
    when (productState) {
        PREPARING.getStateName() -> imageView.setImageResource(R.drawable.orange_square)
        WAITING_FOR_APPROVAL.getStateName() -> imageView.setImageResource(R.drawable.red_square)
        ON_THE_ROAD.getStateName() -> imageView.setImageResource(R.drawable.green_square)
        else -> {
        }
    }
}

@BindingAdapter("text_color_product_state")
fun setTextColorProductState(textView: TextView, productState: String) {
    when (productState) {
        PREPARING.getStateName() -> textView.setTextColor(Color.YELLOW)
        WAITING_FOR_APPROVAL.getStateName() -> textView.setTextColor(Color.RED)
        ON_THE_ROAD.getStateName() -> textView.setTextColor(Color.GREEN)
        else -> {
        }
    }
}