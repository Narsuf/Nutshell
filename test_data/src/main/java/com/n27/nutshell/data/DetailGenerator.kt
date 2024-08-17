package com.n27.nutshell.data

import org.n27.nutshell.data.detail.model.DetailRaw
import org.n27.nutshell.data.detail.model.DetailRaw.NavItemRaw
import org.n27.nutshell.data.detail.model.DetailRaw.TabRaw
import org.n27.nutshell.data.detail.model.DetailRaw.TabRaw.InfoRaw

fun getDetailRaw() = DetailRaw(
    tabs = listOf(getTabRaw()),
    nav = listOf(getNavRaw())
)

fun getTabRaw() = TabRaw(
    infoList = listOf(getInfoRaw()),
    sourceUrl = "http://fake.source.url.com"
)

fun getInfoRaw() = InfoRaw(
    iconUrl = "http://fake.flag.icon.url.com",
    text = "Germany",
    value = "19"
)

fun getNavRaw() = NavItemRaw(
    iconUrl = "http://fake.nav.icon.url.com",
    label = "VAT"
)