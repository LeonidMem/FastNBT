package ru.leonidm.fastnbt.impl.v1_19_R3;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTEntity;
import ru.leonidm.fastnbt.api.FastNBTItem;
import ru.leonidm.fastnbt.api.FastNBTList;
import ru.leonidm.fastnbt.api.FastNBTType;
import ru.leonidm.fastnbt.utils.FastEntityFactory;

public class FastEntityFactoryImpl implements FastEntityFactory {

    @Override
    @NotNull
    public FastNBTCompound createCompound() {
        return new FastNBTCompoundImpl(new NBTTagCompound());
    }

    @Override
    @NotNull
    public <E> FastNBTList<E> createList(@NotNull FastNBTType<E> fastNBTType) {
        return new FastNBTListImpl<>(new NBTTagList(), fastNBTType);
    }

    @Override
    @NotNull
    public FastNBTCompound asCompound(@NotNull ItemStack itemStack) {
        return new FastNBTCompoundImpl(NMSFastNBTUtils.asCompound(itemStack));
    }

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
