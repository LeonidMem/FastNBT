package ru.leonidm.fastnbt.impl.v1_19_R2;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;
import ru.leonidm.fastnbt.api.FastNBTType;

import java.util.Set;
import java.util.UUID;

public class FastNBTCompoundImpl implements FastNBTCompound {

    protected NBTTagCompound nbtTagCompound;

    public FastNBTCompoundImpl(@NotNull NBTTagCompound nbtTagCompound) {
        this.nbtTagCompound = nbtTagCompound;
    }

    protected FastNBTCompoundImpl() {

    }

    @Override
    public boolean getBoolean(@NotNull String key) {
        // q = NBTTagCompound (String)Z getBoolean
        return nbtTagCompound.q(key);
    }

    @Override
    public void setBoolean(@NotNull String key, boolean value) {
        // a = NBTTagCompound (String,Z)V putBoolean
        nbtTagCompound.a(key, value);
    }

    @Override
    public byte getByte(@NotNull String key) {
        // f = NBTTagCompound (String)B getByte
        return nbtTagCompound.f(key);
    }

    @Override
    public void setByte(@NotNull String key, byte value) {
        // a = NBTTagCompound (String,B)V putByte
        nbtTagCompound.a(key, value);
    }

    @Override
    public short getShort(@NotNull String key) {
        // g = NBTTagCompound (String)S getShort
        return nbtTagCompound.g(key);
    }

    @Override
    public void setShort(@NotNull String key, short value) {
        // a = NBTTagCompound (String,S)V putShort
        nbtTagCompound.a(key, value);
    }

    @Override
    public int getInt(@NotNull String key) {
        // h = NBTTagCompound (String)I getInt
        return nbtTagCompound.h(key);
    }

    @Override
    public void setInt(@NotNull String key, int value) {
        // a = NBTTagCompound (String,I)V putInt
        nbtTagCompound.a(key, value);
    }

    @Override
    public long getLong(@NotNull String key) {
        // i = NBTTagCompound (String)J getLong
        return nbtTagCompound.i(key);
    }

    @Override
    public void setLong(@NotNull String key, long value) {
        // a = NBTTagCompound (String,J)V putLong
        nbtTagCompound.a(key, value);
    }

    @Override
    public float getFloat(@NotNull String key) {
        // j = NBTTagCompound (String)F getFloat
        return nbtTagCompound.j(key);
    }

    @Override
    public void setFloat(@NotNull String key, float value) {
        // a = NBTTagCompound (String,F)V putFloat
        nbtTagCompound.a(key, value);
    }

    @Override
    public double getDouble(@NotNull String key) {
        // k = NBTTagCompound (String)D getDouble
        return nbtTagCompound.k(key);
    }

    @Override
    public void setDouble(@NotNull String key, double value) {
        // a = NBTTagCompound (String,D)V putDouble
        nbtTagCompound.a(key, value);
    }

    @Override
    @NotNull
    public String getString(@NotNull String key) {
        // l = NBTTagCompound (String)String getString
        return nbtTagCompound.l(key);
    }

    @Override
    public void setString(@NotNull String key, @NotNull String value) {
        // a = NBTTagCompound (String,String)V putString
        nbtTagCompound.a(key, value);
    }

    @Override
    @NotNull
    public UUID getUUID(@NotNull String key) {
        // a = NBTTagCompound (String)UUID getUUID
        return nbtTagCompound.a(key);
    }

    @Override
    public void setUUID(@NotNull String key, @NotNull UUID value) {
        // a = NBTTagCompound (String,UUID)V putUUID
        nbtTagCompound.a(key, value);
    }

    @Override
    public byte @NotNull [] getByteArray(@NotNull String key) {
        // m = NBTTagCompound (String)[B getByteArray
        return nbtTagCompound.m(key);
    }

    @Override
    public void setByteArray(@NotNull String key, byte @NotNull [] value) {
        // a = NBTTagCompound (String, [B)V putByteArray
        nbtTagCompound.a(key, value);
    }

    @Override
    public int @NotNull [] getIntArray(@NotNull String key) {
        // n = NBTTagCompound (String)[I getIntArray
        return nbtTagCompound.n(key);
    }

    @Override
    public void setIntArray(@NotNull String key, int @NotNull [] value) {
        // a = NBTTagCompound (String,[I)V putIntArray
        nbtTagCompound.a(key, value);
    }

    @Override
    public long @NotNull [] getLongArray(@NotNull String key) {
        // o = NBTTagCompound (String)[J getLongArray
        return nbtTagCompound.o(key);
    }

    @Override
    public void setLongArray(@NotNull String key, long @NotNull [] value) {
        // a = NBTTagCompound (String,[J)V putLongArray
        nbtTagCompound.a(key, value);
    }

    @Override
    @NotNull
    public FastNBTCompound getCompound(@NotNull String key) {
        // p = NBTTagCompound (String)NBTTagCompound getCompound
        return new FastNBTCompoundImpl(nbtTagCompound.p(key));
    }

