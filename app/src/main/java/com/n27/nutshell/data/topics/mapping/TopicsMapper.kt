package com.n27.nutshell.data.topics.mapping

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.GenericTypeIndicator
import com.n27.nutshell.domain.topics.model.Topics

fun DataSnapshot.toTopics() = getValue(object : GenericTypeIndicator<List<Topics>>() {})