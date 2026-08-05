/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.SkullModelBase
 *  net.minecraft.client.model.geom.EntityModelSet
 *  net.minecraft.client.renderer.blockentity.SkullBlockRenderer
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.component.ResolvableProfile
 *  net.minecraft.world.level.block.SkullBlock$Type
 */
package de.bene2212.holdmyitemsnf.util;

import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.SkullBlock;

public class SkullHelper {
    public static Map<SkullBlock.Type, SkullModelBase> SKULL_MODELS;

    public static void init(EntityModelSet modelSet) {
        SKULL_MODELS = SkullBlockRenderer.createSkullRenderers((EntityModelSet)modelSet);
    }

    @Nullable
    public static ResolvableProfile getSkullOwner(ItemStack stack) {
        ResolvableProfile profileComponent = (ResolvableProfile)stack.get(DataComponents.PROFILE);
        return profileComponent;
    }
}
