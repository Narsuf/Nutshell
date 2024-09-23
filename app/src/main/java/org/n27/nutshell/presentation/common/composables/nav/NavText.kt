package org.n27.nutshell.presentation.common.composables.nav

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.n27.nutshell.presentation.common.composables.theme.Theme
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultTypography
import org.n27.nutshell.presentation.common.fundamental.color.Palette
import org.n27.nutshell.presentation.common.fundamental.Typography

@Composable
fun NavText(text: String, isSelected: Boolean) {

    Text(
        text = text,
        color = if (isSelected)
            Theme.colors.typography.teal
        else
            themeDefaultTypography(),
        style = if (isSelected)
            Typography.SmallBold
        else
            Typography.Small
    )
}
