package com.rajsubhod.projectcrypto.crypto.data.networking

import com.rajsubhod.projectcrypto.core.data.network.constructUrl
import com.rajsubhod.projectcrypto.core.data.network.safeCall
import com.rajsubhod.projectcrypto.core.domain.util.NetworkError
import com.rajsubhod.projectcrypto.core.domain.util.Result
import com.rajsubhod.projectcrypto.core.domain.util.map
import com.rajsubhod.projectcrypto.crypto.data.mappers.toCoin
import com.rajsubhod.projectcrypto.crypto.domain.Coin
import com.rajsubhod.projectcrypto.crypto.domain.CoinDataSource
import com.rajsubhod.projectcrypto.crypto.domain.CoinsResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

}