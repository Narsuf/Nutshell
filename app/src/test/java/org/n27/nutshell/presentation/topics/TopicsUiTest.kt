package org.n27.nutshell.presentation.topics

import org.junit.Test
import org.n27.nutshell.presentation.topics.composables.TopicsContentScreenDarkModePreview
import org.n27.nutshell.presentation.topics.composables.TopicsContentScreenPreview
import org.n27.nutshell.presentation.topics.composables.TopicsContentScrollableScreenDarkModePreview
import org.n27.nutshell.presentation.topics.composables.TopicsContentScrollableScreenPreview
import org.n27.nutshell.presentation.topics.composables.TopicsErrorScreenDarkModePreview
import org.n27.nutshell.presentation.topics.composables.TopicsErrorScreenPreview
import org.n27.nutshell.presentation.topics.composables.TopicsLoadingScreenDarkModePreview
import org.n27.nutshell.presentation.topics.composables.TopicsLoadingScreenPreview
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
