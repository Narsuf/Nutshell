package org.n27.nutshell.common.presentation.composables.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.n27.nutshell.common.presentation.composables.Icon
import org.n27.nutshell.common.presentation.composables.theme.Theme
import org.n27.nutshell.common.presentation.composables.theme.themeDefaultTypography
import org.n27.nutshell.common.presentation.fundamental.dimens.Spacing

private val NavIconSize = 16.dp

@Composable
fun NavIcon(url: String, isSelected: Boolean) {

    Icon(
        url = url,
        modifier = Modifier.padding(Spacing.tightest),
        size = NavIconSize,
        colorFilter = ColorFilter.tint(
            if (isSelected)
                Theme.colors.typography.teal
            else
                themeDefaultTypography()
        )
    )
}
