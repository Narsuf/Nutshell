package org.n27.nutshell.data

import org.n27.nutshell.Constants.EMPTY_RESPONSE_FROM_FIREBASE
import org.n27.nutshell.data.topics.mapping.toTopics
import org.n27.nutshell.domain.NutshellRepository
import org.n27.nutshell.domain.topics.model.Topics
import kotlinx.coroutines.flow.first
import org.n27.nutshell.data.detail.mapping.toDetail
import org.n27.nutshell.data.detail.mapping.toDetailNavItems
import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.detail.model.DetailNavItems
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NutshellRepositoryImpl @Inject constructor(
    private val firebaseApi: FirebaseApi
) : NutshellRepository {

    override suspend fun getTopics(): Result<Topics> = firebaseApi.get("topics")
        .first()
        .mapCatching {
            it.toTopics() ?: throw Throwable(EMPTY_RESPONSE_FROM_FIREBASE)
        }

    override suspend fun getDetailNavItems(key: String): Result<DetailNavItems> = firebaseApi
        .get("${key}_nav")
        .first()
        .mapCatching {
            it.toDetailNavItems() ?: throw Throwable(EMPTY_RESPONSE_FROM_FIREBASE)
        }

    override suspend fun getDetail(key: String, id: String): Result<Detail> = firebaseApi
        .get("$key/$id")
        .first()
        .mapCatching {
            it.toDetail() ?: throw Throwable(EMPTY_RESPONSE_FROM_FIREBASE)
        }
}