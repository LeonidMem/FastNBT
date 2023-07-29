package ru.leonidm.fastnbt.utils;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTEntity;
import ru.leonidm.fastnbt.api.FastNBTItem;
import ru.leonidm.fastnbt.api.FastNBTList;
import ru.leonidm.fastnbt.api.FastNBTType;

public interface FastEntityFactory {

    @NotNull
    static FastEntityFactory get() {
        return FastNBTLinker.getFactory();
    }

    @NotNull
    FastNBTCompound createCompound();

    @NotNull
    <E> FastNBTList<E> createList(@NotNull FastNBTType<E> fastNBTType);

    @NotNull
    FastNBTItem wrapForWrite(@NotNull ItemStack itemStack, boolean directApply);

    @NotNull
    FastNBTItem wrapForRead(@NotNull ItemStack itemStack);

    @NotNull
    FastNBTEntity wrap(@NotNull Entity entity);

}
