package ru.leonidm.fastnbt.utils;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class FastNBTLinker {

    private static FastEntityFactory fastEntityFactory;

    private FastNBTLinker() {

    }

    @SneakyThrows
    public static void linkAll() {
        String version = FastNBTUtils.getBukkitVersion();
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
