package com.metelev.bos.spin

import android.app.Application
import android.content.Context
import com.metelev.bos.spin.di.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class App : Application() {
    
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(viewModelModule)
        }
    }
}