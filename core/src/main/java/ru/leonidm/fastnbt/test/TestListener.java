package ru.leonidm.fastnbt.test;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.api.FastNBTItem;
import ru.leonidm.fastnbt.api.FastNBTType;
import ru.leonidm.fastnbt.utils.FastNBTUtils;

public final class TestListener implements Listener {

    @EventHandler
    public void onInventoryClick(@NotNull InventoryClickEvent e) {
        if (e.getClick() == ClickType.DROP) {
            ItemStack itemStack = e.getCurrentItem();
            if (itemStack != null) {
                FastNBTItem fastNBTItem = FastNBTItem.read(itemStack);
                System.out.println("[TestListener:19] " + fastNBTItem.getKeys());
                System.out.println("[TestListener:20] " + fastNBTItem.getInt("CustomModelData"));
            }
            e.setCancelled(true);
        } else if (e.getClick() == ClickType.CONTROL_DROP) {
            ItemStack itemStack = e.getCurrentItem();
            if (itemStack != null) {
                FastNBTItem fastNBTItem1 = FastNBTItem.write(itemStack, true);
                fastNBTItem1.setInt("Counter", fastNBTItem1.getInt("Counter") + 1);

                FastNBTItem fastNBTItem2 = FastNBTItem.read(itemStack);
                e.getWhoClicked().sendMessage("[2.1] Counter: " + fastNBTItem2.getInt("Counter"));

                if (fastNBTItem2.contains("display", FastNBTType.COMPOUND)) {
                    var compound = fastNBTItem2.getCompound("display");
                    e.getWhoClicked().sendMessage("[2.2] " + (compound == FastNBTUtils.unmodifiableCompound(compound)));
                }

                FastNBTItem fastNBTItem3 = FastNBTItem.read(new ItemStack(itemStack));
                e.getWhoClicked().sendMessage("[3.1] Counter: " + fastNBTItem3.getInt("Counter"));
                e.getWhoClicked().sendMessage("[3.2] CustomModelData: " + fastNBTItem3.getInt("CustomModelData"));

                FastNBTItem fastNBTItem4 = FastNBTItem.write(new ItemStack(itemStack), true);
                fastNBTItem4.setItemStack("SomeItem", itemStack);
                e.getWhoClicked().sendMessage("[4.1] " + fastNBTItem4.getItemStack("SomeItem"));
                e.getWhoClicked().sendMessage("[4.2] " + fastNBTItem4.getOrigin());
                fastNBTItem4.setInt("CustomModelData", fastNBTItem4.getInt("CustomModelData") + 1);
                e.getWhoClicked().sendMessage("[4.3] " + fastNBTItem4.getOrigin());
            }
            e.setCancelled(true);
        }
    }
}
