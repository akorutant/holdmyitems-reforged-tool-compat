package de.bene2212.holdmyitemsnf.mixin;

import de.bene2212.holdmyitemsnf.config.HoldMyItemsClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @ModifyConstant(method = "getCurrentSwingDuration()I", constant = @Constant(intValue = 6))
    private int modifySwingDuration(int original) {
        return Minecraft.getInstance().player == (Object) this
                ? HoldMyItemsClientConfig.SWING_SPEED.get()
                : original;
    }
}
