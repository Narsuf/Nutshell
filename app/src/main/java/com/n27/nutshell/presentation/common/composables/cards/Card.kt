package com.n27.nutshell.presentation.common.composables.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.n27.nutshell.presentation.common.composables.icons.Icon
import com.n27.nutshell.presentation.common.constants.Spacing
import com.n27.nutshell.presentation.common.constants.Typography

private val CardMinHeight = 72.dp

@Composable
fun Card(
    onClick: () -> Unit,
    text: String,
    iconUrl: String,
    includeDivider: Boolean = false
) {

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.clickable(
            onClick = { onClick() },
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple()
        )
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
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = text,
                        style = Typography.Bold
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = Spacing.default)
                ) { Icon(iconUrl) }
            }
        }
    }

    if (includeDivider) { Divider() }
}
