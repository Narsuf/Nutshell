package org.n27.nutshell.detail.tests

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.n27.nutshell.presentation.getError
import com.n27.nutshell.presentation.getHasContent
import com.n27.nutshell.presentation.getNoContent
import kotlinx.collections.immutable.persistentListOf
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import org.n27.nutshell.common.presentation.composables.theme.Theme
import org.n27.nutshell.detail.robots.DetailRobot.Companion.detail
import org.n27.nutshell.detail.presentation.composables.DetailScreen
import org.n27.nutshell.detail.presentation.entities.DetailAction
import org.n27.nutshell.detail.presentation.entities.DetailAction.BackClicked
import org.n27.nutshell.detail.presentation.entities.DetailAction.InfoClicked
import org.n27.nutshell.detail.presentation.entities.DetailAction.NavItemClicked

@RunWith(AndroidJUnit4::class)
class DetailFragmentUiTest {

    private val composeTestRule = createComposeRule()

    @get:Rule
    val baseRuleChain: RuleChain by lazy {
        RuleChain
            .emptyRuleChain()
            .around(composeTestRule)
    }

    @Test
    fun checkDetailContentScreenWithNavBarElements() {
        var expected: DetailAction = NavItemClicked(1, "Income")
        var actual: DetailAction? = null

        composeTestRule.setContent {
            Theme {
                DetailScreen(
                    title = "taxes",
                    uiState = getHasContent(),
                    onAction = { actual = it }
                )
            }
        }

        detail(composeTestRule) {
            isDetailItemDisplayed(0, "Germany", "19")
            isDetailNavBarDisplayed()

            clickDetailNavBarItem(1)
            assertEquals(expected, actual)

            expected = InfoClicked("http://fake.source.url.com", "Income")
            clickSource()
            assertEquals(expected, actual)
        }
    }

    @Test
    fun checkDetailContentScreenElements() {
        var expected: DetailAction = InfoClicked("http://fake.source.url.com", null)
        var actual: DetailAction? = null

        composeTestRule.setContent {
            Theme {
                DetailScreen(
                    title = "taxes",
                    uiState = getHasContent(nav = persistentListOf()),
                    onAction = { actual = it }
                )
            }
        }

        detail(composeTestRule) {
            isDetailItemDisplayed(0, "Germany", "19")
            isDetailNavBarNotDisplayed()

            clickSource()
            assertEquals(expected, actual)

            clickBack()
            expected = BackClicked
            assertEquals(expected, actual)
        }
    }

    @Test
    fun checkDetailLoadingScreenElements() {
        composeTestRule.setContent {
            Theme {
                DetailScreen(title = "taxes", uiState = getNoContent(), onAction = { })
            }
        }

        detail(composeTestRule) {
            isDetailLoaderDisplayed()
        }
    }

    @Test
    fun checkDetailErrorScreenElements() {
        composeTestRule.setContent {
            Theme {
                DetailScreen(
                    title = "taxes",
                    uiState = getNoContent(
                        isLoading = false,
                        error = getError()
                    ),
                    onAction = { }
                )
            }
        }

        detail(composeTestRule) {
            isDetailErrorDisplayed()
        }
    }
}
