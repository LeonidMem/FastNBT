package ru.leonidm.fastnbt.impl.v1_19_R1;

import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLongArray;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;
import ru.leonidm.fastnbt.api.FastNBTType;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class FastNBTListImpl<E> implements FastNBTList<E> {

    protected NBTTagList nbtTagList;
    protected FastNBTType<E> fastNBTType;
    protected int modCount = 0;

    public FastNBTListImpl(@NotNull NBTTagList nbtTagList, @NotNull FastNBTType<E> fastNBTType) {
        this.nbtTagList = nbtTagList;
        this.fastNBTType = fastNBTType;
    }

    protected FastNBTListImpl() {

    }

    @Override
    public short getShort(int index) {
        // d = NBTTagList (I)S getShort
        return nbtTagList.d(index);
    }

    @Override
    public void addShort(short value) {
        // a = NBTTagShort (S)NBTTagShort valueOf
        nbtTagList.add(NBTTagShort.a(value));
        modCount += 1;
    }

    @Override
    public int getInt(int index) {
        // e = NBTTagList (I)I getInt
        return nbtTagList.e(index);
    }

    @Override
    public void addInt(int value) {
        // a = NBTTagInt (I)NBTTagInt valueOf
        nbtTagList.add(NBTTagInt.a(value));
        modCount += 1;
    }

    @Override
    public float getFloat(int index) {
        // i = NBTTagList (I)F getFloat
        return nbtTagList.i(index);
    }

    @Override
    public void addFloat(float value) {
        // a = NBTTagFloat (F)NBTTagFloat valueOf
        nbtTagList.add(NBTTagFloat.a(value));
        modCount += 1;
    }

    @Override
    public double getDouble(int index) {
        // h = NBTTagList (I)D getDouble
        return nbtTagList.h(index);
    }

    @Override
    public void addDouble(double value) {
        // a = NBTTagDouble (D)NBTTagDouble valueOf
        nbtTagList.add(NBTTagDouble.a(value));
        modCount += 1;
    }

    @Override
    @NotNull
    public String getString(int index) {
        // j = NBTTagList (I)String getString
        return nbtTagList.j(index);
    }

    @Override
    public void addString(@NotNull String value) {
        // a = NBTTagString (String)NBTTagString valueOf
        nbtTagList.add(NBTTagString.a(value));
        modCount += 1;
    }

    @Override
    public int @NotNull [] getIntArray(int index) {
        // f = NBTTagList (I)[I getIntArray
        return nbtTagList.f(index);
    }

    @Override
    public void addIntArray(int @NotNull [] value) {
        nbtTagList.add(new NBTTagIntArray(value));
        modCount += 1;
    }

    @Override
    public long @NotNull [] getLongArray(int index) {
        // g = NBTTagList (I)[J getLongArray
        return nbtTagList.g(index);
    }

    @Override
    public void addLongArray(long @NotNull [] value) {
        nbtTagList.add(new NBTTagLongArray(value));
        modCount += 1;
    }

    @Override
    @NotNull
    public FastNBTCompound getCompound(int index) {
        // a = NBTTagList (I)net.minecraft.nbt.NBTTagCompound getCompound
        return new FastNBTCompoundImpl(nbtTagList.a(index));
    }

    @Override
    public void addCompound(@NotNull FastNBTCompound fastNBTCompound) {
        nbtTagList.add(((FastNBTCompoundImpl) fastNBTCompound).nbtTagCompound);
        modCount += 1;
    }

    @Override
    @NotNull
    public <T> FastNBTList<T> getList(int index, @NotNull FastNBTType<T> fastNBTType) {
        // b = NBTTagList (I)NBTTagList getList
        return new FastNBTListImpl<>(nbtTagList.b(index), fastNBTType);
    }

    @Override
    public void addList(@NotNull FastNBTList<?> fastNBTList) {
        nbtTagList.add(((FastNBTListImpl<?>) fastNBTList).nbtTagList);
        modCount += 1;
    }

    @Override
    @NotNull
    public ItemStack getItemStack(int index) {
        // a = NBTTagList (I)net.minecraft.nbt.NBTTagCompound getCompound
        return NMSFastNBTUtils.asItemStack(nbtTagList.a(index));
    }

    @Override
    public void addItemStack(@NotNull ItemStack itemStack) {
        nbtTagList.add(NMSFastNBTUtils.asCompound(itemStack));
        modCount += 1;
    }

    @Override
    public void remove(int index) {
        // c = NBTTagList (I)net.minecraft.nbt.NBTBase remove
        nbtTagList.c(index);
        modCount += 1;
    }

    @Override
    public int size() {
        return nbtTagList.size();
    }

    @Override
    public boolean isEmpty() {
        return nbtTagList.isEmpty();
    }

    @Override
    @NotNull
    @Contract("-> new")
    public FastNBTList<E> copy() {
        // c = NBTTagList ()net.minecraft.nbt.NBTBase copy
        return new FastNBTListImpl<>((NBTTagList) nbtTagList.c(), fastNBTType);
    }

    @Override
    @NotNull
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private final int expectedModCount = modCount;
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor != size();
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }

                int i = cursor;
                if (i >= size()) {
                    throw new NoSuchElementException();
                }

                var getter = fastNBTType.getListGetter();
                if (getter == null) {
                    throw new IllegalStateException("Cannot iterate over %s".formatted(fastNBTType.getName()));
                }

                E e = getter.apply(FastNBTListImpl.this, cursor);
                cursor = i + 1;
                return e;
            }
        };
    }

    @Override
    public String toString() {
        return "FastNBTListImpl" + nbtTagList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FastNBTListImpl<?> that = (FastNBTListImpl<?>) o;
        return fastNBTType == that.fastNBTType &&
                nbtTagList.equals(that.nbtTagList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fastNBTType, nbtTagList);
    }
}
