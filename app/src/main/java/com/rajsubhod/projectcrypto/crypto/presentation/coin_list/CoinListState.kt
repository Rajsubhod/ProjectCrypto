package com.rajsubhod.projectcrypto.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.rajsubhod.projectcrypto.crypto.presentation.models.CoinUi

@Immutable
class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null,
)