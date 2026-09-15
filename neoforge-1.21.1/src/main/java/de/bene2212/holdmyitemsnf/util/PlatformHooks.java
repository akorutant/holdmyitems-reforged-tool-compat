package de.bene2212.holdmyitemsnf.util;

import net.minecraft.world.entity.Entity;

public final class PlatformHooks {
    private PlatformHooks() {
    }

    public static boolean isInFluid(Entity entity) {
        return entity.isInFluidType();
    }
}
