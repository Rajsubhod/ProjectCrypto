package com.rajsubhod.projectcrypto.crypto.domain

import com.rajsubhod.projectcrypto.crypto.data.networking.dto.CoinDto
import kotlinx.serialization.Serializable

@Serializable
data class CoinsResponseDto (
    val data: List<CoinDto>
)