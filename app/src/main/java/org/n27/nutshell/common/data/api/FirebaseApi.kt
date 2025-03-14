package org.n27.nutshell.common.data.api

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import org.n27.nutshell.common.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.common.data.DataUtils
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Result.Companion.failure

@Singleton
class FirebaseApi @Inject constructor(
    private val utils: DataUtils,
    private val firebaseDatabase: FirebaseDatabase,
) {

    suspend fun get(key: String): Result<DataSnapshot> = if (!utils.isConnectedToInternet()) {
        failure(Throwable(NO_INTERNET_CONNECTION))
    } else {
        runCatching {
            withTimeout(10000) { firebaseDatabase.getReference(key).get().await() }
        }
    }
}
