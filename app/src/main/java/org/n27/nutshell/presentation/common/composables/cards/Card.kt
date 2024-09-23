package org.n27.nutshell.presentation.common.composables.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.composables.theme.Theme
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultBackground
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultRipple
import org.n27.nutshell.presentation.common.fundamental.dimens.CornerRadius
import org.n27.nutshell.presentation.common.fundamental.dimens.Spacing

private val StartImageSize = 48.dp
private val CardMinHeight = 72.dp

@Composable
fun Card(
    mainContent: @Composable () -> Unit,
    endContent: @Composable () -> Unit,
    startContent: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    includeDivider: Boolean = false
) {

    Surface(
        modifier = onClick?.let {
            Modifier
                .clip(RoundedCornerShape(Theme.cornerRadius.smooth))
                .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = themeDefaultRipple()),
                onClick = it,
            )
        } ?: Modifier
    ) {
        Box(
            modifier = Modifier
                .defaultMinSize(minHeight = CardMinHeight)
                .padding(
                    horizontal = Spacing.default,
                    vertical = Spacing.tight,
                )
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {

                startContent?.let {
                    Box(
                        Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = Spacing.default)
                            .size(StartImageSize),
                        contentAlignment = Alignment.Center
                    ) { it() }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) { mainContent() }

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = Spacing.default)
                ) { endContent() }
            }
        }
    }

    if (includeDivider) { Divider() }
}
