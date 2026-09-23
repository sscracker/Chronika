package dev.vova.chronica.di

import org.koin.core.context.startKoin
import org.koin.core.context.GlobalContext
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    if (GlobalContext.getOrNull() != null) return
    startKoin {
        appDeclaration()
        modules(appModules)
    }
}
