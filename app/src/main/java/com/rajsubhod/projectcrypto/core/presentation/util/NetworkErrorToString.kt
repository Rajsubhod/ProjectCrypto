package com.rajsubhod.projectcrypto.core.presentation.util

import android.content.Context
import com.rajsubhod.projectcrypto.R
import com.rajsubhod.projectcrypto.core.domain.util.NetworkError

fun NetworkError.toString(context: Context): String {
    val resId =  when(this) {
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUESTS -> R.string.error_to_many_requests
        NetworkError.NO_INTERNET -> R.string.error_no_internet
        NetworkError.SERVER_ERROR -> R.string.error_unknown
        NetworkError.SERIALIZATION -> R.string.error_serialization
        NetworkError.UNKNOWN -> R.string.error_unknown
    }

    return context.getString(resId)
}