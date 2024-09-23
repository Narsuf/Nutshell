package org.n27.nutshell.presentation.common.composables.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultBackground
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultRipple

@Composable
fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit
) {

    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            .size(IconButtonTokens.StateLayerSize)
            .background(color = themeDefaultBackground())
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = rememberRipple(
                    bounded = false,
                    radius = IconButtonTokens.StateLayerSize / 2,
                    color = themeDefaultRipple()
                )
            ),
        contentAlignment = Alignment.Center
    ) { content() }
}

internal object IconButtonTokens {
    val StateLayerSize = 40.0.dp
}
