package org.n27.nutshell.data.detail.mapping

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.GenericTypeIndicator
import org.n27.nutshell.data.detail.model.DetailRaw
import org.n27.nutshell.data.detail.model.DetailRaw.DetailNavItemRaw
import org.n27.nutshell.data.detail.model.DetailRaw.TabRaw
import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.detail.model.Detail.DetailNavItem
import org.n27.nutshell.domain.detail.model.Detail.Tab
import org.n27.nutshell.domain.detail.model.Detail.Tab.Info

fun DataSnapshot.toDetail() = getValue(
    object : GenericTypeIndicator<DetailRaw>() {}
)?.toDetail()

private fun DetailRaw.toDetail() = Detail(
    tabs = tabs.map { it.toTab() },
    nav = nav.mapIndexed { index, navRaw ->
        navRaw.toNav(index)
    }
)

private fun TabRaw.toTab() = Tab(
    infoList = infoList.map { it.toInfo() },
    sourceUrl = sourceUrl
)

private fun TabRaw.InfoRaw.toInfo() = Info(
    iconUrl = iconUrl,
    text = text,
    value = value
)

private fun DetailNavItemRaw.toNav(index: Int) = DetailNavItem(
    id = index,
    iconUrl = iconUrl,
    label = label
)