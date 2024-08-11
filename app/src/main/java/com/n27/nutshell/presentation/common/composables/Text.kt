package com.n27.nutshell.presentation.common.composables

import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.n27.nutshell.presentation.common.constants.Palette
import com.n27.nutshell.presentation.common.constants.Typography

@Composable
fun Text(text: String, isSelected: Boolean = false) {

    androidx.compose.material3.Text(
        text = text,
        color = if (isSelected)
            Palette.teal700
        else
            Color.Black,
        style = if (isSelected)
            Typography.bold
        else
            LocalTextStyle.current
    )
}