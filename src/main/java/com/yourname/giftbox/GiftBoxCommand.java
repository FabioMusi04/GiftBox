package com.yourname.giftbox;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class GiftBoxCommand implements org.bukkit.command.CommandExecutor {

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Only players can use this command!").color(NamedTextColor.RED));
            return true;
        }

        ItemStack handItem = player.getInventory().getItemInMainHand();
        if (handItem == null || handItem.getType() == Material.AIR) {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Hold an item to wrap it!"));
            return true;
        }

        String message = args.length > 0 ? String.join(" ", args) : "No message";

        ItemStack giftBox = new ItemStack(Material.CHEST);
        ItemMeta meta = giftBox.getItemMeta();
        if (meta != null) {
            GiftBox plugin = JavaPlugin.getPlugin(GiftBox.class);
            meta.displayName(MiniMessage.miniMessage().deserialize("<light_purple>" + plugin.getGiftBoxName()));

            List<Component> lore = new ArrayList<>();
            lore.add(MiniMessage.miniMessage().deserialize("<gold>Message: <white>" + message));
            lore.add(MiniMessage.miniMessage().deserialize("<gray>From: <white>" + player.getName()));
            meta.lore(lore);

            giftBox.setItemMeta(meta);
        }

        giftBox = GiftBoxUtils.storeItemInGift(giftBox, handItem);

        player.getInventory().setItemInMainHand(giftBox);

        player.sendMessage(MiniMessage.miniMessage().deserialize("<green>You wrapped your item into a gift box!"));
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1f, 1f);

        return true;
    }
}
