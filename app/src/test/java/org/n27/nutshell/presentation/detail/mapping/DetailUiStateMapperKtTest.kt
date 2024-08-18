package org.n27.nutshell.presentation.detail.mapping

import com.n27.nutshell.domain.getTab
import com.n27.nutshell.presentation.getHasContent
import com.n27.nutshell.presentation.getNavContent
import com.n27.nutshell.presentation.getNoContent
import org.junit.Assert.assertEquals
import org.junit.Test
import org.n27.nutshell.presentation.detail.entities.DetailViewModelState

class DetailUiStateMapperKtTest {

    @Test
    fun `should return expected no content`() {
        val expected = getNoContent()

        val actual = DetailViewModelState().toUiState()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return expected has content`() {
        val expected = getHasContent()

        val actual = DetailViewModelState(
            tab = getTab(),
            nav = getNavContent()
        ).toUiState()

        assertEquals(expected, actual)
    }
}