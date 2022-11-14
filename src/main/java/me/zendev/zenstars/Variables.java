/**
 * Author: ZenDev
 * GitHub: https://github.com/ZeniteDev
 * Discord: ARCTIC#4808
 */
package me.zendev.zenstars;

import org.bukkit.Material;

import java.util.List;

public class Variables {
    private final ZenStars plugin;

    public Variables(ZenStars plugin) {
        this.plugin = plugin;
    }

    public String getStarPermission(String starType) {
        return plugin.config.getConfig().getString("MENU." + starType + ".Permission");
    }

    public String getStarDisplayname(String starType) {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU." + starType + ".Name"));
    }

    public List<String> getStarLore(String starType) {
        return plugin.getUtilities().colorizeList(plugin.config.getConfig().getStringList("MENU." + starType + ".Lore"));
    }

    public Material getStarItem(String starType) {
        return Material.valueOf(plugin.config.getConfig().getString("MENU." + starType + ".Item"));
    }

    public int getStarSlot(String starType) {
        return plugin.config.getConfig().getInt("MENU." + starType + ".Slot");
    }

    public String getConsoleError() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MESSAGES.ConsoleError"));
    }

    public String getSetMessage() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MESSAGES.StarSet"));
    }

    public String getRemovedMessage() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MESSAGES.StarRemoved"));
    }

    public String getFillerItemName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("BUTTONS.FillerName"));
    }

    public String getCloseButtonName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("BUTTONS.ClosePageName"));
    }

    public Material getCloseButtonItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("BUTTONS.ClosePageItem"));
    }

    public String getMenuTitle() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MenuTitle"));
    }

    public Material getUnknownStarItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("UnknownStar.Item"));
    }

    public String getUnknownStarName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("UnknownStar.Name"));
    }

    public Material getGoldenStarItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("GOLDEN_STAR.Item"));
    }

    public String getGoldenStarName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.GOLDEN_STAR.Name"));
    }

    public String getGoldenStarPermission() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.GOLDEN_STAR.Permission"));
    }

    public Material getGreenStarItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("MENU.GREEN_STAR.Item"));
    }

    public String getGreenStarName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.GREEN_STAR.Name"));
    }

    public String getGreenStarPermission() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.GREEN_STAR.Permission"));
    }

    public Material getRedStarItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("MENU.RED_STAR.Item"));
    }

    public String getRedStarName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.RED_STAR.Name"));
    }

    public String getRedStarPermission() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.RED_STAR.Permission"));
    }

    public Material getCyanStarItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("MENU.CYAN_STAR.Item"));
    }

    public String getCyanStarName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.CYAN_STAR.Name"));
    }

    public String getCyanStarPermission() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.CYAN_STAR.Permission"));
    }

    public Material getPurpleStarItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("MENU.PURPLE_STAR.Item"));
    }

    public String getPurpleStarName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.PURPLE_STAR.Name"));
    }

    public String getPurpleStarPermission() {
        return plugin.config.getConfig().getString("MENU.PURPLE_STAR.Permission");
    }

    public Material getWhiteStarItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("MENU.WHITE_STAR.Item"));
    }

    public String getWhiteStarName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.WHITE_STAR.Name"));
    }

    public String getWhiteStarPermission() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.WHITE_STAR.Permission"));
    }

    public Material getBlackStarItem() {
        return Material.getMaterial(plugin.config.getConfig().getString("MENU.BLACK_STAR.Item"));
    }

    public String getBlackStarName() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.BLACK_STAR.Name"));
    }

    public String getBlackStarPermission() {
        return plugin.getUtilities().colorize(plugin.config.getConfig().getString("MENU.BLACK_STAR.Permission"));
    }
}