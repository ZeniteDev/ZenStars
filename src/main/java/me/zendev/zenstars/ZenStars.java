/**
 * Author: ZenDev
 * GitHub: https://github.com/ZeniteDev
 * Discord: ARCTIC#4808
 */
package me.zendev.zenstars;

import me.zendev.zenstars.Menu.MenuManager;
import me.zendev.zenstars.config.Config;
import me.zendev.zenstars.config.Data;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZenStars extends JavaPlugin {

    private static ZenStars plugin;
    public Config config;
    public Data data;
    public Variables variables;
    public Utilities utilities;
    public ItemManager itemManager;

    @Override
    public void onEnable() {
        plugin = this;
        MenuManager.setup(getServer(), this);
        registerCommands();
        this.utilities = new Utilities(this);
        this.config = new Config(this);
        this.data = new Data(this);
        this.variables = new Variables(this);
        this.itemManager = new ItemManager(this);
        startupMessage();
        saveDefaultConfig();
    }

    public void startupMessage() {
        Bukkit.getServer().getConsoleSender().sendMessage(getUtilities().colorize("&r"));
        Bukkit.getServer().getConsoleSender().sendMessage(getUtilities().colorize("&bZenStars &8| &8&m                               &r"));
        Bukkit.getServer().getConsoleSender().sendMessage(getUtilities().colorize("&bZenStars &8| &8&fPlugin version: &61.1"));
        Bukkit.getServer().getConsoleSender().sendMessage(getUtilities().colorize("&bZenStars &8| &8&fPlugin created by: &6ZenDev"));
        Bukkit.getServer().getConsoleSender().sendMessage(getUtilities().colorize("&bZenStars &8| &6&fhttps://github.com/ZeniteDev"));
        Bukkit.getServer().getConsoleSender().sendMessage(getUtilities().colorize("&bZenStars &8| &8&m                               &r"));
        Bukkit.getServer().getConsoleSender().sendMessage(getUtilities().colorize("&r"));
    }

    public void registerCommands() {
        getCommand("zvaigzde").setExecutor(new StarCommand(this));
    }

    public static ZenStars getPlugin() {
        return plugin;
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void onDisable() {
        saveDefaultConfig();
    }
}
