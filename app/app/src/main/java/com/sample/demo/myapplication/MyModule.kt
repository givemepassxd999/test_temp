package com.sample.demo.myapplication

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    viewModel { InfoViewModel(androidApplication(), get()) }
}

val repoModule = module {
    single { InfoRepository() }
}