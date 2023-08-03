package ru.leonidm.fastnbt.impl.v1_20_R1;

import lombok.SneakyThrows;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_20_R1.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.leonidm.fastnbt.utils.FastNBTUnsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public final class NMSFastNBTUtils {

    private static final Field HANDLE_FIELD;
    private static final Field UNHANDLED_TAGS_FIELD;
    private static final Method APPLY_TO_ITEM_FIELD;

    static {
        try {
            HANDLE_FIELD = CraftItemStack.class.getDeclaredField("handle");
            HANDLE_FIELD.setAccessible(true);

            Class<?> craftMetaItemClass = Class.forName("org.bukkit.craftbukkit.v1_20_R1.inventory.CraftMetaItem");
            UNHANDLED_TAGS_FIELD = craftMetaItemClass.getDeclaredField("unhandledTags");
            UNHANDLED_TAGS_FIELD.setAccessible(true);

            APPLY_TO_ITEM_FIELD = craftMetaItemClass.getDeclaredMethod("applyToItem", NBTTagCompound.class);
            APPLY_TO_ITEM_FIELD.setAccessible(true);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private NMSFastNBTUtils() {

    }

    @Nullable
    @SneakyThrows
    public static net.minecraft.world.item.ItemStack getHandle(@NotNull ItemStack itemStack) {
        if (itemStack instanceof CraftItemStack) {
            return (net.minecraft.world.item.ItemStack) HANDLE_FIELD.get(itemStack);
        }

        return null;
    }

    @NotNull
    @SneakyThrows
    public static NBTTagCompound getCompound(@NotNull ItemStack itemStack, boolean copy) {
        var nmsItemStack = getHandle(itemStack);
        if (nmsItemStack != null) {
            // v = net.minecraft.world.item.ItemStack ()NBTTagCompound getTag
            NBTTagCompound compound = nmsItemStack.v();
            if (compound == null) {
                return new NBTTagCompound();
            }

            // d = NBTTagCompound ()net.minecraft.nbt.NBTBase copy
            return copy ? (NBTTagCompound) compound.d() : compound;
        }

        NBTTagCompound compound = new NBTTagCompound();
        ItemMeta itemMeta = FastNBTUnsafe.getOriginalMeta(itemStack);
        if (itemMeta != null) {
            APPLY_TO_ITEM_FIELD.invoke(itemMeta, compound);
        }

        return compound;
    }

    @NotNull
    @SneakyThrows
    public static Map<String, NBTBase> getUnhandledTags(@NotNull ItemMeta itemMeta) {
        return (Map<String, NBTBase>) UNHANDLED_TAGS_FIELD.get(itemMeta);
    }

    @NotNull
    public static NBTTagCompound asCompound(@NotNull ItemStack itemStack) {
        NBTTagCompound itemCompound = new NBTTagCompound();

        // a = NBTTagCompound (String,String)V putString
        itemCompound.a("id", itemStack.getType().getKey().asString());

        // a = NBTTagCompound (String,String)V putString
        itemCompound.a("Count", (byte) itemStack.getAmount());

        NBTTagCompound compound = NMSFastNBTUtils.getCompound(itemStack, true);
        // g = NBTTagCompound ()Z isEmpty
        if (!compound.g()) {
            // a = NBTTagCompound (String,net.minecraft.nbt.NBTBase)net.minecraft.nbt.NBTBase put
            itemCompound.a("tag", compound);
        }

        return itemCompound;
    }

    @NotNull
    public static ItemStack asItemStack(@NotNull NBTTagCompound itemCompound) {
        // a = net.minecraft.world.item.ItemStack (NBTTagCompound)net.minecraft.world.item.ItemStack of
        var nmsItemStack = net.minecraft.world.item.ItemStack.a(itemCompound);

        return CraftItemStack.asCraftMirror(nmsItemStack);
    }

    @NotNull
    public static NBTTagCompound asCompound(@NotNull Entity entity) {
        if (entity instanceof CraftEntity craftEntity) {
            net.minecraft.world.entity.Entity nmsEntity = craftEntity.getHandle();

            // f = net.minecraft.world.entity.Entity (NBTTagCompound)NBTTagCompound saveWithoutId
            return nmsEntity.f(new NBTTagCompound());
        }

        throw new IllegalArgumentException("Entity " + entity.getClass().getName() + " is not CraftEntity");
    }

    public static void saveCompound(@NotNull Entity entity, @NotNull NBTTagCompound entityCompound) {
        if (entity instanceof CraftEntity craftEntity) {
            net.minecraft.world.entity.Entity nmsEntity = craftEntity.getHandle();

            // g = net.minecraft.world.entity.Entity (NBTTagCompound)V load
            nmsEntity.g(entityCompound);
            return;
        }

        throw new IllegalArgumentException("Entity " + entity.getClass().getName() + " is not CraftEntity");
    }

    public static void saveBukkitCompound(@NotNull Entity entity, @NotNull NBTTagCompound bukkitValuesCompound) {
        if (entity instanceof CraftEntity craftEntity) {
            craftEntity.readBukkitValues(bukkitValuesCompound);
            return;
        }

        throw new IllegalArgumentException("Entity " + entity.getClass().getName() + " is not CraftEntity");
    }
}
