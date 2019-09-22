package com.merveylcu.marketim.view.order

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.merveylcu.marketim.data.OrderRepository
import com.merveylcu.marketim.data.model.ErrorType
import com.merveylcu.marketim.data.model.Order
import com.merveylcu.marketim.service.IServiceResponse

class OrdersViewModel(application: Application) : AndroidViewModel(application), IServiceResponse {

    var toastMessage = MutableLiveData<Int>()
    var logoutCallback = MutableLiveData<Boolean>()
    var orderList: MutableLiveData<ArrayList<Order>> = OrderRepository(getApplication()).getOrderList(this)

    /**
     * servisten olumlu cevap alınması durumunda çalışır.
     */
    override fun serviceResponseSuccessful() {

    }

    /**
     * servisten olumsuz cevap alınması durumunda çalışır.
     */
    override fun serviceResponseFail(errorType: ErrorType) {
        toastMessage.postValue(errorType.getStringResId())
    }

    /**
     * çıkış yap butonuna basılması durumunda çalışır.
     * logoutCallback verisini tetikler.
     */
    fun logout(view: View) {
        logoutCallback.postValue(true)
    }

}