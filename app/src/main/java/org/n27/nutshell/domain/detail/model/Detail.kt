package org.n27.nutshell.domain.detail.model

data class Detail(
    val tabs: List<Tab>,
    val nav: List<DetailNavItem>
) {

    data class Tab(
        val infoList: List<Info>,
        val sourceUrl: String
    ) {

        data class Info(
            val iconUrl: String,
            val text: String,
            val value: String
        )
    }

    data class DetailNavItem(
        val id: Int,
        val iconUrl: String,
        val label: String
    )
}