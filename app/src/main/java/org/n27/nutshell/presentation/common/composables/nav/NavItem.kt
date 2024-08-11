package org.n27.nutshell.presentation.common.composables.nav

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable

@Composable
fun RowScope.NavItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    imageUrl: String,
    label: String
) {

    BottomNavigationItem(
        selected = isSelected,
        onClick = onClick,
        icon = { NavIcon(imageUrl, isSelected) },
        label = { NavText(label, isSelected) }
    )
}

