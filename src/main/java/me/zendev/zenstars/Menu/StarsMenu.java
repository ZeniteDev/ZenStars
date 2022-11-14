/**
 * Author: ZenDev
 * GitHub: https://github.com/ZeniteDev
 * Discord: ARCTIC#4808
 */
package me.zendev.zenstars.Menu;

import me.zendev.zenstars.ZenStars;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class StarsMenu extends Menu {
    public StarsMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public String getMenuName() {
        return (ZenStars.getPlugin()).variables.getMenuTitle();
    }

    public int getSlots() {
        return 45;
    }

    public boolean cancelAllClicks() {
        return true;
    }


    @Override
    public void handleMenu(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getClick().isLeftClick() || inventoryClickEvent.getClick().isRightClick()) {

            inventoryClickEvent.setCancelled(true);

            ItemStack itemStack = inventoryClickEvent.getCurrentItem();
            Player player = (Player) inventoryClickEvent.getWhoClicked();

            if (itemStack.equals(ZenStars.getPlugin().itemManager.closeButton())) {
                player.closeInventory();
                return;
            }

            for (String key : ZenStars.getPlugin().config.getConfig().getConfigurationSection("MENU.").getKeys(false)) {
                if (itemStack.equals(ZenStars.getPlugin().getUtilities().createItem(
                        ZenStars.getPlugin().variables.getStarItem(key),
                        ZenStars.getPlugin().variables.getStarDisplayname(key),
                        ZenStars.getPlugin().variables.getStarLore(key)))) {

                    if (!player.hasPermission(ZenStars.getPlugin().variables.getStarPermission(key))) {
                        if (inventoryClickEvent.isLeftClick()) {
                            ZenStars.getPlugin().getUtilities().onLeftClick(p, ZenStars.getPlugin().variables.getStarPermission(key));
                        }
                    } else {
                        if (inventoryClickEvent.isRightClick()) {
                            ZenStars.getPlugin().getUtilities().onRightClick(p, ZenStars.getPlugin().variables.getStarPermission(key));
                        }
                    }

                    break;
                }

            }
        }

    }

    public void setMenuItems() {

        for (String key : ZenStars.getPlugin().config.getConfig().getConfigurationSection("MENU.").getKeys(false)) {
            if (ZenStars.getPlugin().data.getConfig().getBoolean(p.getName() + "." + key)) {
                inventory.setItem(ZenStars.getPlugin().variables.getStarSlot(key),
                        ZenStars.getPlugin().getUtilities().createItem(
                                ZenStars.getPlugin().variables.getStarItem(key),
                                ZenStars.getPlugin().variables.getStarDisplayname(key),
                                ZenStars.getPlugin().variables.getStarLore(key)));
            } else {
                inventory.setItem(ZenStars.getPlugin().variables.getStarSlot(key), ZenStars.getPlugin().getItemManager().unknownStarItem());
            }
        }

        inventory.setItem(40, ZenStars.getPlugin().getItemManager().closeButton());

        int i;
        for (i = 0; i < 9; i++) {
            if (inventory.getItem(i) == null)
                inventory.setItem(i, ZenStars.getPlugin().getItemManager().orangeFillerGlass());
        }
        for (i = 9; i < 19; i++) {
            if (inventory.getItem(i) == null)
                inventory.setItem(i, ZenStars.getPlugin().getItemManager().blackFillerGlass());
        }
        for (i = 26; i < 36; i++) {
            if (inventory.getItem(i) == null)
                inventory.setItem(i, ZenStars.getPlugin().getItemManager().blackFillerGlass());
        }
        for (i = 36; i < 45; i++) {
            if (inventory.getItem(i) == null)
                inventory.setItem(i, ZenStars.getPlugin().getItemManager().orangeFillerGlass());
        }
    }
}
