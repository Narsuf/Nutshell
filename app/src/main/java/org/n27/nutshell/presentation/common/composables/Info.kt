package org.n27.nutshell.presentation.common.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.composables.theme.Theme
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultRipple
import org.n27.nutshell.presentation.common.fundamental.color.Palette
import org.n27.nutshell.presentation.common.fundamental.dimens.Spacing

private val IconSize = 16.dp

@Composable
fun Info(text: String, testTag: String, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .testTag(testTag)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = themeDefaultRipple()),
                onClick = onClick,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.padding(vertical = Spacing.default))
        Spacer(Modifier.padding(horizontal = Spacing.tightest))

        Icon(
            painter = painterResource(android.R.drawable.ic_dialog_info),
            contentDescription = null,
            modifier = Modifier.size(IconSize),
            tint = Theme.colors.typography.teal
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = Spacing.tighter),
            color = Theme.colors.typography.teal
        )

        Spacer(Modifier.padding(horizontal = Spacing.tightest))
    }
}
