package org.n27.nutshell.topics.data.mapping

import com.n27.nutshell.data.getTopicsRaw
import com.n27.nutshell.domain.getTopics
import org.junit.Assert.assertEquals
import org.junit.Test

class TopicsMapperKtTest {

    @Test
    fun `should return expected topics`() {
        val expected = getTopics()

        val actual = getTopicsRaw().toTopics()

        assertEquals(expected, actual)
    }
}
