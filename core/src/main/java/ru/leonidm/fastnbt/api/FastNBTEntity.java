package ru.leonidm.fastnbt.api;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.utils.FastEntityFactory;

public interface FastNBTEntity extends FastNBTCompound {

    @NotNull
    static FastNBTEntity wrap(@NotNull Entity entity) {
        return FastEntityFactory.get().wrap(entity);
    }

    @NotNull
    FastNBTCompound getLinkedPersistentCompound();

    void save();

    void savePersistentCompound();

}
