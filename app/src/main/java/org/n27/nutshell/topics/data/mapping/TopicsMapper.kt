package org.n27.nutshell.topics.data.mapping

import org.n27.nutshell.topics.data.model.TopicRaw
import org.n27.nutshell.topics.domain.model.Topic
import org.n27.nutshell.topics.domain.model.Topics

fun List<TopicRaw>.toTopics() = Topics(
    items = map { it.toTopic() }
)

private fun TopicRaw.toTopic() = Topic(
    key = key,
    title = title,
    imageUrl = imageUrl
)
