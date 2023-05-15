package ru.leonidm.fastnbt.utils;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;

final class UnmodifiableFastNBTList implements FastNBTList {

    private final FastNBTList origin;

    UnmodifiableFastNBTList(@NotNull FastNBTList origin) {
        this.origin = origin;
    }

    @Override
    public short getShort(int index) {
        return origin.getShort(index);
    }

    @Override
    public void addShort(short value) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    public int getInt(int index) {
        return origin.getInt(index);
    }

    @Override
    public void addInt(int value) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    public float getFloat(int index) {
        return origin.getFloat(index);
    }

    @Override
    public void addFloat(float value) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    public double getDouble(int index) {
        return origin.getDouble(index);
    }

    @Override
    public void addDouble(double value) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    public int @NotNull [] getIntArray(int index) {
        return origin.getIntArray(index);
    }

    @Override
    public void addIntArray(int @NotNull [] value) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    public long @NotNull [] getLongArray(int index) {
        return origin.getLongArray(index);
    }

    @Override
    public void addLongArray(long @NotNull [] value) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    @NotNull
    public FastNBTCompound getCompound(int index) {
        return FastNBTUtils.unmodifiableCompound(origin.getCompound(index));
    }

    @Override
    public void addCompound(@NotNull FastNBTCompound fastNBTCompound) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    @NotNull
    public FastNBTList getList(int index) {
        return FastNBTUtils.unmodifiableList(origin.getList(index));
    }

    @Override
    public void addList(@NotNull FastNBTList fastNBTList) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    @NotNull
    public ItemStack getItemStack(int index) {
        return FastNBTUtils.unmodifiableItemStack(origin.getItemStack(index));
    }

    @Override
    public void addItemStack(@NotNull ItemStack itemStack) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException("FastNBTList is unmodifiable");
    }

    @Override
    public int size() {
        return origin.size();
    }

    @Override
    public boolean isEmpty() {
        return origin.isEmpty();
    }
}
