package net.xzos.upgradeall.ui.viewmodels.view

import net.xzos.upgradeall.core.module.app.App

class AppListItemView(val app: App) : ListItemView(app.name) {

    override val name get() = app.name
    val version: String
        get() {
            val latestVersionNumber = app.getLatestVersionNumber()
            val installedVersionNumber = app.installedVersionNumber
            return if (latestVersionNumber == installedVersionNumber)
                installedVersionNumber ?: ""
            else "$installedVersionNumber > $latestVersionNumber"
        }

    override fun equals(other: Any?): Boolean {
        return other is AppListItemView
                && other.app == app
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + app.hashCode()
        return result
    }
}