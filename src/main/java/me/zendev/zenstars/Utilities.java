/**
 * Author: ZenDev
 * GitHub: https://github.com/ZeniteDev
 * Discord: ARCTIC#4808
 */
package me.zendev.zenstars;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.ScopedNode;
import net.luckperms.api.node.types.PermissionNode;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    private final ZenStars plugin;
    LuckPerms luckPerms;

    public Utilities(ZenStars plugin) {
        this.luckPerms = LuckPermsProvider.get();
        this.plugin = plugin;
    }

    public boolean hasPermission(User user, String permission) {
        return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }

    public void setPermission(User user, String permission, Boolean value) {
        ScopedNode scopedNode = Node.builder(permission).value(value).build();

        luckPerms.getUserManager().modifyUser(user.getUniqueId(), u -> {

        });

        user.data().add(scopedNode);
        luckPerms.getUserManager().saveUser(user);
    }

    public void onLeftClick(Player player, String permission) {
        User luckPermsUser = luckPerms.getPlayerAdapter(Player.class).getUser(player);
        if (hasPermission(luckPermsUser, permission)) return;
        setPermission(luckPermsUser, permission, true);
        player.sendMessage(plugin.variables.getSetMessage());
    }

    public void onRightClick(Player player, String permission) {
        User luckPermsUser = luckPerms.getPlayerAdapter(Player.class).getUser(player);
        if (!hasPermission(luckPermsUser, permission)) return;
        setPermission(luckPermsUser, permission, false);
        player.sendMessage(plugin.variables.getRemovedMessage());
    }

    public String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public List<String> colorizeList(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String string : list) {
            newList.add(colorize(string));
        }
        return newList;
    }

    public ItemStack createItem(Material material, String displayName, List<String> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
