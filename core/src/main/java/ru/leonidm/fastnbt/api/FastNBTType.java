package ru.leonidm.fastnbt.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public final class FastNBTType<T> {

    public static final FastNBTType<Byte> BYTE = new FastNBTType<>("BYTE",1, null);
    public static final FastNBTType<Short> SHORT = new FastNBTType<>("SHORT", 2, FastNBTList::getShort);
    public static final FastNBTType<Integer> INT = new FastNBTType<>("INT", 3, FastNBTList::getInt);
    public static final FastNBTType<Long> LONG = new FastNBTType<>("LONG", 4, null);
    public static final FastNBTType<Float> FLOAT = new FastNBTType<>("FLOAT", 5, FastNBTList::getFloat);
    public static final FastNBTType<Double> DOUBLE = new FastNBTType<>("DOUBLE", 6, FastNBTList::getDouble);
    public static final FastNBTType<byte[]> BYTE_ARRAY = new FastNBTType<>("BYTE_ARRAY", 7, null);
    public static final FastNBTType<String> STRING = new FastNBTType<>("STRING", 8, FastNBTList::getString);
    public static final FastNBTType<FastNBTList<?>> LIST = new FastNBTType<>("LIST", 9, null);
    public static final FastNBTType<FastNBTCompound> COMPOUND = new FastNBTType<>("COMPOUND", 10, FastNBTList::getCompound);
    public static final FastNBTType<int[]> INT_ARRAY = new FastNBTType<>("INT_ARRAY", 11, FastNBTList::getIntArray);

    private final String name;
    private final int id;
    private final BiFunction<FastNBTList<?>, Integer, T> listGetter;

    public FastNBTType(@NotNull String name, int id, @Nullable BiFunction<FastNBTList<?>, Integer, T> listGetter) {
        this.name = name;
        this.id = id;
        this.listGetter = listGetter;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Nullable
    public BiFunction<FastNBTList<?>, Integer, T> getListGetter() {
        return listGetter;
    }
}
