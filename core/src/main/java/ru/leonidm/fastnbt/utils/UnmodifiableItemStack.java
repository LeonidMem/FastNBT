package ru.leonidm.fastnbt.utils;

import io.papermc.paper.inventory.ItemRarity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

final class UnmodifiableItemStack extends ItemStack {

    private final ItemStack origin;

    UnmodifiableItemStack(@NotNull ItemStack origin) {
        this.origin = origin;
    }

    @Override
    @NotNull
    public Material getType() {
        return origin.getType();
    }

    @Override
    public void setType(@NotNull Material type) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public int getAmount() {
        return origin.getAmount();
    }

    @Override
    public void setAmount(int amount) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    @Nullable
    public MaterialData getData() {
        return origin.getData();
    }

    @Override
    public void setData(@Nullable MaterialData data) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public void setDurability(short durability) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public short getDurability() {
        return origin.getDurability();
    }

    @Override
    public int getMaxStackSize() {
        return origin.getMaxStackSize();
    }

    @Override
    public String toString() {
        return origin.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return origin.equals(obj);
    }

    @Override
    public boolean isSimilar(@Nullable ItemStack stack) {
        return origin.isSimilar(stack);
    }

    @Override
    @NotNull
    public ItemStack clone() {
        return origin.clone();
    }

    @Override
    public int hashCode() {
        return origin.hashCode();
    }

    @Override
    public boolean containsEnchantment(@NotNull Enchantment ench) {
        return origin.containsEnchantment(ench);
    }

    @Override
    public int getEnchantmentLevel(@NotNull Enchantment ench) {
        return origin.getEnchantmentLevel(ench);
    }

    @Override
    @NotNull
    public Map<Enchantment, Integer> getEnchantments() {
        return origin.getEnchantments();
    }

    @Override
    public void addEnchantments(@NotNull Map<Enchantment, Integer> enchantments) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public void addEnchantment(@NotNull Enchantment ench, int level) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public void addUnsafeEnchantments(@NotNull Map<Enchantment, Integer> enchantments) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public void addUnsafeEnchantment(@NotNull Enchantment ench, int level) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public int removeEnchantment(@NotNull Enchantment ench) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    @NotNull
    public Map<String, Object> serialize() {
        return origin.serialize();
    }

    @Override
    public boolean editMeta(@NotNull Consumer<? super ItemMeta> consumer) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public <M extends ItemMeta> boolean editMeta(@NotNull Class<M> metaClass, @NotNull Consumer<? super M> consumer) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public ItemMeta getItemMeta() {
        return origin.getItemMeta();
    }

    @Override
    public boolean hasItemMeta() {
        return origin.hasItemMeta();
    }

    @Override
    public boolean setItemMeta(@Nullable ItemMeta itemMeta) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    @NotNull
    public HoverEvent<HoverEvent.ShowItem> asHoverEvent(@NotNull UnaryOperator<HoverEvent.ShowItem> op) {
        return origin.asHoverEvent(op);
    }

    @Override
    @NotNull
    public Component displayName() {
        return origin.displayName();
    }

    @Override
    @NotNull
    public ItemStack ensureServerConversions() {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public byte @NotNull [] serializeAsBytes() {
        return origin.serializeAsBytes();
    }

    @Override
    @Nullable
    public String getI18NDisplayName() {
        return origin.getI18NDisplayName();
    }

    @Override
    public int getMaxItemUseDuration() {
        return origin.getMaxItemUseDuration();
    }

    @Override
    @NotNull
    public ItemStack asOne() {
        return origin.asOne();
    }

    @Override
    @NotNull
    public ItemStack asQuantity(int qty) {
        return origin.asQuantity(qty);
    }

    @Override
    @NotNull
    public ItemStack add() {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    @NotNull
    public ItemStack add(int qty) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    @NotNull
    public ItemStack subtract() {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    @NotNull
    public ItemStack subtract(int qty) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    @Nullable
    public List<String> getLore() {
        return origin.getLore();
    }

    @Override
    @Nullable
    public List<Component> lore() {
        return origin.lore();
    }

    @Override
    public void setLore(@Nullable List<String> lore) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public void lore(@Nullable List<Component> lore) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public void addItemFlags(@NotNull ItemFlag... itemFlags) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    public void removeItemFlags(@NotNull ItemFlag... itemFlags) {
        throw new UnsupportedOperationException("ItemStack is unmodifiable");
    }

    @Override
    @NotNull
    public Set<ItemFlag> getItemFlags() {
        return origin.getItemFlags();
    }

    @Override
    public boolean hasItemFlag(@NotNull ItemFlag flag) {
        return origin.hasItemFlag(flag);
    }

    @Override
    @NotNull
    public String getTranslationKey() {
        return origin.getTranslationKey();
    }

    @Override
    @NotNull
    public String translationKey() {
        return origin.translationKey();
    }

    @Override
    @NotNull
    public ItemRarity getRarity() {
        return origin.getRarity();
    }

    @Override
    public boolean isRepairableBy(@NotNull ItemStack repairMaterial) {
        return origin.isRepairableBy(repairMaterial);
    }

    @Override
    public boolean canRepair(@NotNull ItemStack toBeRepaired) {
        return origin.canRepair(toBeRepaired);
    }

    @Override
    @NotNull
    public HoverEvent<HoverEvent.ShowItem> asHoverEvent() {
        return origin.asHoverEvent();
    }
}
