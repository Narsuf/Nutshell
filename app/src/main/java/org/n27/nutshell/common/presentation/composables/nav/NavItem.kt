package org.n27.nutshell.common.presentation.composables.nav

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.n27.nutshell.common.presentation.composables.theme.themeDefaultRipple

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

