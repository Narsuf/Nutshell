package org.n27.nutshell.common.data.repository

import org.n27.nutshell.common.data.api.FirebaseApi
import org.n27.nutshell.common.domain.NutshellRepository
import org.n27.nutshell.detail.data.mapping.toDomainEntity
import org.n27.nutshell.detail.domain.model.Detail
import org.n27.nutshell.topics.data.mapping.toDomainEntity
import org.n27.nutshell.topics.domain.model.Topics
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NutshellRepositoryImpl @Inject constructor(
    private val firebaseApi: FirebaseApi
) : NutshellRepository {

    override suspend fun getTopics(): Result<Topics> = runCatching {
        firebaseApi.getTopics().toDomainEntity()
    }

    override suspend fun getDetail(key: String): Result<Detail> = runCatching {
        firebaseApi.getDetail(key).toDomainEntity()
    }
}
