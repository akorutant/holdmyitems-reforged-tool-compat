/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.client.model.AxolotlModel
 *  net.minecraft.client.model.geom.ModelPart
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package de.bene2212.holdmyitemsnf.mixin;

import net.minecraft.client.model.AxolotlModel;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={AxolotlModel.class})
public interface AxolotlModelAccessor {
    @Accessor(value="head")
    public ModelPart getHead();

    @Accessor(value="leftFrontLeg")
    public ModelPart getLeftLeg();

    @Accessor(value="rightFrontLeg")
    public ModelPart getRightLeg();

    @Accessor(value="tail")
    public ModelPart getTail();

    @Accessor(value="leftHindLeg")
    public ModelPart getLeftLegB();

    @Accessor(value="rightHindLeg")
    public ModelPart getRightLegB();
}
