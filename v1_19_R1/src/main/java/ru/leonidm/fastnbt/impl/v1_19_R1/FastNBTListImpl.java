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
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;

public class FastNBTListImpl implements FastNBTList {

    protected NBTTagList nbtTagList;

    public FastNBTListImpl(@NotNull NBTTagList nbtTagList) {
        this.nbtTagList = nbtTagList;
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
    }

    @Override
    public int @NotNull [] getIntArray(int index) {
        // f = NBTTagList (I)[I getIntArray
        return nbtTagList.f(index);
    }

    @Override
    public void addIntArray(int @NotNull [] value) {
        nbtTagList.add(new NBTTagIntArray(value));
    }

    @Override
    public long @NotNull [] getLongArray(int index) {
        // g = NBTTagList (I)[J getLongArray
        return nbtTagList.g(index);
    }

    @Override
    public void addLongArray(long @NotNull [] value) {
        nbtTagList.add(new NBTTagLongArray(value));
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
    }

    @Override
    @NotNull
    public FastNBTList getList(int index) {
        // b = NBTTagList (I)NBTTagList getList
        return new FastNBTListImpl(nbtTagList.b(index));
    }

    @Override
    public void addList(@NotNull FastNBTList fastNBTList) {
        nbtTagList.add(((FastNBTListImpl) fastNBTList).nbtTagList);
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
    }

    @Override
    public void remove(int index) {
        // c = NBTTagList (I)net.minecraft.nbt.NBTBase remove
        nbtTagList.c(index);
    }

    @Override
    public int size() {
        return nbtTagList.size();
    }

    @Override
    public boolean isEmpty() {
        return nbtTagList.isEmpty();
    }
}
