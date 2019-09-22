package com.merveylcu.marketim.view.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.databinding.DataBindingUtil
import com.merveylcu.marketim.R
import com.merveylcu.marketim.data.model.Order
import com.merveylcu.marketim.data.model.ProductDetail
import com.merveylcu.marketim.databinding.OrderListChildBinding
import com.merveylcu.marketim.databinding.OrderListGroupBinding

class OrderListAdapter(private val orderList: ArrayList<Order>) : BaseExpandableListAdapter() {

    override fun getGroup(groupPosition: Int): Order {
        return orderList[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosititon: Int): Boolean {
        return false
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    /**
     * order_list_group arayüzüne orderItem verisinin binding edilmesi.
     */
    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View? {
        var binding: OrderListGroupBinding? = convertView?.let { DataBindingUtil.getBinding(it) }
        if (binding == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.order_list_group, parent, false)
        }
        binding?.orderItem = getGroup(groupPosition)
        binding?.executePendingBindings()
        return binding?.root
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getChild(groupPosition: Int, childPosititon: Int): ProductDetail {
        return orderList[groupPosition].productDetail
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    /**
     * order_list_child arayüzüne productDetail verisinin binding edilmesi.
     */
    override fun getChildView(groupPosition: Int, childPosititon: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View? {
        var binding: OrderListChildBinding? = convertView?.let { DataBindingUtil.getBinding(it) }
        if (binding == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.order_list_child, parent, false)
        }
        binding?.productDetail = getChild(groupPosition, childPosititon)
        binding?.executePendingBindings()
        return binding?.root
    }

    override fun getChildId(groupPosition: Int, childPosititon: Int): Long {
        return childPosititon.toLong()
    }

    override fun getGroupCount(): Int {
        return orderList.size
    }

}