package com.merveylcu.marketim.data.model

enum class ProductState(private var stateName: String) {
    WAITING_FOR_APPROVAL("Onay Bekliyor"),
    PREPARING("Hazırlanıyor"),
    ON_THE_ROAD("Yolda");

    override fun toString(): String {
        return stateName
    }
}