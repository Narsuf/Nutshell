package org.n27.nutshell.presentation.common.fundamental.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class CornerRadius internal constructor(
    val soft: Dp = 4.dp,
    val smooth: Dp = 8.dp
)

internal val LocalCornerRadius = staticCompositionLocalOf { CornerRadius() }
