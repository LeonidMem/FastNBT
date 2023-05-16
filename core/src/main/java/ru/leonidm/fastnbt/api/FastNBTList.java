package ru.leonidm.fastnbt.api;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.utils.FastNBTUtils;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface FastNBTList<E> extends Iterable<E> {

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
    <T> FastNBTList<T> getList(int index, @NotNull FastNBTType<T> fastNBTType);

    void addList(@NotNull FastNBTList<?> fastNBTList);

    @NotNull
    ItemStack getItemStack(int index);

    void addItemStack(@NotNull ItemStack itemStack);

    void remove(int index);

    int size();

    boolean isEmpty();

    default boolean contains(@NotNull E e) {
        for (E e1 : this) {
            if (e.equals(e1)) {
                return true;
            }
        }

        return false;
    }

    default boolean remove(@NotNull E e) {
        int i = 0;
        for (E e1 : this) {
            if (e.equals(e1)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @NotNull
    @Contract("-> new")
    FastNBTList<E> copy();

    @Override
    @NotNull
    default Spliterator<E> spliterator() {
        return Spliterators.spliterator(iterator(), size(), 0);
    }

    @NotNull
    default Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @NotNull
    default Stream<E> parallelStream() {
        return StreamSupport.stream(spliterator(), true);
    }

}