    @Override
    @NotNull
    public FastNBTCompound getLinkedCompound(@NotNull String key) {
        // p = NBTTagCompound (String)NBTTagCompound getCompound
        NBTTagCompound nbtTagCompound1 = nbtTagCompound.p(key);

        if (!contains(key)) {
            // a = NBTTagCompound (String,net.minecraft.nbt.NBTBase)net.minecraft.nbt.NBTBase put
            nbtTagCompound.a(key, nbtTagCompound1);
        }

        return new FastNBTCompoundImpl(nbtTagCompound1);
    }

    @Override
    public void setCompound(@NotNull String key, @NotNull FastNBTCompound fastNBTCompound) {
        // a = NBTTagCompound (String,net.minecraft.nbt.NBTBase)net.minecraft.nbt.NBTBase put
        nbtTagCompound.a(key, ((FastNBTCompoundImpl) fastNBTCompound).nbtTagCompound);
    }

    @Override
    @NotNull
    public <T> FastNBTList<T> getList(@NotNull String key, @NotNull FastNBTType<T> fastNBTType) {
        // c = NBTTagCompound (String,I)NBTTagList getList
        return new FastNBTListImpl<>(nbtTagCompound.c(key, fastNBTType.getId()), fastNBTType);
    }

    @Override
    @NotNull
    public <T> FastNBTList<T> getLinkedList(@NotNull String key, @NotNull FastNBTType<T> fastNBTType) {
        // c = NBTTagCompound (String,I)NBTTagList getList
        NBTTagList nbtTagList = nbtTagCompound.c(key, fastNBTType.getId());

        if (!contains(key)) {
            // a = NBTTagCompound (String,net.minecraft.nbt.NBTBase)net.minecraft.nbt.NBTBase put
            nbtTagCompound.a(key, nbtTagList);
        }

        return new FastNBTListImpl<>(nbtTagList, fastNBTType);
    }

    @Override
    public void setList(@NotNull String key, @NotNull FastNBTList<?> fastNBTList) {
        // a = NBTTagCompound (String,net.minecraft.nbt.NBTBase)net.minecraft.nbt.NBTBase put
        nbtTagCompound.a(key, ((FastNBTListImpl<?>) fastNBTList).nbtTagList);
    }

    @Override
    @NotNull
    public ItemStack getItemStack(@NotNull String key) {
        // p = NBTTagCompound (String)NBTTagCompound getCompound
        return NMSFastNBTUtils.asItemStack(nbtTagCompound.p(key));
    }

    @Override
    public void setItemStack(@NotNull String key, @NotNull ItemStack itemStack) {
        // a = NBTTagCompound (String,net.minecraft.nbt.NBTBase)net.minecraft.nbt.NBTBase put
        nbtTagCompound.a(key, NMSFastNBTUtils.asCompound(itemStack));
    }

    @Override
    public void merge(@NotNull FastNBTCompound fastNBTCompound) {
        // a = NBTTagCompound (NBTTagCompound)NBTTagCompound merge
        nbtTagCompound.a(((FastNBTCompoundImpl) fastNBTCompound).nbtTagCompound);
    }

    @Override
    public boolean contains(@NotNull String key) {
        // e = NBTTagCompound (String)Z contains
        return nbtTagCompound.e(key);
    }

    @Override
    public boolean contains(@NotNull String key, @NotNull FastNBTType<?> fastNBTType) {
        // b = NBTTagCompound (String,I)Z contains
        return nbtTagCompound.b(key, fastNBTType.getId());
    }

    @Override
    @NotNull
    public Set<String> getKeys() {
        // e = NBTTagCompound ()Set getAllKeys
        return nbtTagCompound.e();
    }

    @Override
    public void remove(@NotNull String key) {
        // r = NBTTagCompound (String)V remove
        nbtTagCompound.r(key);
    }

    @Override
    public int size() {
        // f = NBTTagCompound ()I size
        return nbtTagCompound.f();
    }

    @Override
    public boolean isEmpty() {
        // g = NBTTagCompound ()Z isEmpty
        return nbtTagCompound.g();
    }

    @Override
    @NotNull
    @Contract("-> new")
    public FastNBTCompound copy() {
        return new FastNBTCompoundImpl((NBTTagCompound) nbtTagCompound.c());
    }

    @Override
    @NotNull
    public ItemStack asItemStack() {
        return NMSFastNBTUtils.asItemStack(nbtTagCompound);
    }

    @Override
    public String toString() {
        return "FastNBTCompoundImpl" + nbtTagCompound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FastNBTCompoundImpl that = (FastNBTCompoundImpl) o;
        return nbtTagCompound.equals(that.nbtTagCompound);
    }

    @Override
    public int hashCode() {
        return nbtTagCompound.hashCode();
    }
}
