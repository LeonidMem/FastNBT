package ru.leonidm.fastnbt.impl.v1_19_R2;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTItem;

public abstract class FastNBTItemImpl extends FastNBTCompoundImpl implements FastNBTItem {

    protected ItemStack itemStack;

    protected FastNBTItemImpl() {

    }
    
    protected void validateItemStack() {
        if (itemStack == null || itemStack.getType().isAir()) {
            throw new IllegalArgumentException("Cannot work with NBT of null or air");
        }
    }

    @Override
    @NotNull
    public ItemStack getOrigin() {
        return itemStack;
    }

    @Override
    public String toString() {
        return "FastNBTItemImpl" + nbtTagCompound;
    }
}
