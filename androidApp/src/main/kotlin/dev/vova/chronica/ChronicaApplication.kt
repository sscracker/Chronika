package dev.vova.chronica

import android.app.Application
import dev.vova.chronica.di.initKoin

class ChronicaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
