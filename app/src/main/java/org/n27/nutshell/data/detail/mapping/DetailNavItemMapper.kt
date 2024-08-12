package org.n27.nutshell.data.detail.mapping

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.GenericTypeIndicator
import org.n27.nutshell.data.detail.model.DetailNavItemRaw
import org.n27.nutshell.domain.detail.model.DetailNavItem
import org.n27.nutshell.domain.detail.model.DetailNavItems

fun DataSnapshot.toDetailNavItems() = getValue(
    object : GenericTypeIndicator<List<DetailNavItemRaw>>() {}
)?.toNavItems()

private fun List<DetailNavItemRaw>.toNavItems() = DetailNavItems(
    items = map { it.toNavItem() }
)

private fun DetailNavItemRaw.toNavItem() = DetailNavItem(
    id = id,
    iconUrl = iconUrl,
    label = label
)