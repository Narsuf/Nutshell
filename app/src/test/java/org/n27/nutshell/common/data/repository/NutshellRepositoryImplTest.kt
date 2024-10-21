package org.n27.nutshell.common.data.repository

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.n27.nutshell.common.Constants.EMPTY_RESPONSE_FROM_FIREBASE
import org.n27.nutshell.common.data.api.FirebaseApi
import org.n27.nutshell.common.data.repository.NutshellRepositoryImpl
import org.robolectric.RobolectricTestRunner
import kotlin.Result.Companion.success

@RunWith(RobolectricTestRunner::class)
class NutshellRepositoryImplTest {

    private lateinit var repository: NutshellRepositoryImpl
    private lateinit var api: FirebaseApi

    @Before
    fun setUp() = runBlocking {
        api = mock(FirebaseApi::class.java)

        `when`(api.get(anyString())).thenReturn(flowOf(success("")))

        repository = NutshellRepositoryImpl(api)
    }

    // Sadly this is the only case that can be tested since I can't mock DataSnapshot.
    @Test
    fun getTopics() = runBlocking {
        val expected = EMPTY_RESPONSE_FROM_FIREBASE

        assertEquals(expected, repository.getTopics().getOrElse { it.message })
    }

    @Test
    fun getDetail() = runBlocking {
        val expected = EMPTY_RESPONSE_FROM_FIREBASE

        assertEquals(expected, repository.getDetail("").getOrElse { it.message })
    }
}
