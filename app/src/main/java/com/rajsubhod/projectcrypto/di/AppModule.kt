package com.rajsubhod.projectcrypto.di

import com.rajsubhod.projectcrypto.core.data.network.HttpClientFactory
import com.rajsubhod.projectcrypto.crypto.data.networking.RemoteCoinDataSource
import com.rajsubhod.projectcrypto.crypto.domain.CoinDataSource
import com.rajsubhod.projectcrypto.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}