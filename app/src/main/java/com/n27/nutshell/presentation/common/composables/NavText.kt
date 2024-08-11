package com.n27.nutshell.presentation.common.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.n27.nutshell.presentation.common.constants.Palette
import com.n27.nutshell.presentation.common.constants.Typography

@Composable
fun NavText(text: String, isSelected: Boolean) {

    Text(
        text = text,
        color = if (isSelected)
            Palette.Teal500
        else
            Color.Black,
        style = if (isSelected)
            Typography.SmallBold
        else
            Typography.Small
    )
}