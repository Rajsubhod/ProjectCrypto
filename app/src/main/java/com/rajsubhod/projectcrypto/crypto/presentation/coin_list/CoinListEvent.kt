package com.rajsubhod.projectcrypto.crypto.presentation.coin_list

import com.rajsubhod.projectcrypto.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}