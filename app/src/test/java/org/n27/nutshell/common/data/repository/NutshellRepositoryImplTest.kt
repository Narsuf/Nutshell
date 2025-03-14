package org.n27.nutshell.common.data.repository

import com.google.firebase.database.DataSnapshot
import com.n27.nutshell.data.getDetailRaw
import com.n27.nutshell.data.getTopicsRaw
import com.n27.nutshell.domain.getDetail
import com.n27.nutshell.domain.getTopics
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.n27.nutshell.common.data.api.FirebaseApi
import org.robolectric.RobolectricTestRunner
import kotlin.Result.Companion.success

@RunWith(RobolectricTestRunner::class)
class NutshellRepositoryImplTest {

    private lateinit var repository: NutshellRepositoryImpl
    private lateinit var api: FirebaseApi
    private lateinit var dataSnapshot: DataSnapshot

    @Before
    fun setUp() = runBlocking {
        api = mock(FirebaseApi::class.java)
        dataSnapshot = mock()
        repository = NutshellRepositoryImpl(api)
    }

    @Test
    fun getTopicsSuccess() = runBlocking {
        val expected = getTopics()
        `when`(api.getTopics()).thenReturn(success(getTopicsRaw()))

        assertEquals(expected, repository.getTopics().getOrNull())
    }

    @Test
    fun getDetailSuccess() = runBlocking {
        val expected = getDetail()
        `when`(api.getDetail("")).thenReturn(success(getDetailRaw()))

        assertEquals(expected, repository.getDetail("").getOrNull())
    }
}
