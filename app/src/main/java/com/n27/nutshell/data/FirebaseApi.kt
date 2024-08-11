package com.n27.nutshell.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.n27.nutshell.Constants.NO_INTERNET_CONNECTION
import com.n27.nutshell.Constants.TIMEOUT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

@Singleton
class FirebaseApi @Inject constructor(
    private val utils: DataUtils,
    private val firebaseDatabase: FirebaseDatabase,
) {

    fun get(key: String) = channelFlow<Result<DataSnapshot>> {
        if (!utils.isConnectedToInternet()) {
            send(failure(Throwable(NO_INTERNET_CONNECTION)))
        } else {
            val timeoutJob = launch {
                delay(10000)
                send(failure(Throwable(TIMEOUT)))
            }

            firebaseDatabase.getReference(key).get().await().let {
                timeoutJob.cancel()
                send(success(it))
            }
        }
    }.flowOn(Dispatchers.IO)
}