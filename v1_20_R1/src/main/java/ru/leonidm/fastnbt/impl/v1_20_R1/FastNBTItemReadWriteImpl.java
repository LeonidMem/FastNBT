package ru.leonidm.fastnbt.impl.v1_20_R1;

import net.minecraft.nbt.GameProfileSerializer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagLongArray;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;
import org.bukkit.craftbukkit.v1_20_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.utils.FastNBTUnsafe;
import ru.leonidm.fastnbt.api.FastNBTCompound;
import ru.leonidm.fastnbt.api.FastNBTList;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;

public class FastNBTItemReadWriteImpl extends FastNBTItemImpl {

    private static final Set<String> FORBIDDEN_TAGS = Set.of(
            "display", "CustomModelData", "Enchantments", "RepairCost", "AttributeModifiers", "HideFlags",
            "Unbreakable", "Damage"
    );

    private final Map<String, NBTBase> itemMetaUnhandledTags;
    private final boolean applyToMeta;

    public FastNBTItemReadWriteImpl(@NotNull ItemStack itemStack, boolean directApply) {

        if (directApply) {
            this.itemStack = itemStack;
            validateItemStack();
            applyToMeta = NMSFastNBTUtils.getHandle(itemStack) == null;
        } else {
            net.minecraft.world.item.ItemStack nmsItemStack = null;
            if (itemStack instanceof CraftItemStack) {
                nmsItemStack = NMSFastNBTUtils.getHandle(itemStack);
            }

            if (nmsItemStack == null) {
                nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
            }

            this.itemStack = CraftItemStack.asCraftMirror(nmsItemStack);
            validateItemStack();
            applyToMeta = false;
        }

        nbtTagCompound = NMSFastNBTUtils.getCompound(this.itemStack, false);

        if (applyToMeta) {
            ItemMeta itemMeta0 = FastNBTUnsafe.getOriginalMeta(itemStack);
            if (itemMeta0 == null) {
                itemMeta0 = FastNBTUnsafe.initializeMeta(itemStack);
            }

            itemMetaUnhandledTags = NMSFastNBTUtils.getUnhandledTags(itemMeta0);
        } else {
            itemMetaUnhandledTags = null;
        }
    }

    @NotNull
    @Override
    public ItemStack getOrigin() {
        return itemStack;
    }

    @Override
    public void setBoolean(@NotNull String key, boolean value) {
        checkTag(key);
        super.setBoolean(key, value);
        // a = NBTTagByte (Z)NBTTagByte valueOf
        applyChanges(key, () -> NBTTagByte.a(value));
    }

    @Override
    public void setByte(@NotNull String key, byte value) {
        checkTag(key);
        super.setByte(key, value);
        // a = NBTTagByte (B)NBTTagByte valueOf
        applyChanges(key, () -> NBTTagByte.a(value));
    }

    @Override
    public void setShort(@NotNull String key, short value) {
        checkTag(key);
        super.setShort(key, value);
        // a = NBTTagShort (S)NBTTagShort valueOf
        applyChanges(key, () -> NBTTagShort.a(value));
    }

    @Override
    public void setInt(@NotNull String key, int value) {
        checkTag(key);
        super.setInt(key, value);
        // a = NBTTagInt (I)NBTTagInt valueOf
        applyChanges(key, () -> NBTTagInt.a(value));
    }

    @Override
    public void setLong(@NotNull String key, long value) {
        checkTag(key);
        super.setLong(key, value);
        // a = NBTTagLong (J)NBTTagLong valueOf
        applyChanges(key, () -> NBTTagLong.a(value));
    }

    @Override
    public void setFloat(@NotNull String key, float value) {
        checkTag(key);
        super.setFloat(key, value);
        // a = NBTTagFloat (F)NBTTagFloat valueOf
        applyChanges(key, () -> NBTTagFloat.a(value));
    }

    @Override
    public void setDouble(@NotNull String key, double value) {
        checkTag(key);
        super.setDouble(key, value);
        // a = NBTTagDouble (D)NBTTagDouble valueOf
        applyChanges(key, () -> NBTTagDouble.a(value));
    }

    @Override
    public void setString(@NotNull String key, @NotNull String value) {
        checkTag(key);
        super.setString(key, value);
        // a = NBTTagString (String)NBTTagString valueOf
        applyChanges(key, () -> NBTTagString.a(value));
    }

    @Override
    public void setUUID(@NotNull String key, @NotNull UUID value) {
        checkTag(key);
        super.setUUID(key, value);
        // a = GameProfileSerializer (UUID)net.minecraft.nbt.NBTTagIntArray createUUID
        applyChanges(key, () -> GameProfileSerializer.a(value));
    }

    @Override
    public void setByteArray(@NotNull String key, byte @NotNull [] value) {
        checkTag(key);
        super.setByteArray(key, value);
        applyChanges(key, () -> new NBTTagByteArray(value));
    }

    @Override
    public void setIntArray(@NotNull String key, int @NotNull [] value) {
        checkTag(key);
        super.setIntArray(key, value);
        applyChanges(key, () -> new NBTTagIntArray(value));
    }

    @Override
    public void setLongArray(@NotNull String key, long @NotNull [] value) {
        checkTag(key);
        super.setLongArray(key, value);
        applyChanges(key, () -> new NBTTagLongArray(value));
    }

    @Override
    public void setCompound(@NotNull String key, @NotNull FastNBTCompound fastNBTCompound) {
        checkTag(key);
        super.setCompound(key, fastNBTCompound);
        applyChanges(key, () -> ((FastNBTCompoundImpl) fastNBTCompound).nbtTagCompound);
    }

    @Override
    public void setList(@NotNull String key, @NotNull FastNBTList<?> fastNBTList) {
        checkTag(key);
        super.setList(key, fastNBTList);
        applyChanges(key, () -> ((FastNBTListImpl<?>) fastNBTList).nbtTagList);
    }

    @Override
    public void setItemStack(@NotNull String key, @NotNull ItemStack itemStack) {
        checkTag(key);
        super.setItemStack(key, itemStack);
        applyChanges(key, () -> NMSFastNBTUtils.asCompound(itemStack));
    }

    private void checkTag(@NotNull String key) {
        if (applyToMeta && FORBIDDEN_TAGS.contains(key)) {
            throw new IllegalStateException("Cannot change tag \"%s\" because it must be changed in ItemMeta".formatted(key));
        }
    }

    private void applyChanges(@NotNull String key, @NotNull Supplier<NBTBase> initializer) {
        if (applyToMeta) {
            itemMetaUnhandledTags.put(key, initializer.get());
        }
    }
}
