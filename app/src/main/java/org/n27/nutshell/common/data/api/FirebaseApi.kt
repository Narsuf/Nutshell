package org.n27.nutshell.common.data.api

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.GenericTypeIndicator
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import org.n27.nutshell.common.Constants.EMPTY_RESPONSE_FROM_FIREBASE
import org.n27.nutshell.common.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.common.data.DataUtils
import org.n27.nutshell.detail.data.model.DetailRaw
import org.n27.nutshell.topics.data.model.TopicRaw
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Result.Companion.failure

@Singleton
class FirebaseApi @Inject constructor(
    private val utils: DataUtils,
    private val firebaseDatabase: FirebaseDatabase,
) {

    suspend fun getTopics(): Result<List<TopicRaw>> = get("topics").mapCatching {
        it.getValue(object : GenericTypeIndicator<List<TopicRaw>>() {})
            ?: throw Throwable(EMPTY_RESPONSE_FROM_FIREBASE)
    }

    suspend fun getDetail(key: String): Result<DetailRaw> = get(key).mapCatching {
        it.getValue(object : GenericTypeIndicator<DetailRaw>() {})
            ?: throw Throwable(EMPTY_RESPONSE_FROM_FIREBASE)
    }

    internal suspend fun get(key: String): Result<DataSnapshot> = if (!utils.isConnectedToInternet()) {
        failure(Throwable(NO_INTERNET_CONNECTION))
    } else {
        runCatching {
            withTimeout(10000) {
                firebaseDatabase.getReference(key).get().await()
            }
        }
    }
}
