package dev.vova.chronica.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Brand palette — "parchment & ink".
private val Parchment = Color(0xFFF3ECDF)
private val SurfaceLight = Color(0xFFFBF7EF)
private val Ink = Color(0xFF221F1A)
private val InkSoft = Color(0xFF6E665A)
private val Bordeaux = Color(0xFF7B2D2D)
private val Gold = Color(0xFFB0863C)
private val HairlineLight = Color(0xFFD9CDB8)
private val PaperOnAccent = Color(0xFFFBF7EF)

private val Walnut = Color(0xFF17140F)
private val SurfaceDark = Color(0xFF221E17)
private val PaperText = Color(0xFFECE4D5)
private val PaperMuted = Color(0xFFA59B89)
private val BordeauxLight = Color(0xFFC46A5C)
private val GoldLight = Color(0xFFCAA24E)
private val HairlineDark = Color(0xFF3A342A)

val ChronicaLightColors = lightColorScheme(
    primary = Bordeaux,
    onPrimary = PaperOnAccent,
    secondary = Gold,
    onSecondary = PaperOnAccent,
    tertiary = Gold,
    onTertiary = PaperOnAccent,
    background = Parchment,
    onBackground = Ink,
    surface = SurfaceLight,
    onSurface = Ink,
    surfaceVariant = Color(0xFFECE1CE),
    onSurfaceVariant = InkSoft,
    outline = HairlineLight,
    error = Color(0xFF9B2C2C),
    onError = PaperOnAccent,
)

val ChronicaDarkColors = darkColorScheme(
    primary = BordeauxLight,
    onPrimary = Color(0xFF2A1512),
    secondary = GoldLight,
    onSecondary = Color(0xFF2A1F0A),
    tertiary = GoldLight,
    onTertiary = Color(0xFF2A1F0A),
    background = Walnut,
    onBackground = PaperText,
    surface = SurfaceDark,
    onSurface = PaperText,
    surfaceVariant = Color(0xFF2E2A20),
    onSurfaceVariant = PaperMuted,
    outline = HairlineDark,
    error = Color(0xFFE0897C),
    onError = Color(0xFF2A1512),
)
