package org.n27.nutshell.data.detail.mapping

import com.n27.nutshell.data.getDetailRaw
import com.n27.nutshell.domain.getDetail
import org.junit.Assert.assertEquals
import org.junit.Test
import org.n27.nutshell.detail.data.mapping.toDetail

class DetailMapperKtTest {

    @Test
    fun `should return expected detail`() {
        val expected = getDetail()

        val actual = getDetailRaw().toDetail()

        assertEquals(expected, actual)
    }
}
