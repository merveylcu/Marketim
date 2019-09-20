package com.merveylcu.marketim.service

import com.merveylcu.marketim.data.model.ErrorType

interface IServiceResponse {
    fun serviceResponseSuccessful()
    fun serviceResponseFail(errorType: ErrorType)
}