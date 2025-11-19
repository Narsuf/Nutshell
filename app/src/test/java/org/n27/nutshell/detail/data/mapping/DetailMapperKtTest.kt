package org.n27.nutshell.detail.data.mapping

import com.n27.nutshell.data.getDetailRaw
import com.n27.nutshell.domain.getDetail
import org.junit.Assert.assertEquals
import org.junit.Test

class DetailMapperKtTest {

    @Test
    fun `should return expected detail`() {
        val expected = getDetail()

        val actual = getDetailRaw().toDomainEntity()

        assertEquals(expected, actual)
    }
}
