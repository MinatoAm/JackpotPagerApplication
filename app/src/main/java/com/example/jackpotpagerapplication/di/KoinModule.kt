package com.example.jackpotpagerapplication.di

import com.example.jackpotpagerapplication.data.network.JackpotApi
import com.example.jackpotpagerapplication.data.repository.JackpotRepository
import com.example.jackpotpagerapplication.data.repository.JackpotRepositoryImpl
import com.example.jackpotpagerapplication.ui.jackpot.JackpotViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://pm.by/siteapi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(JackpotApi::class.java) }

    single<JackpotRepository> { JackpotRepositoryImpl(get()) }

    viewModel { JackpotViewModel(get()) }
}