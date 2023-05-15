package ru.leonidm.fastnbt.api;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.utils.FastNBTUtils;

import java.util.List;

public interface FastNBTList {

    short getShort(int index);

    void addShort(short value);

    int getInt(int index);

    void addInt(int value);

    float getFloat(int index);

    void addFloat(float value);

    double getDouble(int index);

    void addDouble(double value);

    @NotNull
    String getString(int index);

    void addString(@NotNull String value);

    int @NotNull [] getIntArray(int index);

    void addIntArray(int @NotNull [] value);

    default void addIntArray(@NotNull List<Integer> value) {
        addIntArray(FastNBTUtils.toIntArray(value));
    }

    long @NotNull [] getLongArray(int index);

    void addLongArray(long @NotNull [] value);

    default void addLongArray(@NotNull List<Long> value) {
        addLongArray(FastNBTUtils.toLongArray(value));
    }

    @NotNull
    FastNBTCompound getCompound(int index);

    void addCompound(@NotNull FastNBTCompound fastNBTCompound);

    @NotNull
    FastNBTList getList(int index);

    void addList(@NotNull FastNBTList fastNBTList);

    @NotNull
    ItemStack getItemStack(int index);

    void addItemStack(@NotNull ItemStack itemStack);

    void remove(int index);

    int size();

    boolean isEmpty();

}
