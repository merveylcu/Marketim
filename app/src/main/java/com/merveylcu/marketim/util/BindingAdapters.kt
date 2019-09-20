package com.merveylcu.marketim.util

import android.widget.ExpandableListView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.merveylcu.marketim.data.model.Order
import com.merveylcu.marketim.view.order.OrderListAdapter

@BindingAdapter("adapter_order_list")
fun setAdapterOrderList(expandableListView: ExpandableListView, orderList: MutableLiveData<ArrayList<Order>>) {
    orderList.value?.let {
        val adapter = OrderListAdapter(it)
        expandableListView.setAdapter(adapter)
        adapter.notifyDataSetChanged()
    }
}