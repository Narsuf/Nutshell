package org.n27.nutshell.common.data

import android.content.Context
import android.net.ConnectivityManager
import org.junit.Assert.assertFalse
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class DataUtilsTest {

    @Test
    fun `isConnectedToInternet() should return false if not connected`() {
        val context = mock(Context::class.java)
        val connectivityManager = mock(ConnectivityManager::class.java)
        val utils = DataUtils(context)

        `when`(connectivityManager.getNetworkCapabilities(any())).thenReturn(null)
        `when`(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager)

        assertFalse(utils.isConnectedToInternet())
    }
}
