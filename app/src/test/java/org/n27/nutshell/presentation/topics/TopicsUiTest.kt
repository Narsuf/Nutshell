package org.n27.nutshell.presentation.topics

import org.junit.Test
import org.n27.nutshell.topics.presentation.composables.TopicsContentScreenDarkModePreview
import org.n27.nutshell.topics.presentation.composables.TopicsContentScreenPreview
import org.n27.nutshell.topics.presentation.composables.TopicsContentScrollableScreenDarkModePreview
import org.n27.nutshell.topics.presentation.composables.TopicsContentScrollableScreenPreview
import org.n27.nutshell.topics.presentation.composables.TopicsErrorScreenDarkModePreview
import org.n27.nutshell.topics.presentation.composables.TopicsErrorScreenPreview
import org.n27.nutshell.topics.presentation.composables.TopicsLoadingScreenDarkModePreview
import org.n27.nutshell.topics.presentation.composables.TopicsLoadingScreenPreview
import org.n27.nutshell.screenshot.PaparazziScreenTest
import org.n27.nutshell.screenshot.TestConfig

class TopicsUiTest(config: TestConfig) : PaparazziScreenTest(config) {

    @Test
    fun topicsContentScreenPreviewTest() {
        screenshotTest { TopicsContentScreenPreview() }
    }

    @Test
    fun topicsContentScrollableScreenPreviewTest() {
        screenshotTest { TopicsContentScrollableScreenPreview() }
    }

    @Test
    fun topicsErrorScreenPreviewTest() {
        screenshotTest { TopicsErrorScreenPreview() }
    }

    @Test
    fun topicsLoadingScreenPreviewTest() {
        screenshotTest { TopicsLoadingScreenPreview() }
    }

    @Test
    fun topicsContentScreenDarkModePreviewTest() {
        screenshotTest { TopicsContentScreenDarkModePreview() }
    }

    @Test
    fun topicsContentScrollableScreenDarkModePreviewTest() {
        screenshotTest { TopicsContentScrollableScreenDarkModePreview() }
    }

    @Test
    fun topicsErrorScreenDarkModePreviewTest() {
        screenshotTest { TopicsErrorScreenDarkModePreview() }
    }

    @Test
    fun topicsLoadingScreenDarkModePreviewTest() {
        screenshotTest { TopicsLoadingScreenDarkModePreview() }
    }
}
