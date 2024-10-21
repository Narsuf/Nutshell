package org.n27.nutshell.data

import com.google.firebase.database.FirebaseDatabase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.n27.nutshell.common.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.common.data.DataUtils
import org.n27.nutshell.common.data.api.FirebaseApi

class FirebaseApiTest {

    private lateinit var api: FirebaseApi
    private lateinit var utils: DataUtils
    private lateinit var firebaseDatabase: FirebaseDatabase

    @Before
    fun init() {
        utils = mock(DataUtils::class.java)
        `when`(utils.isConnectedToInternet()).thenReturn(true)

        firebaseDatabase = mock(FirebaseDatabase::class.java)

        api = FirebaseApi(utils, firebaseDatabase)
    }

    @Test
    fun get(): Unit = runBlocking {
        api.get("")
            .catch { assertTrue(it is NullPointerException) }
            .collect { assertFalse(true) }
    }

    @Test
    fun getWithNoInternet(): Unit = runBlocking {
        `when`(utils.isConnectedToInternet()).thenReturn(false)

        api.get("").collect { result ->
            result.onFailure { assertEquals(NO_INTERNET_CONNECTION, it.message) }
            assertNull(result.getOrNull())
        }
    }
}
