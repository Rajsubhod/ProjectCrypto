package com.rajsubhod.projectcrypto.crypto.presentation.coin_list

import com.rajsubhod.projectcrypto.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi) : CoinListAction
}