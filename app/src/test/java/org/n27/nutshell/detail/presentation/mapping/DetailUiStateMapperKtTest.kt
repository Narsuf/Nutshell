package org.n27.nutshell.detail.presentation.mapping

import com.n27.nutshell.domain.getTab
import com.n27.nutshell.presentation.getHasContent
import com.n27.nutshell.presentation.getNavContent
import com.n27.nutshell.presentation.getNoContent
import org.junit.Assert.assertEquals
import org.junit.Test
import org.n27.nutshell.detail.presentation.entities.DetailViewModelState
import org.n27.nutshell.detail.presentation.mapping.toUiState

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
