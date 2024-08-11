package org.n27.nutshell.data.topics.model

// Apparently Firebase models require default values ¯\_(ツ)_/¯
data class TopicRaw(
    val key: String = "",
    val title: String = "",
    val imageUrl: String = ""
)