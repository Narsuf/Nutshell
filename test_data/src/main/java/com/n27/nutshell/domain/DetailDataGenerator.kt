package com.n27.nutshell.domain

import org.n27.nutshell.detail.domain.model.Detail
import org.n27.nutshell.detail.domain.model.Detail.NavItem
import org.n27.nutshell.detail.domain.model.Detail.Tab
import org.n27.nutshell.detail.domain.model.Detail.Tab.Info

fun getDetail(tabs: List<Tab> = getTabs()) = Detail(
    tabs = tabs,
    nav = getNavs()
)

fun getTabs() = listOf(
    getTab(),
    getTab(
        info = getInfo(
            iconUrl = "http://fake.spain.flag.icon.url.com",
            text = "Spain",
            value = "54"
        )
    )
)

fun getTab(info: Info = getInfo()) = Tab(
    infoList = listOf(info),
    sourceUrl = "http://fake.source.url.com"
)

fun getInfo(
    iconUrl: String = "http://fake.flag.icon.url.com",
    text: String = "Germany",
    value: String = "19"
) = Info(iconUrl, text, value)

fun getNavs() = listOf(
    getNav(),
    getNav(id = 1, iconUrl = "http://fake.nav.another.icon.url.com", label = "Income")
)

fun getNav(
    id: Int = 0,
    iconUrl: String = "http://fake.nav.icon.url.com",
    label: String = "VAT"
) = NavItem(id, iconUrl, label)
