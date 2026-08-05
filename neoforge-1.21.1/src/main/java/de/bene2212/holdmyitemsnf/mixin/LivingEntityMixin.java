/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.world.entity.LivingEntity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.Constant
 *  org.spongepowered.asm.mixin.injection.ModifyConstant
 */
package de.bene2212.holdmyitemsnf.mixin;

import de.bene2212.holdmyitemsnf.config.HoldMyItemsClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@OnlyIn(value=Dist.CLIENT)
@Mixin(value={LivingEntity.class})
public class LivingEntityMixin {
    @ModifyConstant(method={"getCurrentSwingDuration()I"}, constant={@Constant(intValue=6)})
    private int modifySwingDuration(int original) {
        return Minecraft.getInstance().player == (Object)this ? (Integer)HoldMyItemsClientConfig.SWING_SPEED.get() : original;
    }
}
