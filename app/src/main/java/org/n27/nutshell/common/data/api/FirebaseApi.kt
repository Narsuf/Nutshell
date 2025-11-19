package org.n27.nutshell.common.data.api

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import org.n27.nutshell.common.Constants.EMPTY_RESPONSE_FROM_FIREBASE
import org.n27.nutshell.common.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.common.data.DataUtils
import org.n27.nutshell.detail.data.mapping.toDetailRaw
import org.n27.nutshell.detail.data.model.DetailRaw
import org.n27.nutshell.topics.data.mapping.toTopicRawList
import org.n27.nutshell.topics.data.model.TopicRaw
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseApi @Inject constructor(
    private val utils: DataUtils,
    private val firebaseDatabase: FirebaseDatabase,
) {

    suspend fun getTopics(): List<TopicRaw> = get("topics").toTopicRawList()
        ?: throw IllegalStateException(EMPTY_RESPONSE_FROM_FIREBASE)

    suspend fun getDetail(key: String): DetailRaw = get(key).toDetailRaw()
        ?: throw IllegalStateException(EMPTY_RESPONSE_FROM_FIREBASE)

    internal suspend fun get(key: String): DataSnapshot = if (!utils.isConnectedToInternet())
        throw IllegalStateException(NO_INTERNET_CONNECTION)
    else
        withTimeout(10000) { firebaseDatabase.getReference(key).get().await() }
}

