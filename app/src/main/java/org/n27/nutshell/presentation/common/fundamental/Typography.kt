package org.n27.nutshell.presentation.common.fundamental

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Typography {

    val BoldTitle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp
    )

    val Title = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp
    )

    val SmallTitle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp
    )

    val Bold = TextStyle(fontWeight = FontWeight.Medium)

    val Small = TextStyle(
        fontSize = 10.sp,
        lineHeight = 12.sp
    )

    val SmallBold = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 12.sp
    )
}
