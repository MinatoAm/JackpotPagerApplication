package com.example.jackpotpagerapplication

import android.app.Application
import com.example.jackpotpagerapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JackpotApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JackpotApplication)
            modules(appModule)
        }
    }
}