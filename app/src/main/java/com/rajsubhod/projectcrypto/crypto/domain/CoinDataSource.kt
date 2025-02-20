package com.rajsubhod.projectcrypto.crypto.domain

import com.rajsubhod.projectcrypto.core.domain.util.NetworkError
import com.rajsubhod.projectcrypto.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}