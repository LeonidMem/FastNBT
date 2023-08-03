package ru.leonidm.fastnbt.impl.v1_20_R1;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;
import ru.leonidm.fastnbt.api.FastNBTType;
import ru.leonidm.fastnbt.utils.FastNBTUtils;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

public class FastNBTItemReadOnlyImpl extends FastNBTItemImpl {

    public FastNBTItemReadOnlyImpl(@NotNull ItemStack itemStack) {
        this.itemStack = itemStack;
        validateItemStack();
        nbtTagCompound = NMSFastNBTUtils.getCompound(itemStack, false);
    }

    @Override
    public void setBoolean(@NotNull String key, boolean value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setByte(@NotNull String key, byte value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setShort(@NotNull String key, short value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setInt(@NotNull String key, int value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setLong(@NotNull String key, long value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setFloat(@NotNull String key, float value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setDouble(@NotNull String key, double value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setString(@NotNull String key, @NotNull String value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setUUID(@NotNull String key, @NotNull UUID value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setByteArray(@NotNull String key, byte @NotNull [] value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setIntArray(@NotNull String key, int @NotNull [] value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setLongArray(@NotNull String key, long @NotNull [] value) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    @NotNull
    public FastNBTCompound getCompound(@NotNull String key) {
        return FastNBTUtils.unmodifiableCompound(super.getCompound(key));
    }

    @Override
    @NotNull
    public FastNBTCompound getLinkedCompound(@NotNull String key) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setCompound(@NotNull String key, @NotNull FastNBTCompound fastNBTCompound) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    @NotNull
    public <T> FastNBTList<T> getList(@NotNull String key, @NotNull FastNBTType<T> fastNBTType) {
        return FastNBTUtils.unmodifiableList(super.getList(key, fastNBTType));
    }

    @Override
    @NotNull
    public <T> FastNBTList<T> getLinkedList(@NotNull String key, @NotNull FastNBTType<T> fastNBTType) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void setList(@NotNull String key, @NotNull FastNBTList<?> fastNBTList) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    @NotNull
    public ItemStack getItemStack(@NotNull String key) {
        return FastNBTUtils.unmodifiableItemStack(super.getItemStack(key));
    }

    @Override
    public void setItemStack(@NotNull String key, @NotNull ItemStack itemStack) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @Override
    public void merge(@NotNull FastNBTCompound fastNBTCompound) {
        throw new UnsupportedOperationException("FastNBTItem is read-only");
    }

    @NotNull
    @UnmodifiableView
    public Set<String> getKeys() {
        return Collections.unmodifiableSet(super.getKeys());
    }
}
