package ru.leonidm.fastnbt.api;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.utils.FastNBTUtils;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface FastNBTCompound {

    boolean getBoolean(@NotNull String key);

    void setBoolean(@NotNull String key, boolean value);

    byte getByte(@NotNull String key);

    void setByte(@NotNull String key, byte value);

    short getShort(@NotNull String key);

    void setShort(@NotNull String key, short value);

    int getInt(@NotNull String key);

    void setInt(@NotNull String key, int value);

    long getLong(@NotNull String key);

    void setLong(@NotNull String key, long value);

    float getFloat(@NotNull String key);

    void setFloat(@NotNull String key, float value);

    double getDouble(@NotNull String key);

    void setDouble(@NotNull String key, double value);

    @NotNull
    String getString(@NotNull String key);

    void setString(@NotNull String key, @NotNull String value);

    @NotNull
    UUID getUUID(@NotNull String key);

    void setUUID(@NotNull String key, @NotNull UUID value);

    byte @NotNull [] getByteArray(@NotNull String key);

    void setByteArray(@NotNull String key, byte @NotNull [] value);

    default void setByteArray(@NotNull String key, @NotNull List<Byte> value) {
        setByteArray(key, FastNBTUtils.toByteArray(value));
    }

    int @NotNull [] getIntArray(@NotNull String key);

    void setIntArray(@NotNull String key, int @NotNull [] value);

    default void setIntArray(@NotNull String key, @NotNull List<Integer> value) {
        setIntArray(key, FastNBTUtils.toIntArray(value));
    }

    long @NotNull [] getLongArray(@NotNull String key);

    void setLongArray(@NotNull String key, long @NotNull [] value);

    default void setLongArray(@NotNull String key, @NotNull List<Long> value) {
        setLongArray(key, FastNBTUtils.toLongArray(value));
    }

    @NotNull
    FastNBTCompound getCompound(@NotNull String key);

    void setCompound(@NotNull String key, @NotNull FastNBTCompound fastNBTCompound);

    @NotNull
    <T> FastNBTList<T> getList(@NotNull String key, @NotNull FastNBTType<T> fastNBTType);

    void setList(@NotNull String key, @NotNull FastNBTList<?> fastNBTList);

    @NotNull
    ItemStack getItemStack(@NotNull String key);

    void setItemStack(@NotNull String key, @NotNull ItemStack itemStack);

    @Contract(mutates = "this")
    void merge(@NotNull FastNBTCompound fastNBTCompound);

    boolean contains(@NotNull String key);

    boolean contains(@NotNull String key, @NotNull FastNBTType<?> fastNBTType);

    @NotNull
    Set<String> getKeys();

    void remove(@NotNull String key);

    int size();

    boolean isEmpty();

    @NotNull
    @Contract("-> new")
    FastNBTCompound copy();

}
