package org.n27.nutshell.common.data.repository

import org.n27.nutshell.common.Constants.EMPTY_RESPONSE_FROM_FIREBASE
import org.n27.nutshell.common.data.api.FirebaseApi
import org.n27.nutshell.common.domain.NutshellRepository
import org.n27.nutshell.detail.data.mapping.toDetail
import org.n27.nutshell.detail.domain.model.Detail
import org.n27.nutshell.topics.data.mapping.toTopics
import org.n27.nutshell.topics.domain.model.Topics
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Result.Companion.failure

@Singleton
class NutshellRepositoryImpl @Inject constructor(
    private val firebaseApi: FirebaseApi
) : NutshellRepository {

    override suspend fun getTopics(): Result<Topics> = firebaseApi.get("topics")
        .mapCatching {
            it.toTopics() ?: return failure(Throwable(EMPTY_RESPONSE_FROM_FIREBASE))
        }

    override suspend fun getDetail(key: String): Result<Detail> = firebaseApi.get(key)
        .mapCatching {
            it.toDetail() ?: return failure(Throwable(EMPTY_RESPONSE_FROM_FIREBASE))
        }
}
