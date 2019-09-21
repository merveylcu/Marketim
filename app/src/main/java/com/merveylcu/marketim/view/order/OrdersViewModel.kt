package com.merveylcu.marketim.view.order

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.merveylcu.marketim.data.OrderRepository
import com.merveylcu.marketim.data.model.ErrorType
import com.merveylcu.marketim.data.model.Order
import com.merveylcu.marketim.service.IServiceResponse

class OrdersViewModel(application: Application) : AndroidViewModel(application), IServiceResponse {

    var toastMessage = MutableLiveData<Int>()
    var orderList: MutableLiveData<ArrayList<Order>> = OrderRepository(getApplication()).getOrderList(this)

    override fun serviceResponseSuccessful() {

    }

    override fun serviceResponseFail(errorType: ErrorType) {
        toastMessage.postValue(errorType.getStringResId())
    }

}