package com.yourname.giftbox;


import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class GiftBox extends JavaPlugin {
    private NamespacedKey itemKey;
    private String giftBoxName;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        giftBoxName = getConfig().getString("gift-box.name", "Gift Box");
        String namespace = getConfig().getString("gift-box.key-namespace", "giftbox");
        String keyValue = getConfig().getString("gift-box.key-value", "stored_item");

        itemKey = new NamespacedKey(namespace, keyValue);

        getCommand("giftbox").setExecutor(new GiftBoxCommand());
        getServer().getPluginManager().registerEvents(new GiftBoxListener(), this);
    }

    public NamespacedKey getItemKey() {
        return itemKey;
    }

    public String getGiftBoxName() {
        return giftBoxName;
    }

    @Override
    public void onDisable() {
    }
}
