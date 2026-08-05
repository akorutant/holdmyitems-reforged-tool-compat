/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.renderer.blockentity.BellRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package de.bene2212.holdmyitemsnf.mixin;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.blockentity.BellRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={BellRenderer.class})
public interface BellBlockModelAccessor {
    @Accessor(value="bellBody")
    public ModelPart getBellBody();
}
