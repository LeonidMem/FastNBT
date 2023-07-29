package ru.leonidm.fastnbt.utils;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;
import ru.leonidm.fastnbt.api.FastNBTType;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

final class UnmodifiableFastNBTCompound implements FastNBTCompound {

    private final FastNBTCompound origin;

    UnmodifiableFastNBTCompound(@NotNull FastNBTCompound origin) {
        this.origin = origin;
    }

    @Override
    public boolean getBoolean(@NotNull String key) {
        return origin.getBoolean(key);
    }

    @Override
    public void setBoolean(@NotNull String key, boolean value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public byte getByte(@NotNull String key) {
        return origin.getByte(key);
    }

    @Override
    public void setByte(@NotNull String key, byte value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public short getShort(@NotNull String key) {
        return origin.getShort(key);
    }

    @Override
    public void setShort(@NotNull String key, short value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public int getInt(@NotNull String key) {
        return origin.getInt(key);
    }

    @Override
    public void setInt(@NotNull String key, int value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public long getLong(@NotNull String key) {
        return origin.getLong(key);
    }

    @Override
    public void setLong(@NotNull String key, long value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public float getFloat(@NotNull String key) {
        return origin.getFloat(key);
    }

    @Override
    public void setFloat(@NotNull String key, float value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public double getDouble(@NotNull String key) {
        return origin.getDouble(key);
    }

    @Override
    public void setDouble(@NotNull String key, double value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    @NotNull
    public String getString(@NotNull String key) {
        return origin.getString(key);
    }

    @Override
    public void setString(@NotNull String key, @NotNull String value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    @NotNull
    public UUID getUUID(@NotNull String key) {
        return origin.getUUID(key);
    }

    @Override
    public void setUUID(@NotNull String key, @NotNull UUID value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public byte @NotNull [] getByteArray(@NotNull String key) {
        return origin.getByteArray(key);
    }

    @Override
    public void setByteArray(@NotNull String key, byte @NotNull [] value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public int @NotNull [] getIntArray(@NotNull String key) {
        return origin.getIntArray(key);
    }

    @Override
    public void setIntArray(@NotNull String key, int @NotNull [] value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public long @NotNull [] getLongArray(@NotNull String key) {
        return origin.getLongArray(key);
    }

    @Override
    public void setLongArray(@NotNull String key, long @NotNull [] value) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    @NotNull
    public FastNBTCompound getCompound(@NotNull String key) {
        return FastNBTUtils.unmodifiableCompound(origin.getCompound(key));
    }

    @Override
    @NotNull
    public FastNBTCompound getLinkedCompound(@NotNull String key) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public void setCompound(@NotNull String key, @NotNull FastNBTCompound fastNBTCompound) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    @NotNull
    public <T> FastNBTList<T> getList(@NotNull String key, @NotNull FastNBTType<T> fastNBTType) {
        return FastNBTUtils.unmodifiableList(origin.getList(key, fastNBTType));
    }

    @Override
    @NotNull
    public <T> FastNBTList<T> getLinkedList(@NotNull String key, @NotNull FastNBTType<T> fastNBTType) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public void setList(@NotNull String key, @NotNull FastNBTList<?> fastNBTList) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    @NotNull
    public ItemStack getItemStack(@NotNull String key) {
        return origin.getItemStack(key);
    }

    @Override
    public void setItemStack(@NotNull String key, @NotNull ItemStack itemStack) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public void merge(@NotNull FastNBTCompound fastNBTCompound) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public boolean contains(@NotNull String key) {
        return origin.contains(key);
    }

    @Override
    public boolean contains(@NotNull String key, @NotNull FastNBTType<?> fastNBTType) {
        return origin.contains(key, fastNBTType);
    }

    @Override
    @NotNull
    @UnmodifiableView
    public Set<String> getKeys() {
        return Collections.unmodifiableSet(origin.getKeys());
    }

    @Override
    public void remove(@NotNull String key) {
        throw new UnsupportedOperationException("FastNBTCompound is unmodifiable");
    }

    @Override
    public int size() {
        return origin.size();
    }

    @Override
    public boolean isEmpty() {
        return origin.isEmpty();
    }

    @Override
    @NotNull
    @Contract("-> new")
    public FastNBTCompound copy() {
        return origin.copy();
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
    public int hashCode() {
        return origin.hashCode();
    }

    @Override
    @NotNull
    public ItemStack asItemStack() {
        return origin.asItemStack();
    }
}
