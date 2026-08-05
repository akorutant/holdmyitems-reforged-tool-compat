/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.color.block.BlockColors
 *  net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
 *  net.minecraft.client.renderer.ItemBlockRenderTypes
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.block.BlockModelShaper
 *  net.minecraft.client.renderer.block.BlockRenderDispatcher
 *  net.minecraft.client.renderer.block.model.BakedQuad
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.resources.model.BakedModel
 *  net.minecraft.core.Direction
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 */
package de.bene2212.holdmyitemsnf.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.bene2212.holdmyitemsnf.interfaces.AlternateBlockRenderer;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={BlockRenderDispatcher.class})
public abstract class BlockRenderManagerMixin
implements AlternateBlockRenderer {
    @Final
    @Shadow
    private BlockColors blockColors;
    @Final
    @Shadow
    private BlockModelShaper blockModelShaper;
    @Shadow
    @Final
    private BlockEntityWithoutLevelRenderer blockEntityRenderer;

    @Shadow
    public abstract BakedModel getBlockModel(BlockState var1);

    @Override
    @Unique
    public void renderSingleBlockEmission(BlockState state, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (state.getRenderShape() == RenderShape.INVISIBLE) {
            return;
        }
        BlockRenderDispatcher dispatcher = (BlockRenderDispatcher)(Object)this;
        BakedModel model = dispatcher.getBlockModel(state);
        int tint = this.blockColors.getColor(state, null, null, 0);
        float r = (float)(tint >> 16 & 0xFF) / 255.0f;
        float g = (float)(tint >> 8 & 0xFF) / 255.0f;
        float b = (float)(tint & 0xFF) / 255.0f;
        RandomSource random = RandomSource.create((long)42L);
        for (Direction dir : Direction.values()) {
            for (BakedQuad quad : model.getQuads(state, dir, random)) {
                this.renderQuad(quad, poseStack, buffer, r, g, b, packedLight, state);
            }
        }
        for (BakedQuad quad : model.getQuads(state, null, random)) {
            this.renderQuad(quad, poseStack, buffer, r, g, b, packedLight, state);
        }
    }

    private void renderQuad(BakedQuad quad, PoseStack poseStack, MultiBufferSource buffer, float r, float g, float b, int light, BlockState state) {
        if (quad.isTinted()) {
            r = Math.max(0.0f, Math.min(1.0f, r));
            g = Math.max(0.0f, Math.min(1.0f, g));
            b = Math.max(0.0f, Math.min(1.0f, b));
        } else {
            b = 1.0f;
            g = 1.0f;
            r = 1.0f;
        }
        RenderType renderType = quad.isShade() ? ItemBlockRenderTypes.getRenderType((BlockState)state, (boolean)false) : ItemBlockRenderTypes.getRenderType((BlockState)state, (boolean)true);
        VertexConsumer consumer = buffer.getBuffer(renderType);
        consumer.putBulkData(poseStack.last(), quad, r, g, b, 1.0f, light, OverlayTexture.NO_OVERLAY);
    }
}
