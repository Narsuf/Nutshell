package org.n27.nutshell.common.presentation.composables.nav

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.n27.nutshell.common.presentation.composables.theme.Theme
import org.n27.nutshell.common.presentation.composables.theme.themeDefaultTypography
import org.n27.nutshell.common.presentation.fundamental.Typography

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
