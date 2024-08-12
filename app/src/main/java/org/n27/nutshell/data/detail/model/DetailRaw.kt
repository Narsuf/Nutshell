package org.n27.nutshell.data.detail.model

data class DetailRaw(
    val title: String = "",
    val info: List<InfoRaw> = listOf(),
    val sourceUrl: String = ""
) {

    data class InfoRaw(
        val iconUrl: String = "",
        val text: String = "",
        val value: String = ""
    )
}