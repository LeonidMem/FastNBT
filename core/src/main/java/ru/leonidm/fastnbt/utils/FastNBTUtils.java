package ru.leonidm.fastnbt.utils;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;

import java.util.List;

public final class FastNBTUtils {

    private FastNBTUtils() {

    }

    @Contract("null -> null; !null -> !null")
    public static byte [] toByteArray(@Nullable List<Byte> list) {
        if (list == null) {
            return null;
        }

        byte[] out = new byte[list.size()];
        int i = 0;
        for (byte b : list) {
            out[i] = b;
            i++;
        }

        return out;
    }

    @Contract("null -> null; !null -> !null")
    public static int [] toIntArray(@Nullable List<Integer> list) {
        if (list == null) {
            return null;
        }

        int[] out = new int[list.size()];
        int i = 0;
        for (int b : list) {
            out[i] = b;
            i++;
        }

        return out;
    }

    @Contract("null -> null; !null -> !null")
    public static long [] toLongArray(@Nullable List<Long> list) {
        if (list == null) {
            return null;
        }

        long[] out = new long[list.size()];
        int i = 0;
        for (long b : list) {
            out[i] = b;
            i++;
        }

        return out;
    }

    @NotNull
    public static FastNBTCompound unmodifiableCompound(@NotNull FastNBTCompound fastNBTCompound) {
        return fastNBTCompound instanceof UnmodifiableFastNBTCompound
                ? fastNBTCompound
                : new UnmodifiableFastNBTCompound(fastNBTCompound);
    }

    @NotNull
    public static <E> FastNBTList<E> unmodifiableList(@NotNull FastNBTList<E> fastNBTList) {
        return fastNBTList instanceof UnmodifiableFastNBTList
                ? fastNBTList
                : new UnmodifiableFastNBTList<>(fastNBTList);
    }

    @NotNull
    public static ItemStack unmodifiableItemStack(@NotNull ItemStack itemStack) {
        return itemStack instanceof UnmodifiableItemStack
                ? itemStack
                : new UnmodifiableItemStack(itemStack);
    }
}
