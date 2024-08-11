package org.n27.nutshell.presentation.common.composables.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import org.n27.nutshell.presentation.common.composables.Icon
import org.n27.nutshell.presentation.common.constants.Palette

@Composable
fun NavIcon(url: String, isSelected: Boolean) {

    Icon(
        url = url,
        colorFilter = ColorFilter.tint(
            if (isSelected)
                Palette.Teal500
            else
                Color.Black
        )
    )
}