package com.merveylcu.marketim.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.merveylcu.marketim.data.model.ErrorType
import com.merveylcu.marketim.data.model.Order
import com.merveylcu.marketim.service.IServiceResponse
import com.merveylcu.marketim.service.WebService
import com.merveylcu.marketim.util.Util
import com.merveylcu.marketim.util.runOnIoThread

class Repository(private val context: Context) {

    private val webService = WebService.getInstance()

    fun getOrderList(iServiceResponse: IServiceResponse): MutableLiveData<ArrayList<Order>> {
        val orderList = MutableLiveData<ArrayList<Order>>()
        if (Util.isConnectedToInternet(context)) {
            runOnIoThread {
                val response = webService.getOrderList().execute().body()
                response?.let {
                    orderList.postValue(it)
                    iServiceResponse.serviceResponseSuccessful()
                } ?: also {
                    iServiceResponse.serviceResponseFail(ErrorType.PROBLEM_HAS_OCCURRED)
                }
            }
        } else {
            iServiceResponse.serviceResponseFail(ErrorType.NOT_FOUND_NETWORK_CONN)
        }
        return orderList
    }

}