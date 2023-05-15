package ru.leonidm.fastnbt.utils;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTItem;

public interface FastEntityFactory {

    @NotNull
    static FastEntityFactory get() {
        return FastNBTLinker.getFactory();
    }

    @NotNull
    FastNBTItem wrapForWrite(@NotNull ItemStack itemStack, boolean directApply);

    @NotNull
    FastNBTItem wrapForRead(@NotNull ItemStack itemStack);

}
