package com.n27.nutshell.domain

import org.n27.nutshell.topics.domain.model.Topic
import org.n27.nutshell.topics.domain.model.Topics

fun getTopics() = Topics(listOf(getTopic()))

fun getTopic() = Topic(
    key = "taxes",
    title = "Taxes in Europe",
    imageUrl = "http://fake.icon.url.com"
)
