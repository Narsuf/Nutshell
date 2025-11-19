package org.n27.nutshell.common.data.api

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.TaskCompletionSource
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.n27.nutshell.common.Constants.EMPTY_RESPONSE_FROM_FIREBASE
import org.n27.nutshell.common.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.common.data.DataUtils

class FirebaseApiTest {

    private lateinit var api: FirebaseApi
    private lateinit var utils: DataUtils
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    @Before
    fun init() {
        utils = mock(DataUtils::class.java)
        firebaseDatabase = mock(FirebaseDatabase::class.java)
        databaseReference = mock()

        `when`(utils.isConnectedToInternet()).thenReturn(true)
        `when`(firebaseDatabase.getReference("")).thenReturn(databaseReference)

        api = FirebaseApi(utils, firebaseDatabase)
    }

    @Test
    fun get(): Unit = runBlocking {
        val taskCompletionSource = TaskCompletionSource<DataSnapshot>()
        val dataSnapshot: DataSnapshot = mock()
        `when`(databaseReference.get()).thenReturn(taskCompletionSource.task)

        launch { taskCompletionSource.setResult(dataSnapshot) }

        assertEquals(api.get(""), dataSnapshot)
    }

    @Test
    fun getEmptyResponse(): Unit = runBlocking {
        val taskCompletionSource = TaskCompletionSource<DataSnapshot>()
        val dataSnapshot: DataSnapshot = mock()
        `when`(databaseReference.get()).thenReturn(taskCompletionSource.task)

        launch { taskCompletionSource.setResult(dataSnapshot) }

        try {
            api.getDetail("")
            error("Exception")
        } catch (e: IllegalStateException) {
            assertEquals(EMPTY_RESPONSE_FROM_FIREBASE, e.message)
        }
    }

    @Test
    fun getWithException(): Unit = runBlocking {
        val taskCompletionSource = TaskCompletionSource<DataSnapshot>()
        `when`(databaseReference.get()).thenReturn(taskCompletionSource.task)

        launch { taskCompletionSource.setException(NullPointerException()) }

        try {
            api.get("")
            error("Expected exception")
        } catch (e: Exception) {
            assertTrue(e is NullPointerException)
        }
    }

    @Test
    fun getWithTimeout(): Unit = runBlocking {
        val task: Task<DataSnapshot> = mock()
        `when`(databaseReference.get()).thenReturn(task)

        try {
            api.get("")
            error("Expected exception")
        } catch (e: Exception) {
            assertTrue(e is TimeoutCancellationException)
        }
    }

    @Test
    fun getWithNoInternet(): Unit = runBlocking {
        `when`(utils.isConnectedToInternet()).thenReturn(false)

        try {
            api.get("")
            error("Exception")
        } catch (e: IllegalStateException) {
            assertEquals(NO_INTERNET_CONNECTION, e.message)
        }
    }
}
