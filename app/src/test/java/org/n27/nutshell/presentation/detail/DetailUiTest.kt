package org.n27.nutshell.presentation.detail

import org.junit.Test
import org.n27.nutshell.presentation.detail.composables.DetailContentScreenPreview
import org.n27.nutshell.presentation.detail.composables.DetailContentScrollableScreenPreview
import org.n27.nutshell.presentation.detail.composables.DetailContentWithoutNavScreenPreview
import org.n27.nutshell.presentation.detail.composables.DetailContentWithoutNavScrollableScreenPreview
import org.n27.nutshell.presentation.detail.composables.DetailErrorScreenPreview
import org.n27.nutshell.presentation.detail.composables.DetailLoadingScreenPreview
import org.n27.nutshell.screenshot.PaparazziScreenTest
import org.n27.nutshell.screenshot.TestConfig

class DetailUiTest(config: TestConfig) : PaparazziScreenTest(config) {

    @Test
    fun detailContentScreenPreviewTest() {
        screenshotTest { DetailContentScreenPreview() }
    }

    @Test
    fun detailContentScrollableScreenPreviewTest() {
        screenshotTest { DetailContentScrollableScreenPreview() }
    }

    @Test
    fun detailContentWithoutNavScreenPreviewTest() {
        screenshotTest { DetailContentWithoutNavScreenPreview() }
    }

    @Test
    fun detailContentWithoutNavScrollableScreenPreviewTest() {
        screenshotTest { DetailContentWithoutNavScrollableScreenPreview() }
    }

    @Test
    fun detailLoadingScreenPreviewTest() {
        screenshotTest { DetailLoadingScreenPreview() }
    }

    @Test
    fun detailErrorScreenPreviewTest() {
        screenshotTest { DetailErrorScreenPreview() }
    }
}
