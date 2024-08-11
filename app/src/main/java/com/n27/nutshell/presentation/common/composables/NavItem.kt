package com.n27.nutshell.presentation.common.composables

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
        icon = { Icon(imageUrl, isSelected) },
        label = { Text(label, isSelected) }
    )
}

