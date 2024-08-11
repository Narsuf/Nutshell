package com.n27.nutshell.presentation.common.composables.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import com.n27.nutshell.presentation.common.constants.Palette

@Composable
fun NavIcon(url: String, isSelected: Boolean) {

    Icon(
        url = url,
        colorFilter = ColorFilter.tint(
            if (isSelected)
                Palette.Teal
            else
                Color.Gray
        )
    )
}