package org.n27.nutshell.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultRipple

@Composable
fun Modifier.clickable(
    onClick: () -> Unit
) = this.clickable(
    interactionSource = remember { MutableInteractionSource() },
    indication = rememberRipple(color = themeDefaultRipple()),
    onClick = onClick,
)
