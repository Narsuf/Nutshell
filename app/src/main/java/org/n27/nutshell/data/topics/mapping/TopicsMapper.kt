package org.n27.nutshell.data.topics.mapping

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.GenericTypeIndicator
import org.n27.nutshell.domain.topics.model.Topic

fun DataSnapshot.toTopics() = getValue(object : GenericTypeIndicator<List<Topic>>() {})