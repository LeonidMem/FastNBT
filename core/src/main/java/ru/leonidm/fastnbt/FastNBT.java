package ru.leonidm.fastnbt;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.leonidm.fastnbt.test.TestListener;
import ru.leonidm.fastnbt.utils.FastNBTLinker;

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

        FastNBTLinker.linkAll();

        Bukkit.getPluginManager().registerEvents(new TestListener(), this);

        getLogger().info("Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled!");
    }
}
