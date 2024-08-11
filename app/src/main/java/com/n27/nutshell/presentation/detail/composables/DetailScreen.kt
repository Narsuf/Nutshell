package com.n27.nutshell.presentation.detail.composables

import androidx.compose.material.BottomNavigation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.n27.nutshell.presentation.common.composables.NavItem

@Composable
fun DetailScreen(onClick: () -> Unit) {

    BottomNavigation(backgroundColor = MaterialTheme.colorScheme.background) {
        listOf(
            NavItem(
                isSelected = false,
                onClick = onClick,
                imageUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                label = "Topics"
            ),
            NavItem(
                isSelected = true,
                onClick = {},
                imageUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                label = "Detail"
            )
        )
    }
}