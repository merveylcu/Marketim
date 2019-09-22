package com.merveylcu.marketim.service

import com.merveylcu.marketim.data.model.Order
import com.merveylcu.marketim.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {

    @GET(".")
    fun getOrderList(): Call<ArrayList<Order>>

    companion object {
        @Volatile
        private var instance: WebService? = null

        fun getInstance(): WebService {
            return instance
                    ?: synchronized(this) {
                        instance
                                ?: buildWebService().also { instance = it }
                    }
        }

        private fun buildWebService(): WebService {
            val client: OkHttpClient = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                    .baseUrl(Constants.Urls.baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WebService::class.java)
        }
    }

}