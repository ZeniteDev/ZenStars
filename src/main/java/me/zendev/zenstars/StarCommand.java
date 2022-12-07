/**
 * Author: ZenDev
 * GitHub: https://github.com/ZeniteDev
 * Discord: ARCTIC#4808
 */
package me.zendev.zenstars;

import me.zendev.zenstars.Menu.MenuManager;
import me.zendev.zenstars.Menu.StarsMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StarCommand implements CommandExecutor {

    private final ZenStars plugin;

    public StarCommand(ZenStars plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            for (String key : plugin.config.getConfig().getConfigurationSection("MENU.").getKeys(false)) {
                if (!plugin.data.getConfig().contains(player.getName())) {
                    if (player.hasPermission(plugin.variables.getStarPermission(key))) {
                        plugin.data.getConfig().set(player.getName() + "." + key, true);
                    } else {
                        plugin.data.getConfig().set(player.getName() + "." + key, false);
                    }
                }
                
                if (!plugin.data.getConfig().contains(player.getName() + "." + key)) {
                    plugin.data.getConfig().set(player.getName() + "." + key, false);
                }
            }

            plugin.data.saveConfig();
            MenuManager.openMenu(StarsMenu.class, player);
        } else {
            plugin.variables.getConsoleError();
        }

        return true;
    }
}