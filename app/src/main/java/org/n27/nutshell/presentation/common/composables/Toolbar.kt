package org.n27.nutshell.presentation.common.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.composables.buttons.IconButton
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultBackground
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultRipple
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultTypography
import org.n27.nutshell.presentation.common.fundamental.dimens.Spacing
import org.n27.nutshell.presentation.common.fundamental.Typography
import androidx.compose.material3.Icon as MaterialIcon

internal const val TEST_TAG_TOOLBAR_BACK_BUTTON = "toolbar_back.button"

@Composable
fun Toolbar(text: String, onBackClick: (() -> Unit)? = null) {

    Surface {
        Row(
            Modifier
                .background(themeDefaultBackground())
                .fillMaxWidth()
                .padding(
                    vertical = Spacing.tight,
                    horizontal = Spacing.default,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            var topPadding = Spacing.tight

            onBackClick?.let {
                topPadding = 0.dp

                IconButton(
                    onClick = it,
                    modifier = Modifier.testTag(TEST_TAG_TOOLBAR_BACK_BUTTON)
                ) {
                    MaterialIcon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null,
                        tint = themeDefaultTypography()
                    )
                }
            }

            Column(
                Modifier
                    .weight(1f)
                    .padding(
                        start = Spacing.tight,
                        top = topPadding
                    )
            ) {
                AnimatedContent(
                    targetState = text,
                    label = "Toolbar title changed"
                ) { value ->
                    Text(
                        text = value,
                        color = themeDefaultTypography(),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = if (onBackClick != null)
                            Typography.Title
                        else
                            Typography.BoldTitle
                    )
                }
            }
        }
    }
}
