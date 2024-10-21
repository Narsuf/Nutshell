package org.n27.nutshell.common.domain

import org.n27.nutshell.detail.domain.model.Detail
import org.n27.nutshell.topics.domain.model.Topics

interface NutshellRepository {

    suspend fun getTopics() : Result<Topics>
    suspend fun getDetail(key: String) : Result<Detail>
}
