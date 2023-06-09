package ru.leonidm.fastnbt.utils;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;
import ru.leonidm.fastnbt.api.FastNBTType;

import java.util.Iterator;

final class UnmodifiableFastNBTList<E> implements FastNBTList<E> {

    private final FastNBTList<E> origin;

    UnmodifiableFastNBTList(@NotNull FastNBTList<E> origin) {
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
    @NotNull
    public String getString(int index) {
        return origin.getString(index);
    }

    @Override
    public void addString(@NotNull String value) {
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
    public <T> FastNBTList<T> getList(int index, @NotNull FastNBTType<T> fastNBTType) {
        return FastNBTUtils.unmodifiableList(origin.getList(index, fastNBTType));
    }

    @Override
    public void addList(@NotNull FastNBTList<?> fastNBTList) {
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

    @Override
    @NotNull
    @Contract("-> new")
    public FastNBTList<E> copy() {
        return origin.copy();
    }

    @Override
    @NotNull
    public Iterator<E> iterator() {
        return origin.iterator();
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
}
