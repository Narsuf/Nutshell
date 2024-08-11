package com.n27.nutshell.presentation.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.NavItem
import com.n27.nutshell.presentation.common.composables.Screen
import com.n27.nutshell.presentation.common.composables.text.Text
import com.n27.nutshell.presentation.detail.entities.DetailUiState.Content
import com.n27.nutshell.presentation.detail.entities.DetailUiState.Content.NavItem

@Composable
fun DetailScreen(content: Content) {

    val navController = rememberNavController()
    val navItems = content.navItems

    Screen(
        title = stringResource(R.string.detail_fragment_label),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NavHost(navController, startDestination = navItems[0].label) {
            navItems.forEach { item ->
                composable(item.label) {
                    Text(item.content)
                }
            }
        }

        BottomNav(navController, navItems)
    }
}

@Composable
private fun BottomNav(navController: NavController, navItems: List<NavItem>) {

    BottomNavigation(backgroundColor = MaterialTheme.colorScheme.background) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach {
            val isSelected = currentRoute == it.label

            NavItem(
                isSelected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(it.label) {
                            popUpTo(
                                navController.currentDestination?.id ?:
                                navController.graph.startDestinationId
                            ) { inclusive = true }

                            launchSingleTop = true
                            restoreState = false
                        }
                    }
                },
                imageUrl = it.iconUrl,
                label = it.label
            )
        }
    }
}
