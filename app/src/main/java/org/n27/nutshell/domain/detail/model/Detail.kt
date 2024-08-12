package org.n27.nutshell.domain.detail.model

data class Detail(
    val info: List<Info>,
    val sourceUrl: String
) {

    data class Info(
        val iconUrl: String,
        val text: String,
        val value: String
    )
}