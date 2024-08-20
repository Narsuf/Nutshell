package org.n27.nutshell.detail.robots

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.n27.nutshell.presentation.common.composables.screen.TEST_TAG_ERROR_VIEW
import org.n27.nutshell.presentation.detail.composables.TEST_TAG_DETAIL_END_CONTENT_ITEM
import org.n27.nutshell.presentation.detail.composables.TEST_TAG_DETAIL_LOADING_VIEW
import org.n27.nutshell.presentation.detail.composables.TEST_TAG_DETAIL_MAIN_CONTENT_ITEM
import org.n27.nutshell.presentation.detail.composables.TEST_TAG_DETAIL_NAV_BAR
import org.n27.nutshell.presentation.detail.composables.TEST_TAG_DETAIL_NAV_ITEM

class DetailRobot(composeTestRule: ComposeTestRule) : ComposeTestRule by composeTestRule {

    fun isDetailItemDisplayed(index: Int, name: String, value: String) {
        onNodeWithTag("${TEST_TAG_DETAIL_MAIN_CONTENT_ITEM}_$index")
            .assertIsDisplayed()
            .assert(hasText(name))

        onNodeWithTag("${TEST_TAG_DETAIL_END_CONTENT_ITEM}_$index")
            .assertIsDisplayed()
            .assert(hasText(value))
    }

    fun isDetailNavBarDisplayed() {
        onNodeWithTag(TEST_TAG_DETAIL_NAV_BAR)
            .assertIsDisplayed()
    }

    fun clickDetailNavBarItem(index: Int) {
        onNodeWithTag("${TEST_TAG_DETAIL_NAV_ITEM}_$index")
            .assertIsDisplayed()
            .performClick()
    }

    fun isDetailNavBarNotDisplayed() {
        onNodeWithTag(TEST_TAG_DETAIL_NAV_BAR)
            .assertIsNotDisplayed()
    }

    fun isDetailLoaderDisplayed() {
        onNodeWithTag(TEST_TAG_DETAIL_LOADING_VIEW)
            .assertIsDisplayed()
    }

    fun isDetailErrorDisplayed() {
        onNodeWithTag(TEST_TAG_ERROR_VIEW)
            .assertIsDisplayed()
    }

    companion object {
        fun detail(
            composeTestRule: ComposeTestRule,
            builder: DetailRobot.() -> Unit
        ) = DetailRobot(composeTestRule).apply(builder)
    }
}
