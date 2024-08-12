package org.n27.nutshell.domain

import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.detail.model.DetailNavItems
import org.n27.nutshell.domain.topics.model.Topics

interface NutshellRepository {

    suspend fun getTopics() : Result<Topics>
    suspend fun getDetailNavItems(key: String) : Result<DetailNavItems>
    suspend fun getDetail(key: String, id: String) : Result<Detail>
}