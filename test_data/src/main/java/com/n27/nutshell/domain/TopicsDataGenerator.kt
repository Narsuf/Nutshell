package com.n27.nutshell.domain

import org.n27.nutshell.domain.topics.model.Topic

fun getTopic() = Topic(
    key = "taxes",
    title = "Taxes in Europe",
    imageUrl = "http://fake.icon.url.com"
)