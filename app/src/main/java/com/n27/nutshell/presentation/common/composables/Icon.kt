package com.n27.nutshell.presentation.common.composables

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

private val IconSize = 24.dp

@Composable
fun Icon(
    url: String,
    colorFilter: ColorFilter? = null
) {

    val context = LocalContext.current

    SubcomposeAsyncImage(
        model = ImageRequest.Builder(context)
            .data(url)
            .build(),
        contentDescription = null,
        colorFilter = colorFilter,
        modifier = Modifier.size(IconSize)
    )
}