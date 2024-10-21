package org.n27.nutshell.presentation.common.mapping

import com.n27.nutshell.presentation.getError
import org.junit.Assert.assertEquals
import org.junit.Test
import org.n27.nutshell.common.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.R

class ErrorMapperKtTest {

    @Test
    fun `should return expected generic error`() {
        val expected = getError()

        val actual = Throwable().toError()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return expected no internet error`() {
        val expected = getError(
            R.string.no_internet_error_title,
            R.string.no_internet_error_description
        )

        val actual = Throwable(NO_INTERNET_CONNECTION).toError()

        assertEquals(expected, actual)
    }
}
