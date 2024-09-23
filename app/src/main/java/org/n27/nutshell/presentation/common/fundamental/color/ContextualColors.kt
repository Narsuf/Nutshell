package org.n27.nutshell.presentation.common.fundamental.color

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
class Background(
    neutral: Color,
    neutralAlternate: Color
) {
    var neutral: Color by mutableStateOf(neutral)
        internal set

    var neutralAlternate: Color by mutableStateOf(neutralAlternate)
        internal set
}

@Stable
class Stroke(
    neutral: Color
) {
    var neutral: Color by mutableStateOf(neutral)
        internal set
}

@Stable
class Typography(
    neutral: Color,
    neutralAlternate: Color,
    teal: Color
) {
    var neutral: Color by mutableStateOf(neutral)
        internal set

    var neutralAlternate: Color by mutableStateOf(neutralAlternate)
        internal set

    var teal: Color by mutableStateOf(teal)
        internal set
}


@Stable
class BackgroundInternal(
    overlay: Color
) {
    var overlay: Color by mutableStateOf(overlay)
        internal set
}

@Stable
class ContextualColors(
    background: Background,
    stroke: Stroke,
    typography: Typography,
    backgroundInternal: BackgroundInternal
) {
    var background: Background by mutableStateOf(background)
        internal set

    var stroke: Stroke by mutableStateOf(stroke)
        internal set

    var typography: Typography by mutableStateOf(typography)
        internal set

    var backgroundInternal: BackgroundInternal by mutableStateOf(backgroundInternal)
        internal set
}

internal fun ContextualColors.updateColorsFrom(other: ContextualColors) {
    background = other.background
}

internal val LocalColor = staticCompositionLocalOf<ContextualColors> {
    error("No LocalColor provided")
}
