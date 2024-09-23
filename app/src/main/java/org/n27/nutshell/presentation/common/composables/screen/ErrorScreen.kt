package org.n27.nutshell.presentation.common.composables.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.n27.nutshell.R
import org.n27.nutshell.presentation.common.composables.Lottie
import org.n27.nutshell.presentation.common.composables.buttons.Button
import org.n27.nutshell.presentation.common.composables.theme.Theme
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultTypography
import org.n27.nutshell.presentation.common.fundamental.Typography
import org.n27.nutshell.presentation.common.fundamental.dimens.Spacing
import org.n27.nutshell.presentation.common.model.Error

private val AnimationSize = 80.dp

internal const val TEST_TAG_ERROR_VIEW = "error.view"
internal const val TEST_TAG_ERROR_TITLE = "error.title"
internal const val TEST_TAG_ERROR_DESCRIPTION = "error.description"

@Composable
fun ErrorScreen(error: Error, onButtonClick: () -> Unit) {

    Lottie(
        res = R.raw.error,
        modifier = Modifier
            .testTag(TEST_TAG_ERROR_VIEW)
            .size(AnimationSize),
        isError = true
    )

    Text(
        text = stringResource(error.title),
        modifier = Modifier
            .testTag(TEST_TAG_ERROR_TITLE)
            .padding(bottom = Spacing.default),
        color = themeDefaultTypography(),
        style = Typography.SmallTitle
    )

    Text(
        text = stringResource(error.description),
        modifier = Modifier
            .testTag(TEST_TAG_ERROR_DESCRIPTION)
            .padding(bottom = Spacing.tight),
        color = Theme.colors.typography.neutralAlternate
    )

    Button(
        onClick = onButtonClick,
        text = stringResource(R.string.retry),
    )
}
