package com.metelev.bos.spin.di.koin

import com.metelev.bos.spin.ui.GamesSpinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GamesSpinViewModel() }
}