package com.rajsubhod.projectcrypto.crypto.data.mappers

import com.rajsubhod.projectcrypto.crypto.data.networking.dto.CoinDto
import com.rajsubhod.projectcrypto.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin (
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}