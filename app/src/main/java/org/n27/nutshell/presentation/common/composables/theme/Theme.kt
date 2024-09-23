package org.n27.nutshell.presentation.common.composables.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import org.n27.nutshell.presentation.common.fundamental.color.Background
import org.n27.nutshell.presentation.common.fundamental.color.BackgroundInternal
import org.n27.nutshell.presentation.common.fundamental.color.ContextualColors
import org.n27.nutshell.presentation.common.fundamental.color.LocalColor
import org.n27.nutshell.presentation.common.fundamental.color.Palette
import org.n27.nutshell.presentation.common.fundamental.color.Stroke
import org.n27.nutshell.presentation.common.fundamental.color.Typography
import org.n27.nutshell.presentation.common.fundamental.color.updateColorsFrom

@Composable
fun Theme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (isDarkTheme) DarkThemeColors else LightThemeColors
    val colorPalette = remember { colors }.apply { updateColorsFrom(colors) }

    CompositionLocalProvider(LocalColor provides colorPalette) {
        val activity = LocalContext.current as? Activity

        activity?.window?.apply {
            statusBarColor = themeDefaultBackground().toArgb()
            navigationBarColor = Theme.colors.background.neutralAlternative.toArgb()
        }

        MaterialTheme(colors = materialToThemeMappedColors()) { content() }
    }
}

private val LightThemeColors = ContextualColors(
    background = Background(
        neutral = Color.White,
        neutralAlternative = Color.White
    ),
    stroke = Stroke(
        neutral = Palette.Gray200
    ),
    typography = Typography(
        neutral = Color.Black,
        neutralAlternative = Palette.Gray600,
        teal = Palette.Teal500,
    ),
    backgroundInternal = BackgroundInternal(
        overlay = Color(0x29121212)
    )
)

private val DarkThemeColors = ContextualColors(
    background = Background(
        neutral = Palette.Dark,
        neutralAlternative = Palette.SofterDark
    ),
    stroke = Stroke(
        neutral = Palette.Gray815
    ),
    typography = Typography(
        neutral = Color.White,
        neutralAlternative = Palette.Gray500,
        teal = Palette.Teal500
    ),
    backgroundInternal = BackgroundInternal(
        overlay = Color(0x14F9F9F9)
    )
)

@Stable
@Composable
internal fun themeDefaultBackground() = Theme.colors.background.neutral

@Stable
@Composable
internal fun themeDefaultStroke() = Theme.colors.stroke.neutral

@Stable
@Composable
internal fun themeDefaultTypography() = Theme.colors.typography.neutral

@Stable
@Composable
internal fun themeDefaultRipple() = Theme.colors.backgroundInternal.overlay

@Composable
private fun materialToThemeMappedColors() = lightColors(
    background = themeDefaultBackground(),
    surface = themeDefaultBackground(),
    onBackground = themeDefaultTypography(),
    onSurface = themeDefaultTypography(),
)

object Theme {

    val colors: ContextualColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current
}
