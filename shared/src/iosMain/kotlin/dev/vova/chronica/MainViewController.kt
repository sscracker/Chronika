package dev.vova.chronica

import androidx.compose.ui.window.ComposeUIViewController
import dev.vova.chronica.di.initKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    initKoin()
    return ComposeUIViewController { App() }
}
