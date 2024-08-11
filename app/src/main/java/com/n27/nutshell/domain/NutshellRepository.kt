package com.n27.nutshell.domain

import com.n27.nutshell.domain.topics.model.Topics

interface NutshellRepository {

    suspend fun getTopics() : Result<Topics>
}