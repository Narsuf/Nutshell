package org.n27.nutshell.presentation.common.composables.screen

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.n27.nutshell.R
import org.n27.nutshell.presentation.common.composables.Button
import org.n27.nutshell.presentation.common.composables.Lottie
import org.n27.nutshell.presentation.common.model.Error

private val AnimationSize = 80.dp

@Composable
fun ErrorScreen(error: Error) {

    Lottie(R.raw.error, Modifier.size(AnimationSize), isError = true)
    Text(stringResource(error.title))
    Text(stringResource(error.description))
    Button(stringResource(R.string.retry))
}