package com.yourname.giftbox;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.Base64;
import java.util.Map;

public class GiftBoxUtils {

    public static NamespacedKey getNamespacedKey() {
        GiftBox plugin = JavaPlugin.getPlugin(GiftBox.class);
        return plugin.getItemKey();
    }

    /**
     * Stores the original ItemStack inside a gift ItemStack using Base64
     * serialization.
     *
     * @param gift     The gift box ItemStack.
     * @param original The original ItemStack to store.
     * @return The gift ItemStack containing the stored item.
     */
    public static ItemStack storeItemInGift(ItemStack gift, ItemStack original) {
        if (gift == null || original == null)
            return gift;

        try {
            Map<String, Object> serialized = original.serialize();
            String base64 = serializeToBase64(serialized);

            ItemMeta meta = gift.getItemMeta();
            if (meta != null) {
                PersistentDataContainer container = meta.getPersistentDataContainer();
                container.set(getNamespacedKey(), PersistentDataType.STRING, base64);
                gift.setItemMeta(meta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return gift;
    }

    /**
     * Retrieves the stored ItemStack from a gift ItemStack.
     *
     * @param gift The gift box ItemStack.
     * @return The original ItemStack, or AIR if retrieval fails.
     */
    @SuppressWarnings("unchecked")
    public static ItemStack retrieveItemFromGift(ItemStack gift) {
        if (gift == null)
            return new ItemStack(Material.AIR);

        try {
            ItemMeta meta = gift.getItemMeta();
            if (meta == null)
                return new ItemStack(Material.AIR);

            PersistentDataContainer container = meta.getPersistentDataContainer();
            if (!container.has(getNamespacedKey(), PersistentDataType.STRING))
                return new ItemStack(Material.AIR);

            String base64 = container.get(getNamespacedKey(), PersistentDataType.STRING);
            Map<String, Object> serialized = (Map<String, Object>) deserializeFromBase64(base64);
            return ItemStack.deserialize(serialized);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ItemStack(Material.AIR);
    }

    /**
     * Serializes an object to Base64 string.
     */
    private static String serializeToBase64(Object obj) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(byteOut)) {
            out.writeObject(obj);
        }
        return Base64.getEncoder().encodeToString(byteOut.toByteArray());
    }

    /**
     * Deserializes an object from Base64 string.
     */
    private static Object deserializeFromBase64(String base64) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(base64);
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return in.readObject();
        }
    }
}
