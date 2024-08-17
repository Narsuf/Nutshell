package com.n27.nutshell.domain

import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.detail.model.Detail.NavItem
import org.n27.nutshell.domain.detail.model.Detail.Tab
import org.n27.nutshell.domain.detail.model.Detail.Tab.Info

fun getDetail() = Detail(
    tabs = listOf(getTab()),
    nav = listOf(getNav())
)

fun getTab() = Tab(
    infoList = listOf(getInfo()),
    sourceUrl = "http://fake.source.url.com"
)

fun getInfo() = Info(
    iconUrl = "http://fake.flag.icon.url.com",
    text = "Germany",
    value = "19"
)

fun getNav() = NavItem(
    id = 0,
    iconUrl = "http://fake.nav.icon.url.com",
    label = "VAT"
)