package ru.leonidm.fastnbt.utils;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;

public final class FastNBTUnsafe {

    private static final Field ITEM_META_FIELD;

    static {
        try {
            ITEM_META_FIELD = ItemStack.class.getDeclaredField("meta");
            ITEM_META_FIELD.setAccessible(true);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private FastNBTUnsafe() {

    }

    @Nullable
    @SneakyThrows
    public static ItemMeta getOriginalMeta(@NotNull ItemStack itemStack) {
        return (ItemMeta) ITEM_META_FIELD.get(itemStack);
    }

    @NotNull
    @SneakyThrows
    public static ItemMeta initializeMeta(@NotNull ItemStack itemStack) {
        Material material = itemStack.getType();
        ItemMeta itemMeta = Bukkit.getItemFactory().getItemMeta(material);

        ITEM_META_FIELD.set(itemStack, itemMeta);
        return itemMeta;
    }
}
