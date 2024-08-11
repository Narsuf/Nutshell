package com.n27.nutshell.presentation.common.constants

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Typography {

    val title: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp
    )

    val bold: TextStyle = TextStyle(fontWeight = FontWeight.Medium)
}