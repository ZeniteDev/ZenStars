package me.zendev.zenstars.Menu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        InventoryHolder holder = e.getInventory().getHolder();

        if (holder instanceof Menu) {
            if (e.getCurrentItem() == null) {
                return;
            }

            Menu menu = (Menu) holder;

            if (menu.cancelAllClicks()) {
                e.setCancelled(true);
            }

            menu.handleMenu(e);
        }

    }

}