package com.n27.nutshell.presentation.common.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

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
        label = { Text(label) },
        selectedContentColor = MaterialTheme.colors.primarySurface,
        unselectedContentColor = Color.Gray
    )
}

