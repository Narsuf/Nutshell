package org.n27.nutshell.data.detail.mapping

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.GenericTypeIndicator
import org.n27.nutshell.data.detail.model.DetailRaw
import org.n27.nutshell.data.detail.model.DetailRaw.InfoRaw
import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.detail.model.Detail.Info

fun DataSnapshot.toDetail() = getValue(
    object : GenericTypeIndicator<DetailRaw>() {}
)?.toDetail()

private fun DetailRaw.toDetail() = Detail(
    info = info.map { it.toInfo() },
    sourceUrl = sourceUrl
)

private fun InfoRaw.toInfo() = Info(
    iconUrl = iconUrl,
    text = text,
    value = value
)