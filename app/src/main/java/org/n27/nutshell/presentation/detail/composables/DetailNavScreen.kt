package org.n27.nutshell.presentation.detail.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.n27.nutshell.R
import org.n27.nutshell.domain.detail.model.Detail.NavItem
import org.n27.nutshell.presentation.common.composables.Icon
import org.n27.nutshell.presentation.common.composables.Info
import org.n27.nutshell.presentation.common.composables.cards.Card
import org.n27.nutshell.presentation.common.composables.cards.CardContainer
import org.n27.nutshell.presentation.common.composables.nav.NavItem
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.detail.entities.DetailAction
import org.n27.nutshell.presentation.detail.entities.DetailAction.InfoClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.NavItemClicked
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent

internal const val TEST_TAG_DETAIL_MAIN_CONTENT_ITEM = "detail_main_content.item"
internal const val TEST_TAG_DETAIL_END_CONTENT_ITEM = "detail_end_content.item"
internal const val TEST_TAG_DETAIL_NAV_BAR = "detail_nav.bar"
internal const val TEST_TAG_DETAIL_NAV_ITEM = "detail_nav.item"
internal const val TEST_TAG_DETAIL_INFO_ITEM = "detail_info.item"

@Composable
fun ColumnScope.DetailNavScreen(uiState: HasContent, onAction: (action: DetailAction) -> Unit) {

    if (uiState.nav.size > 1)
        NavView(uiState, onAction)
    else
        Container(uiState, onAction)
}

@Composable
private fun ColumnScope.NavView(uiState: HasContent, onAction: (action: DetailAction) -> Unit) {

    val navController = rememberNavController()
    val navItems = uiState.nav

    NavHost(
        navController = navController,
        startDestination = navItems[0].label,
        modifier = Modifier
            .weight(1f)
            .padding(horizontal = Spacing.default)
    ) {
        navItems.forEach { item ->
            composable(item.label) {
                Container(uiState, onAction, item.label)
            }
        }
    }

    BottomNav(navController, navItems, onAction)
}


@Composable
private fun Container(
    uiState: HasContent,
    onAction: (action: DetailAction) -> Unit,
    navLabel: String? = null
) {

    val tab = uiState.tab
    val infoList = tab.infoList

    Column(
        Modifier
            .fillMaxHeight()
            .padding(
                horizontal = if (navLabel == null)
                    Spacing.default
                else
                    0.dp
            )
    ) {
        CardContainer(Modifier.weight(1f, fill = false)) {
            LazyColumn(Modifier.wrapContentHeight()) {
                itemsIndexed(
                    items = infoList,
                    key = { _, item -> item.text }
                ) { index, item ->
                    Card(
                        mainContent = {
                            Text(
                                text = item.text,
                                modifier = Modifier
                                    .testTag("${TEST_TAG_DETAIL_MAIN_CONTENT_ITEM}_$index")
                            )
                        },
                        endContent = {
                            Text(
                                text = item.value,
                                modifier = Modifier
                                    .testTag("${TEST_TAG_DETAIL_END_CONTENT_ITEM}_$index")
                            )
                        },
                        startContent = { Icon(item.iconUrl) },
                        includeDivider = index < infoList.size - 1
                    )
                }
            }
        }

        Info(
            text = stringResource(R.string.source),
            testTag = TEST_TAG_DETAIL_INFO_ITEM,
            onClick = { onAction(InfoClicked(tab.sourceUrl, navLabel)) }
        )

        Spacer(Modifier.height(Spacing.default))
    }
}

@Composable
private fun BottomNav(
    navController: NavController,
    navItems: List<NavItem>,
    onAction: (action: DetailAction) -> Unit
) {

    BottomNavigation(
        modifier = Modifier.testTag(TEST_TAG_DETAIL_NAV_BAR),
        backgroundColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEachIndexed { index, item ->
            val isSelected = currentRoute == item.label

            NavItem(
                isSelected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(item.label) {
                            popUpTo(
                                navController.currentDestination?.id
                                    ?: navController.graph.startDestinationId
                            ) { inclusive = true }

                            launchSingleTop = true
                            restoreState = false
                        }

                        onAction(NavItemClicked(item.id, item.label))
                    }
                },
                imageUrl = item.iconUrl,
                label = item.label,
                modifier = Modifier.testTag("${TEST_TAG_DETAIL_NAV_ITEM}_$index")
            )
        }
    }
}
