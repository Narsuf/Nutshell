package com.n27.nutshell.presentation.common.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import com.n27.nutshell.presentation.common.composables.icons.NavIcon

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

