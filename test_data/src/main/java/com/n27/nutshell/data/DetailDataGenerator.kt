package com.n27.nutshell.data

import org.n27.nutshell.detail.data.model.DetailRaw
import org.n27.nutshell.detail.data.model.DetailRaw.NavItemRaw
import org.n27.nutshell.detail.data.model.DetailRaw.TabRaw
import org.n27.nutshell.detail.data.model.DetailRaw.TabRaw.InfoRaw

fun getDetailRaw() = DetailRaw(
    tabs = listOf(
        getTabRaw(),
        getTabRaw(
            info = getInfoRaw(
                iconUrl = "http://fake.spain.flag.icon.url.com",
                text = "Spain",
                value = "54"
            )
        )
    ),
    nav = listOf(
        getNavRaw(),
        getNavRaw(iconUrl = "http://fake.nav.another.icon.url.com", label = "Income")
    )
)

fun getTabRaw(info: InfoRaw = getInfoRaw()) = TabRaw(
    infoList = listOf(info),
    sourceUrl = "http://fake.source.url.com"
)

fun getInfoRaw(
    iconUrl: String = "http://fake.flag.icon.url.com",
    text: String = "Germany",
    value: String = "19"
) = InfoRaw(iconUrl, text, value)

fun getNavRaw(
    iconUrl: String = "http://fake.nav.icon.url.com",
    label: String = "VAT"
) = NavItemRaw(iconUrl, label)
