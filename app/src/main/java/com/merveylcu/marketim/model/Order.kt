package com.merveylcu.marketim.model

data class Order(val date: String,
                 var month: String,
                 var marketName: String,
                 var orderName: String,
                 var productPrice: Double,
                 var productState: String,
                 var productDetail: ProductDetail)