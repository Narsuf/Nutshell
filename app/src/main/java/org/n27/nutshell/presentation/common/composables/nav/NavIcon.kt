package org.n27.nutshell.presentation.common.composables.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.composables.Icon
import org.n27.nutshell.presentation.common.constants.Palette
import org.n27.nutshell.presentation.common.constants.Spacing

private val NavIconSize = 16.dp

@Composable
fun NavIcon(url: String, isSelected: Boolean) {

    Icon(
        url = url,
        modifier = Modifier.padding(Spacing.tightest),
        size = NavIconSize,
        colorFilter = ColorFilter.tint(
            if (isSelected)
                Palette.Teal500
            else
                Color.Black
        )
    )
}