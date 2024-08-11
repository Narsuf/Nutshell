package com.n27.nutshell.presentation.common.composables.text

import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun Text(
    text: String,
    color: Color = Color.Unspecified,
    style: TextStyle = LocalTextStyle.current
) {

    androidx.compose.material3.Text(
        text = text,
        color = color,
        style = style
    )
}