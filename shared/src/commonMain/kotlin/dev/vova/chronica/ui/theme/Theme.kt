package dev.vova.chronica.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ChronicaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) ChronicaDarkColors else ChronicaLightColors,
        typography = chronicaTypography(),
        shapes = ChronicaShapes,
        content = content,
    )
}
