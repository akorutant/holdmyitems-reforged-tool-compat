/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.world.level.block.state.BlockState
 */
package de.bene2212.holdmyitemsnf.interfaces;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.level.block.state.BlockState;

public interface AlternateBlockRenderer {
    public void renderSingleBlockEmission(BlockState var1, PoseStack var2, MultiBufferSource var3, int var4);
}
