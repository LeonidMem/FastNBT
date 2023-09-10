package ru.leonidm.fastnbt;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.utils.FastNBTLinker;
import ru.leonidm.fastnbt.utils.FastNBTUtils;

import java.util.Objects;

public final class FastNBT extends JavaPlugin {

    private static FastNBT instance;

    @NotNull
    public static FastNBT getInstance() {
        return Objects.requireNonNull(instance, "Not initialized yet");
    }

    @Override
    public void onEnable() {
        instance = this;

        try {
            FastNBTLinker.linkAll();

            getLogger().info("Enabled!");
        } catch (Exception e) {
            getSLF4JLogger().error("Your version of CraftBukkit {} is not supported! Disabling plugin...",
                    FastNBTUtils.getBukkitVersion());

            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled!");
    }
}
