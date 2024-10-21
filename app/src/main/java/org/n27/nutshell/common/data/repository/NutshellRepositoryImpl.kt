package org.n27.nutshell.common.data.repository

import com.google.firebase.database.DataSnapshot
import kotlinx.coroutines.flow.first
import org.n27.nutshell.common.Constants.EMPTY_RESPONSE_FROM_FIREBASE
import org.n27.nutshell.common.data.api.FirebaseApi
import org.n27.nutshell.common.domain.NutshellRepository
import org.n27.nutshell.detail.data.mapping.toDetail
import org.n27.nutshell.detail.domain.model.Detail
import org.n27.nutshell.topics.data.mapping.toTopics
import org.n27.nutshell.topics.domain.model.Topics
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NutshellRepositoryImpl @Inject constructor(
    private val firebaseApi: FirebaseApi
) : NutshellRepository {

    override suspend fun getTopics(): Result<Topics> = firebaseApi.get("topics")
        .first()
        .mapCatching {
            (it as? DataSnapshot)?.toTopics() ?: throw Throwable(EMPTY_RESPONSE_FROM_FIREBASE)
        }

    override suspend fun getDetail(key: String): Result<Detail> = firebaseApi.get(key)
        .first()
        .mapCatching {
            (it as? DataSnapshot)?.toDetail() ?: throw Throwable(EMPTY_RESPONSE_FROM_FIREBASE)
        }
}
