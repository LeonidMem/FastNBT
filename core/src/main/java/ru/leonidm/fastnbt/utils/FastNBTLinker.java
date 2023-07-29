package ru.leonidm.fastnbt.utils;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class FastNBTLinker {

    private static FastEntityFactory fastEntityFactory;

    private FastNBTLinker() {

    }

    @SneakyThrows
    public static void linkAll() {
        String bukkitPackageName = Bukkit.getServer().getClass().getPackage().getName();
        String version = bukkitPackageName.substring(bukkitPackageName.lastIndexOf(46) + 1);
        String packageName = "ru.leonidm.fastnbt.impl." + version + ".";

        Class<? extends FastEntityFactory> factoryClass = Class.forName(packageName + "FastEntityFactoryImpl")
                .asSubclass(FastEntityFactory.class);
        fastEntityFactory = factoryClass.getConstructor().newInstance();
    }

    @NotNull
    public static FastEntityFactory getFactory() {
        return Objects.requireNonNull(fastEntityFactory, "Not initialized yet");
    }
}
