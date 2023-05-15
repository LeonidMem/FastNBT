package ru.leonidm.fastnbt.impl.v1_19_R1;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.utils.FastEntityFactory;
import ru.leonidm.fastnbt.api.FastNBTItem;

public class FastEntityFactoryImpl implements FastEntityFactory {

    @Override
    @NotNull
    public FastNBTItem wrapForWrite(@NotNull ItemStack itemStack, boolean directApply) {
        return new FastNBTItemReadWriteImpl(itemStack, directApply);
    }

    @Override
    @NotNull
    public FastNBTItem wrapForRead(@NotNull ItemStack itemStack) {
        return new FastNBTItemReadOnlyImpl(itemStack);
    }
}
