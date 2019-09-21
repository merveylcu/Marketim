package com.merveylcu.marketim.data.model

enum class ProductState(private var stateName: String) {
    PREPARING("Hazırlanıyor"),
    WAITING_FOR_APPROVAL("Onay Bekliyor"),
    ON_THE_ROAD("Yolda");

    fun getStateName(): String {
        return stateName
    }
}