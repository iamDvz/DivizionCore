package ru.iamdvz.core.utils

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import ru.iamdvz.core.utils.ParserUtil.getFrom
import ru.iamdvz.core.utils.ParserUtil.getParameterFromArr
import ru.iamdvz.core.utils.ParserUtil.getParameters
import java.util.*

object ItemsUtil {
    fun setCMD(item: ItemStack, CMD: Int): ItemStack {
        val itemMeta = item.itemMeta
        itemMeta.setCustomModelData(CMD)
        item.itemMeta = itemMeta
        return item
    }

    fun stringListToItemStack(itemList: List<String>): List<ItemStack> {
        val itemListIS: MutableList<ItemStack> = ArrayList()
        var itemArgs: Array<String>
        var itemTemp = ItemStack(Material.FEATHER)
        val itemTempPM = ItemStack(Material.POTION).itemMeta as PotionMeta
        val itemTempM = itemTemp.itemMeta
        for (item in itemList) { // if it is DELAY{<value>}
            if (item.substring(0, item.indexOf("{")).equals("DELAY", ignoreCase = true)) {
                for (i in 0 until (Objects.requireNonNull(getFrom(item))?.toInt() ?: 1)) {
                    itemListIS.add(ItemStack(Material.AIR))
                }
            } else {2
                itemArgs = getFrom(item)?.let { getParameters(it) }!!
                itemTemp = ItemStack(Material.valueOf(item.substring(0, item.indexOf("{")).uppercase(Locale.getDefault())))
                if (itemTemp.type == Material.POTION) { // if item is potion
                    itemTempPM.color = ColorUtil.hexToRGBColor(getParameterFromArr(itemArgs, "color"))
                    itemTempPM.setCustomModelData(Objects.requireNonNull(getParameterFromArr(itemArgs, "CMD"))?.toInt())
                    itemTemp.setItemMeta(itemTempPM)
                } else { // if item not potion
                    itemTempM.setCustomModelData(Objects.requireNonNull(getParameterFromArr(itemArgs, "CMD"))?.toInt())
                    itemTemp.setItemMeta(itemTempM)
                }
                itemListIS.add(itemTemp)
            }
        }
        return itemListIS
    }
}