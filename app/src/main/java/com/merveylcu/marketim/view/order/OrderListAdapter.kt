package com.merveylcu.marketim.view.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.databinding.DataBindingUtil
import com.merveylcu.marketim.R
import com.merveylcu.marketim.databinding.OrdersListChildBinding
import com.merveylcu.marketim.databinding.OrdersListGroupBinding
import com.merveylcu.marketim.data.model.Order
import com.merveylcu.marketim.data.model.ProductDetail

class OrderListAdapter(private val ordersList: ArrayList<Order>) : BaseExpandableListAdapter() {

    override fun getGroup(groupPosition: Int): Order {
        return ordersList[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosititon: Int): Boolean {
        return false
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View? {
        var binding: OrdersListGroupBinding? = convertView?.let { DataBindingUtil.getBinding(it) }
        if (binding == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.orders_list_group, parent, false)
        }
        binding?.orderItem = getGroup(groupPosition)
        binding?.executePendingBindings()
        return binding?.root
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getChild(groupPosition: Int, childPosititon: Int): ProductDetail {
        return ordersList[groupPosition].productDetail
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosititon: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View? {
        var binding: OrdersListChildBinding? = convertView?.let { DataBindingUtil.getBinding(it) }
        if (binding == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.orders_list_child, parent, false)
        }
        binding?.productDetail = getChild(groupPosition, childPosititon)
        binding?.executePendingBindings()
        return binding?.root
    }

    override fun getChildId(groupPosition: Int, childPosititon: Int): Long {
        return childPosititon.toLong()
    }

    override fun getGroupCount(): Int {
        return ordersList.size
    }

}