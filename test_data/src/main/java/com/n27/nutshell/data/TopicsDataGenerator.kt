package com.n27.nutshell.data

import org.n27.nutshell.topics.data.model.TopicRaw

fun getTopicsRaw() = listOf(getTopicRaw())

fun getTopicRaw() = TopicRaw(
    key = "taxes",
    title = "Taxes in Europe",
    imageUrl = "http://fake.icon.url.com"
)
