package org.n27.nutshell.topics.robots

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.n27.nutshell.presentation.common.composables.screen.TEST_TAG_ERROR_DESCRIPTION
import org.n27.nutshell.presentation.common.composables.screen.TEST_TAG_ERROR_TITLE
import org.n27.nutshell.presentation.common.composables.screen.TEST_TAG_ERROR_VIEW
import org.n27.nutshell.presentation.topics.composables.TEST_TAG_TOPICS_ITEM
import org.n27.nutshell.presentation.topics.composables.TEST_TAG_TOPICS_LOADING_VIEW

class TopicsRobot(composeTestRule: ComposeTestRule) : ComposeTestRule by composeTestRule {

    fun isTopicsItemDisplayed(index: Int, name: String) {
        onNodeWithTag("${TEST_TAG_TOPICS_ITEM}_$index", useUnmergedTree = true)
            .assertIsDisplayed()
            .assert(hasText(name))
    }

    fun clickTopicsItem(index: Int) {
        onNodeWithTag("${TEST_TAG_TOPICS_ITEM}_$index", useUnmergedTree = true)
            .performClick()
    }

    fun isTopicsLoaderDisplayed() {
        onNodeWithTag(TEST_TAG_TOPICS_LOADING_VIEW)
            .assertIsDisplayed()
    }

    fun isTopicsErrorDisplayed(title: String, description: String) {
        onNodeWithTag(TEST_TAG_ERROR_VIEW)
            .assertIsDisplayed()

        onNodeWithTag(TEST_TAG_ERROR_TITLE)
            .assertIsDisplayed()
            .assert(hasText(title))

        onNodeWithTag(TEST_TAG_ERROR_DESCRIPTION)
            .assertIsDisplayed()
            .assert(hasText(description))
    }

    companion object {
        fun topics(
            composeTestRule: ComposeTestRule,
            builder: TopicsRobot.() -> Unit
        ) = TopicsRobot(composeTestRule).apply(builder)
    }
}