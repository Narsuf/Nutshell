package org.n27.nutshell.presentation.common.composables.nav

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import org.n27.nutshell.presentation.common.composables.theme.Theme
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultBackground
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultRipple

@Composable
fun RowScope.NavItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    imageUrl: String,
    label: String,
    modifier: Modifier
) {

    BottomNavigationItem(
        selected = isSelected,
        onClick = onClick,
        icon = { NavIcon(imageUrl, isSelected) },
        modifier = modifier,
        label = { NavText(label, isSelected) },
        selectedContentColor = themeDefaultRipple()
    )
}

