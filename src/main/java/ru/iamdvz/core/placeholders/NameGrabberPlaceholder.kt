package ru.iamdvz.core.placeholders

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import ru.iamdvz.core.DivizionCore

class NameGrabberPlaceholder(plugin: DivizionCore?) : PlaceholderExpansion() {
    override fun getAuthor(): String {
        return "iamDvz"
    }

    override fun getIdentifier(): String {
        return "DivizionName"
    }

    override fun getVersion(): String {
        return "1.0"
    }

    override fun onRequest(p: OfflinePlayer, id: String): String? {
        if (!(p as Player).hasPermission("DivizionCore.name")) return "NoPerms"
        var name = id.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].replace("\"".toRegex(), "")

        // DivizionName_ALL-FULL-COUNT:"NAME"
        if (id.split(":")[0] == "ALL-FULL-COUNT") {
            var sum = 0
            for (item in p.inventory.contents) {
                if ((item != null) && (item.itemMeta.hasDisplayName()) && (item.itemMeta.displayName.replace("§.".toRegex(), "") == name)) {
                    try {
                        sum += item.amount
                    } catch (ignored: Exception) {
                    }
                }
            }
            return sum.toString()
        }

        // DivizionName_ALL-FULL-COUNT-COMPONENT:"NAME"
        if (id.split(":")[0] == "ALL-FULL-COUNT-COMPONENT") {
            var sum = 0
            name = name.replace("([(<|<\\/)\\w>])".toRegex(), "").replace("§.".toRegex(), "")
            for (item in p.inventory.contents) {
                if ((item != null) && (item.itemMeta.hasDisplayName()) && (item.itemMeta.displayName.replace("§.".toRegex(), "") == name)) {
                    sum += item.amount
                }
            }
            return "$sum<bold><white>"
        }
        return "ERR"
    }
}