package ru.leonidm.fastnbt.api;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.utils.FastEntityFactory;

public interface FastNBTItem extends FastNBTCompound {
    @NotNull
    static FastNBTItem write(@NotNull ItemStack itemStack, boolean directApply) {
        return FastEntityFactory.get().wrapForWrite(itemStack, directApply);
    }

    @NotNull
    static FastNBTItem read(@NotNull ItemStack itemStack) {
        return FastEntityFactory.get().wrapForRead(itemStack);
    }

    @NotNull
    ItemStack getOrigin();

}
