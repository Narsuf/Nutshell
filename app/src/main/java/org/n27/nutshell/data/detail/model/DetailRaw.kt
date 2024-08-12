package org.n27.nutshell.data.detail.model

data class DetailRaw(
    val tabs: List<TabRaw> = listOf(),
    val nav: List<DetailNavItemRaw> = listOf()
) {

    data class TabRaw(
        val infoList: List<InfoRaw> = listOf(),
        val sourceUrl: String = ""
    ) {

        data class InfoRaw(
            val iconUrl: String = "",
            val text: String = "",
            val value: String = ""
        )
    }

    data class DetailNavItemRaw(
        val iconUrl: String = "",
        val label: String = ""
    )
}