package com.n27.nutshell.presentation.common.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.n27.nutshell.presentation.common.constants.Palette

private val IconSize = 24.dp

@Composable
fun Icon(
    url: String,
    isSelected: Boolean = false
) {

    val context = LocalContext.current

    SubcomposeAsyncImage(
        model = ImageRequest.Builder(context)
            .data(url)
            .build(),
        contentDescription = null,
        colorFilter = ColorFilter.tint(
            if (isSelected)
                Palette.teal700
            else
                Color.Gray
        ),
        modifier = Modifier
            .size(IconSize)
            .alpha(1f)
    )
}