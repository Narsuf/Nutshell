package org.n27.nutshell.common.presentation.composables.buttons

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
import org.n27.nutshell.common.presentation.composables.theme.themeDefaultBackground
import org.n27.nutshell.common.presentation.composables.theme.themeDefaultRipple

private val StateLayerSize = 40.0.dp

@Composable
fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            .size(StateLayerSize)
            .background(color = themeDefaultBackground())
            .clickable(
                onClick = onClick,
                role = Role.Button,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = false,
                    radius = StateLayerSize / 2,
                    color = themeDefaultRipple()
                )
            ),
        contentAlignment = Alignment.Center
    ) { content() }
}
