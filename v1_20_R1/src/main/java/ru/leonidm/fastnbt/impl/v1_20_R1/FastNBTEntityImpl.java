package ru.leonidm.fastnbt.impl.v1_20_R1;

import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTEntity;

public class FastNBTEntityImpl extends FastNBTCompoundImpl implements FastNBTEntity {

    private final Entity entity;

    public FastNBTEntityImpl(@NotNull Entity entity) {
        this.entity = entity;

        nbtTagCompound = NMSFastNBTUtils.asCompound(entity);
    }

    @NotNull
    public FastNBTCompound getLinkedPersistentCompound() {
        return getLinkedCompound("BukkitValues");
    }

    @Override
    public void save() {
        NMSFastNBTUtils.saveCompound(entity, nbtTagCompound);
    }

    @Override
    public void savePersistentCompound() {
        if (contains("BukkitValues")) {
            // p = NBTTagCompound (String)NBTTagCompound getCompound
            NBTTagCompound nbtTagCompound1 = nbtTagCompound.p("BukkitValues");

            NMSFastNBTUtils.saveBukkitCompound(entity, nbtTagCompound1);
        } else {
            NMSFastNBTUtils.saveBukkitCompound(entity, new NBTTagCompound());
        }
    }
}
