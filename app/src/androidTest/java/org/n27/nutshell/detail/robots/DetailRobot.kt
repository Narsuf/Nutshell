package org.n27.nutshell.detail.robots

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import org.n27.nutshell.presentation.common.composables.screen.TEST_TAG_ERROR_VIEW
import org.n27.nutshell.presentation.detail.composables.TEST_TAG_DETAIL_END_CONTENT_ITEM
import org.n27.nutshell.presentation.detail.composables.TEST_TAG_DETAIL_LOADING_VIEW
import org.n27.nutshell.presentation.detail.composables.TEST_TAG_DETAIL_MAIN_CONTENT_ITEM

class DetailRobot(composeTestRule: ComposeTestRule) : ComposeTestRule by composeTestRule {

    fun isDetailItemDisplayed(index: Int, name: String, value: String) {
        onNodeWithTag("${TEST_TAG_DETAIL_MAIN_CONTENT_ITEM}_$index")
            .assertIsDisplayed()
            .assert(hasText(name))

        onNodeWithTag("${TEST_TAG_DETAIL_END_CONTENT_ITEM}_$index")
            .assertIsDisplayed()
            .assert(hasText(value))
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