package ru.iamdvz.core.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.iamdvz.core.DivizionCore;

public class LoreGrabberPlaceholder extends PlaceholderExpansion {
    public LoreGrabberPlaceholder(DivizionCore plugin) {
    }

    @NotNull
    @Override
    public String getAuthor() {
        return "iamDvz";
    }

    @NotNull
    @Override
    public String getIdentifier() {
        return "DivizionLore";
    }

    @NotNull
    @Override
    public String getVersion() {
        return "1.0";
    }


    public String onRequest(OfflinePlayer p, @NotNull String id) {
        if (!((Player) p).hasPermission("DivizionCore.lore"))
            return "NoPerms";
        // DivizionLore_ALL-FULL;int:"LORE"
        if (id.split(";")[0].equalsIgnoreCase("ALL-FULL")) {
            // int
            if (id.substring(id.indexOf(";") + 1, id.indexOf(":")).equalsIgnoreCase("INT")) {
                int sum = 0;
                for (ItemStack item : ((Player) p).getInventory().getStorageContents()) {
                    if (item != null && item.getLore() != null) {
                        for (String loreline : item.getLore()) {
                            if (loreline.contains(id.split(":")[1].replaceAll("\"", ""))) {
                                try {
                                    sum += (Integer.parseInt(loreline.substring(loreline.indexOf(":") + 1).replace(" ", ""))) * item.getAmount();
                                } catch (Exception ignored) {
                                }
                            }
                        }
                    }
                }
                return String.valueOf(sum);
            }

        /* TODO DC-lore:SLOT;1,"LORE"
        if (id.split(";")[0].split(":")[1].equals("SLOT")) {
            String slot = id.split(":")[1];
            try {
                ItemStack item = ((Player) p).getInventory().getItem(EquipmentSlot.valueOf(slot));
                for (String loreline : item.getLore()) {
                    if (loreline.contains(id.split(",")[1])) {
                        return loreline.split(id.split(",")[1])[1];
                    }
                }
            } catch (Exception ignored) {
                System.out.println(id + "NOT HAVE EQUIPMENT SLOT. TRYING NUMBER");
                ItemStack item = ((Player) p).getInventory().getItem(Integer.parseInt(slot));
                for (String loreline : item.getLore()) {
                    if (loreline.contains(id.split(",")[1])) {
                        return loreline.split(id.split(",")[1])[1];
                    }
                }
            }
        }
         */
        }
        return "ERR";
    }
}
