/**
 * Author: ZenDev
 * GitHub: https://github.com/ZeniteDev
 * Discord: ARCTIC#4808
 */
package me.zendev.zenstars;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private final ZenStars plugin;

    public ItemManager(ZenStars plugin) {
        this.plugin = plugin;
    }

    public ItemStack orangeFillerGlass() {
        ItemStack item = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.variables.getFillerItemName());
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack blackFillerGlass() {
        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.variables.getFillerItemName());
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack closeButton() {
        ItemStack item = new ItemStack(plugin.variables.getCloseButtonItem(), 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.variables.getCloseButtonName());
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack unknownStarItem() {
        ItemStack item = new ItemStack(plugin.variables.getUnknownStarItem(), 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.variables.getUnknownStarName());
        List<String> lore = new ArrayList<>();
        for (String all : plugin.config.getConfig().getStringList("MENU.UnknownColor.Lore"))
            lore.add(plugin.getUtilities().colorize(all));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }
}
