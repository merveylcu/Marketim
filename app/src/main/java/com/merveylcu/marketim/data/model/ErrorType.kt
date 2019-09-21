package com.merveylcu.marketim.data.model

import com.merveylcu.marketim.R

enum class ErrorType(private var stringResId: Int) {
    PROBLEM_HAS_OCCURRED(R.string.problem_has_occurred),
    NOT_FOUND_NETWORK_CONN(R.string.not_found_network_conn);

    fun getStringResId(): Int {
        return stringResId
    }
}