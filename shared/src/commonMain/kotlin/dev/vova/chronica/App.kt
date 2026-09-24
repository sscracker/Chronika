package dev.vova.chronica

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.network.ktor3.KtorNetworkFetcherFactory
import dev.vova.chronica.ui.theme.ChronicaTheme
import dev.vova.chronica.ui.today.TodayScreen

@Composable
fun App() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .components { add(KtorNetworkFetcherFactory()) }
            .build()
    }

    ChronicaTheme {
        TodayScreen()
    }
}
