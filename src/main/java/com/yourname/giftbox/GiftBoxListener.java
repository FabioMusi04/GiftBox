package com.yourname.giftbox;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiftBoxListener implements Listener {

    @EventHandler
    public void onGiftBoxOpen(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null || !item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();
        if (meta == null || !meta.hasDisplayName()) return;

        String displayName = meta.displayName().toString();
        displayName = displayName.replaceAll("§[0-9a-fk-or]", "");

        GiftBox plugin = GiftBox.getPlugin(GiftBox.class);
        String GIFT_BOX_NAME = plugin.getGiftBoxName();
        
        Component nameComponent = item.getItemMeta().displayName();
        String plainName = PlainTextComponentSerializer.plainText().serialize(nameComponent);
        plugin.getLogger().info("GiftBoxListener: Checking item with name: " + plainName);

        if (!plainName.equalsIgnoreCase(GIFT_BOX_NAME)) return;

        event.setCancelled(true);

        ItemStack original = GiftBoxUtils.retrieveItemFromGift(item);

        player.getInventory().remove(item);
        player.getInventory().addItem(original);

        player.getWorld().spawnParticle(Particle.HEART, player.getLocation(), 15, 0.5, 0.5, 0.5, 0.1);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);

        player.sendMessage(Component.text("You opened the gift!").color(NamedTextColor.AQUA));
    }
}
