package ru.leonidm.fastnbt.impl.v1_19_R1;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTEntity;
import ru.leonidm.fastnbt.api.FastNBTItem;
import ru.leonidm.fastnbt.utils.FastEntityFactory;

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

    @Override
    @NotNull
    public FastNBTEntity wrap(@NotNull Entity entity) {
        return new FastNBTEntityImpl(entity);
    }
}
