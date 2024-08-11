package org.n27.nutshell.presentation.common.constants

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Typography {

    val Title: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp
    )

    val Bold: TextStyle = TextStyle(fontWeight = FontWeight.Medium)

    val Small: TextStyle = TextStyle(
        fontSize = 10.sp,
        lineHeight = 12.sp
    )

    val SmallBold: TextStyle = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 12.sp
    )
}