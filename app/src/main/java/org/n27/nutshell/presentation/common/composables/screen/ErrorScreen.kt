package org.n27.nutshell.presentation.common.composables.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.n27.nutshell.R
import org.n27.nutshell.presentation.common.composables.Button
import org.n27.nutshell.presentation.common.composables.Lottie
import org.n27.nutshell.presentation.common.constants.Palette
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.common.constants.Typography
import org.n27.nutshell.presentation.common.model.Error

private val AnimationSize = 80.dp

@Composable
fun ErrorScreen(error: Error, onButtonClick: () -> Unit) {

    Lottie(R.raw.error, Modifier.size(AnimationSize), isError = true)

    Text(
        text = stringResource(error.title),
        modifier = Modifier.padding(bottom = Spacing.default),
        style = Typography.SmallTitle
    )

    Text(
        text = stringResource(error.description),
        modifier = Modifier.padding(bottom = Spacing.tight),
        color = Palette.Gray600
    )

    Button(
        onClick = onButtonClick,
        text = stringResource(R.string.retry),
    )
}