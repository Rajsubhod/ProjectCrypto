package com.rajsubhod.projectcrypto

import android.app.Application
import com.rajsubhod.projectcrypto.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProjectCryptoApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@ProjectCryptoApp)
            androidLogger()

            modules(appModule)
        }
    }
}