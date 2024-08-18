package org.n27.nutshell.data.topics.mapping

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.GenericTypeIndicator
import org.n27.nutshell.data.topics.model.TopicRaw
import org.n27.nutshell.domain.topics.model.Topic
import org.n27.nutshell.domain.topics.model.Topics

fun DataSnapshot.toTopics() = getValue(object : GenericTypeIndicator<List<TopicRaw>>() {})
    ?.toTopics()

internal fun List<TopicRaw>.toTopics() = Topics(
    items = map { it.toTopic() }
)

private fun TopicRaw.toTopic() = Topic(
    key = key,
    title = title,
    imageUrl = imageUrl
)