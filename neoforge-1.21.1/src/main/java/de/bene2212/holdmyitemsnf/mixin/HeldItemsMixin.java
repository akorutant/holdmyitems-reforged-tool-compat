/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.AxolotlModel
 *  net.minecraft.client.model.SkullModelBase
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.player.AbstractClientPlayer
 *  net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
 *  net.minecraft.client.renderer.ItemInHandRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.block.BlockRenderDispatcher
 *  net.minecraft.client.renderer.blockentity.SkullBlockRenderer
 *  net.minecraft.client.renderer.entity.AxolotlRenderer
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.animal.axolotl.Axolotl
 *  net.minecraft.world.entity.animal.axolotl.Axolotl$Variant
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.AxeItem
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.BucketItem
 *  net.minecraft.world.item.CrossbowItem
 *  net.minecraft.world.item.FishingRodItem
 *  net.minecraft.world.item.HoeItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.LingeringPotionItem
 *  net.minecraft.world.item.MapItem
 *  net.minecraft.world.item.MilkBucketItem
 *  net.minecraft.world.item.ShovelItem
 *  net.minecraft.world.item.SplashPotionItem
 *  net.minecraft.world.item.SwordItem
 *  net.minecraft.world.item.UseAnim
 *  net.minecraft.world.item.component.CustomData
 *  net.minecraft.world.item.component.ItemAttributeModifiers
 *  net.minecraft.world.item.component.ItemAttributeModifiers$Entry
 *  net.minecraft.world.item.component.ResolvableProfile
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BedBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.CampfireBlock
 *  net.minecraft.world.level.block.ChestBlock
 *  net.minecraft.world.level.block.ComparatorBlock
 *  net.minecraft.world.level.block.EnderChestBlock
 *  net.minecraft.world.level.block.RedstoneTorchBlock
 *  net.minecraft.world.level.block.RepeaterBlock
 *  net.minecraft.world.level.block.ShulkerBoxBlock
 *  net.minecraft.world.level.block.SkullBlock
 *  net.minecraft.world.level.block.SkullBlock$Type
 *  net.minecraft.world.level.block.SkullBlock$Types
 *  net.minecraft.world.level.block.entity.BellBlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.piston.PistonBaseBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.AttachFace
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.PistonType
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package de.bene2212.holdmyitemsnf.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import de.bene2212.holdmyitemsnf.Holdmyitemsnf;
import de.bene2212.holdmyitemsnf.config.HoldMyItemsClientConfig;
import de.bene2212.holdmyitemsnf.interfaces.AlternateBlockRenderer;
import de.bene2212.holdmyitemsnf.mixin.AxolotlModelAccessor;
import de.bene2212.holdmyitemsnf.mixin.ItemRendererAccessor;
import de.bene2212.holdmyitemsnf.util.HoldMyItemsTags;
import de.bene2212.holdmyitemsnf.util.PlatformHooks;
import de.bene2212.holdmyitemsnf.util.RenderHelper;
import de.bene2212.holdmyitemsnf.util.SkullHelper;
import de.bene2212.holdmyitemsnf.util.ToolCompatibility;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.AxolotlModel;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.entity.AxolotlRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.LingeringPotionItem;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SplashPotionItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.level.block.EnderChestBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BellBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.PistonType;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ItemInHandRenderer.class})
public abstract class HeldItemsMixin {
    float brush_counter = 0.0f;
    private float pistonCount = 0.0f;
    private boolean repPower = false;
    private float prevAge = 0.0f;
    private double previousRotation = 0.0;
    private float swingAngleY = 0.0f;
    private float swingAngleX = 0.0f;
    private float swingVelocityY = 0.0f;
    private float swingVelocityX = 0.0f;
    private float swingVelocityZ = 0.0f;
    private float vertAngleY = 0.0f;
    private final float vertVelocityY = 0.0f;
    private float vertVelocityYSlime = 0.0f;
    private float vertAngleYSlime = 0.0f;
    private float riptideCounter = 0.0f;
    private float netherCounter = 0.0f;
    private float headFallCount = 0.0f;
    private static final float SOUND_TRIGGER_THRESHOLD = 13.5f;
    private static final float SOUND_COOLDOWN = 14.5f;
    private float soundCooldownTimer = 0.0f;
    private float globalAnimationCounter = 0.0f;
    private float equipProgressMainHand;
    private float fallCounter = 0.0f;
    private boolean useItemPrev = false;
    private float inWaterCounter = 0.0f;
    private final float inspect = 0.0f;
    private final float tilt = 0.0f;
    private float freezeCounter = 0.0f;
    private float clCount = 0.0f;
    private float crawlCount = 0.0f;
    private float directionalCrawlCount = 0.0f;
    private float climbCount = 0.0f;
    private final float mouseHolding = 1.0f;
    private final boolean isSwinging = false;
    private final float swingProgress = 0.0f;
    private final boolean isForward = false;
    private boolean isAttacking = false;
    private boolean left = false;
    private float itemSwitchCountO = 0.0f;
    private float swingAngleYPrev = 0.0f;
    private boolean itemSwitchedEventO = false;
    private float itemSwitchCount = 0.0f;
    private boolean itemSwitchedEvent = false;
    private ItemStack prevItemM = ItemStack.EMPTY;
    private ItemStack prevItemO = ItemStack.EMPTY;
    private boolean wasSubmerged = false;
    private boolean lastOnGroundState = false;
    private float inspectCounter = 0.0f;
    private float inspectSpinCounter = 0.0f;
    private boolean isNearRedstonePrev = false;
    private boolean isCrouchingPrev = false;
    private float shieldCounterO = 0.0f;
    private float shieldCounter = 0.0f;
    private boolean shieldEvent = false;
    private boolean shieldEventO = false;
    @Shadow
    private ItemStack offHandItem;
    @Shadow
    @Final
    private ItemRenderer itemRenderer;
    @Shadow
    @Final
    private Minecraft minecraft;

    private float easeInOutBack(float x) {
        float c1 = 1.70158f;
        float c2 = c1 * 1.525f;
        return (float)((double)x < 0.5 ? Math.pow(2.0f * x, 2.0) * (double)((c2 + 1.0f) * 2.0f * x - c2) / 2.0 : (Math.pow(2.0f * x - 2.0f, 2.0) * (double)((c2 + 1.0f) * (x * 2.0f - 2.0f) + c2) + 2.0) / 2.0);
    }

    private float getAttackDamage(ItemStack stack) {
        float totalDamage = 0.0f;
        ItemAttributeModifiers modifiers = (ItemAttributeModifiers)stack.get(DataComponents.ATTRIBUTE_MODIFIERS);
        if (modifiers == null) {
            return totalDamage;
        }
        for (ItemAttributeModifiers.Entry entry : modifiers.modifiers()) {
            if (!entry.attribute().equals((Object)Attributes.ATTACK_DAMAGE)) continue;
            totalDamage += (float)entry.modifier().amount();
        }
        return totalDamage;
    }

    private boolean isNearRedstoneBlock(Player player) {
        BlockPos standingPos = BlockPos.containing((double)player.getX(), (double)(player.getY() - 0.1), (double)player.getZ());
        BlockState standingBlock = player.level().getBlockState(standingPos);
        return standingBlock.is(Blocks.REDSTONE_BLOCK);
    }

    private float test(float x) {
        return x < 0.5f ? 8.0f * x * x * x * x : (float)(1.0 - Math.pow(-2.0f * x + 2.0f, 4.0) / 2.0);
    }

    private void swingArm(float swingProgress, float equipProgress, PoseStack matrices, int armX, HumanoidArm arm) {
        float f = -0.4f * Mth.sin((float)(Mth.sqrt((float)swingProgress) * (float)Math.PI));
        float g = 0.2f * Mth.sin((float)(Mth.sqrt((float)swingProgress) * ((float)Math.PI * 2)));
        float h = -0.2f * Mth.sin((float)(swingProgress * (float)Math.PI));
        matrices.translate((float)armX * f, g, h);
        this.applyItemArmTransform(matrices, arm, equipProgress);
        this.applyItemArmAttackTransform(matrices, arm, swingProgress);
    }

    private void altSwing(PoseStack matrices, HumanoidArm arm, float swingProgress) {
        int direction = arm == HumanoidArm.RIGHT ? 1 : -1;
        float swingSin = Mth.sin((float)(swingProgress * (float)Math.PI));
        matrices.mulPose(Axis.YP.rotationDegrees((float)direction * (45.0f + swingSin * 0.0f)));
        matrices.mulPose(Axis.YP.rotationDegrees((float)direction * -45.0f));
    }

    @Shadow
    private void renderPlayerArm(PoseStack pPoseStack, MultiBufferSource pBuffer, int pCombinedLight, float pEquippedProgress, float pSwingProgress, HumanoidArm pSide) {
    }

    @Shadow
    private void applyItemArmTransform(PoseStack pPoseStack, HumanoidArm pHand, float pEquippedProg) {
    }

    @Shadow
    private void applyItemArmAttackTransform(PoseStack pPoseStack, HumanoidArm pHand, float pSwingProgress) {
    }

    @Shadow
    public abstract void renderItem(LivingEntity var1, ItemStack var2, ItemDisplayContext var3, boolean var4, PoseStack var5, MultiBufferSource var6, int var7);

    @Shadow
    protected abstract void renderTwoHandedMap(PoseStack var1, MultiBufferSource var2, int var3, float var4, float var5, float var6);

    @Shadow
    protected abstract void renderOneHandedMap(PoseStack var1, MultiBufferSource var2, int var3, float var4, HumanoidArm var5, float var6, ItemStack var7);

    /*
     * Enabled aggressive block sorting
     */
    @Inject(method={"renderArmWithItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderArmWithItem(AbstractClientPlayer p, float partialTicks, float pitch, InteractionHand hand, float swingProgress, ItemStack stack, float equipProgress, PoseStack poseStack, MultiBufferSource buffer, int light, CallbackInfo ci) {
        block264: {
            int l;
            boolean bl2;
            block282: {
                HumanoidArm arm;
                boolean bl;
                block284: {
                    block283: {
                        block281: {
                            float jn;
                            float swing;
                            float swing_rot;
                            float switchItemsO;
                            float switchItems;
                            double tt;
                            ResourceLocation itemId;
                            Item item;
                            block277: {
                                block280: {
                                    BlockRenderDispatcher blockRenderManager;
                                    block278: {
                                        BlockState blockState;
                                        float pitchDelta;
                                        block279: {
                                            double currentSpeed;
                                            block275: {
                                                block273: {
                                                    float dt;
                                                    block276: {
                                                        block274: {
                                                            float g;
                                                            float h5;
                                                            float j1;
                                                            double s;
                                                            block272: {
                                                                float jn2;
                                                                int i;
                                                                block271: {
                                                                    block270: {
                                                                        float ll;
                                                                        float al;
                                                                        double crossProduct;
                                                                        double dotProduct;
                                                                        float kj;
                                                                        block263: {
                                                                            block265: {
                                                                                block269: {
                                                                                    block266: {
                                                                                        block267: {
                                                                                            block268: {
                                                                                                String fullId;
                                                                                                String namespace;
                                                                                                boolean isUsingSandpaper;
                                                                                                if (p.getMainHandItem().getItem().toString().contains("sand_paper") && p.isUsingItem()) {
                                                                                                    if (p.getUsedItemHand() == InteractionHand.MAIN_HAND) return;
                                                                                                }
                                                                                                if (p.getOffhandItem().getItem().toString().contains("sand_paper") && p.isUsingItem() && p.getUsedItemHand() == InteractionHand.OFF_HAND) {
                                                                                                    return;
                                                                                                }
                                                                                                boolean bl3 = isUsingSandpaper = false;
                                                                                                if (isUsingSandpaper) {
                                                                                                    return;
                                                                                                }
                                                                                                if (!(((Boolean)HoldMyItemsClientConfig.ENABLE_PUNCHING.get()).booleanValue() || !stack.isEmpty() || p.isSwimming() || p.isVisuallyCrawling() || p.onClimbable())) {
                                                                                                    return;
                                                                                                }
                                                                                                item = stack.getItem();
                                                                                                itemId = BuiltInRegistries.ITEM.getKey(item);
                                                                                                Item mainHandItem = p.getMainHandItem().getItem();
                                                                                                ResourceLocation mainHandId = BuiltInRegistries.ITEM.getKey(mainHandItem);
                                                                                                List blockedMods = (List)HoldMyItemsClientConfig.MOD_IDS_TO_EXCLUDE.get();
                                                                                                List blockedItems = (List)HoldMyItemsClientConfig.ITEM_IDS_TO_EXCLUDE.get();
                                                                                                if (itemId != null) {
                                                                                                    namespace = itemId.getNamespace().toLowerCase();
                                                                                                    fullId = itemId.toString().toLowerCase();
                                                                                                    if (blockedMods.contains(namespace)) return;
                                                                                                    if (blockedItems.contains(fullId)) {
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                if (mainHandId != null) {
                                                                                                    namespace = mainHandId.getNamespace().toLowerCase();
                                                                                                    fullId = mainHandId.toString().toLowerCase();
                                                                                                    if (blockedMods.contains(namespace)) return;
                                                                                                    if (blockedItems.contains(fullId)) {
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                tt = Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0;
                                                                                                bl = hand == InteractionHand.MAIN_HAND;
                                                                                                arm = bl ? p.getMainArm() : p.getMainArm().getOpposite();
                                                                                                kj = bl ? 1.0f : -1.0f;
                                                                                                poseStack.pushPose();
                                                                                                poseStack.pushPose();
                                                                                                poseStack.translate((Double)HoldMyItemsClientConfig.VIEWMODEL_X_OFFSET.get() * (double)kj, ((Double)HoldMyItemsClientConfig.VIEWMODEL_Y_OFFSET.get()).doubleValue(), ((Double)HoldMyItemsClientConfig.VIEWMODEL_Z_OFFSET.get()).doubleValue());
                                                                                                if (p.getMainHandItem().getItem() != this.prevItemM.getItem()) {
                                                                                                    this.itemSwitchedEvent = true;
                                                                                                    this.itemSwitchCount = 0.0f;
                                                                                                    p.playSound((SoundEvent)SoundEvents.ARMOR_EQUIP_LEATHER.value(), 0.2f, 1.4f);
                                                                                                }
                                                                                                if (this.useItemPrev != p.isUsingItem() && !p.isUsingItem() && p.getMainHandItem().getUseAnimation() == UseAnim.BLOCK) {
                                                                                                    this.shieldEvent = true;
                                                                                                }
                                                                                                if (this.useItemPrev != p.isUsingItem() && !p.isUsingItem() && p.getOffhandItem().getUseAnimation() == UseAnim.BLOCK) {
                                                                                                    this.shieldEventO = true;
                                                                                                }
                                                                                                if (this.shieldEvent && this.shieldCounter == 0.0f) {
                                                                                                    this.shieldCounter = 1.0f;
                                                                                                }
                                                                                                if (this.shieldCounter < 0.0f) {
                                                                                                    this.shieldCounter = 0.0f;
                                                                                                    this.shieldEvent = false;
                                                                                                }
                                                                                                if (this.shieldEvent) {
                                                                                                    this.shieldCounter = (float)((double)this.shieldCounter - 0.1 * tt);
                                                                                                }
                                                                                                if (this.shieldEventO && this.shieldCounterO == 0.0f) {
                                                                                                    this.shieldCounterO = 1.0f;
                                                                                                }
                                                                                                if (this.shieldCounterO < 0.0f) {
                                                                                                    this.shieldCounterO = 0.0f;
                                                                                                    this.shieldEventO = false;
                                                                                                }
                                                                                                if (this.shieldEventO) {
                                                                                                    this.shieldCounterO = (float)((double)this.shieldCounterO - 0.1 * tt);
                                                                                                }
                                                                                                if (this.useItemPrev != p.isUsingItem() && !p.isUsingItem() && (stack.getUseAnimation() == UseAnim.SPEAR || stack.getUseAnimation() == UseAnim.BOW) && bl) {
                                                                                                    this.itemSwitchedEvent = true;
                                                                                                    this.itemSwitchCount = 0.0f;
                                                                                                }
                                                                                                if (!(this.useItemPrev == p.isUsingItem() || p.isUsingItem() || p.getOffhandItem().getUseAnimation() != UseAnim.SPEAR && p.getOffhandItem().getUseAnimation() != UseAnim.BOW || bl)) {
                                                                                                    this.itemSwitchedEventO = true;
                                                                                                    this.itemSwitchCountO = 0.0f;
                                                                                                }
                                                                                                if (this.itemSwitchedEvent) {
                                                                                                    this.itemSwitchCount = (float)((double)this.itemSwitchCount + (Double)HoldMyItemsClientConfig.SWITCH_SPEED.get() * tt);
                                                                                                }
                                                                                                if (this.itemSwitchCount > 1.0f) {
                                                                                                    this.itemSwitchCount = 1.0f;
                                                                                                    this.itemSwitchedEvent = false;
                                                                                                }
                                                                                                if (this.itemSwitchCount < 1.0f) {
                                                                                                    equipProgress = 0.0f;
                                                                                                }
                                                                                                if (p.getOffhandItem().getItem() != this.prevItemO.getItem()) {
                                                                                                    this.itemSwitchedEventO = true;
                                                                                                    this.itemSwitchCountO = 0.0f;
                                                                                                }
                                                                                                if (this.itemSwitchedEventO) {
                                                                                                    this.itemSwitchCountO = (float)((double)this.itemSwitchCountO + (Double)HoldMyItemsClientConfig.SWITCH_SPEED.get() * tt);
                                                                                                }
                                                                                                if (this.itemSwitchCountO > 1.0f) {
                                                                                                    this.itemSwitchCountO = 1.0f;
                                                                                                    this.itemSwitchedEventO = false;
                                                                                                }
                                                                                                if (p.isScoping()) return;
                                                                                                float yaw = p.getYRot();
                                                                                                double radians = Math.toRadians(yaw);
                                                                                                double forwardX = -Math.sin(radians);
                                                                                                double forwardZ = Math.cos(radians);
                                                                                                Vec3 horizontalVelocity = p.getDeltaMovement();
                                                                                                dotProduct = horizontalVelocity.x * forwardX + horizontalVelocity.z * forwardZ;
                                                                                                crossProduct = p.getDeltaMovement().x * forwardZ - horizontalVelocity.z * forwardX;
                                                                                                al = p.getXRot() != 0.0f ? 90.0f / p.getXRot() / 10.0f : 1.0f;
                                                                                                if (al > 1.0f) {
                                                                                                    al = 1.0f;
                                                                                                }
                                                                                                if (al < 0.0f) {
                                                                                                    al = 1.0f;
                                                                                                }
                                                                                                if (!p.isUsingItem() && bl && Holdmyitemsnf.CUSTOM_KEY.isDown() && ToolCompatibility.canInspect(stack, this.getAttackDamage(stack))) {
                                                                                                    this.inspectCounter = (float)((double)this.inspectCounter + 0.1 * tt);
                                                                                                    if (this.inspectCounter > 1.0f) {
                                                                                                        this.inspectCounter = 1.0f;
                                                                                                    }
                                                                                                } else if (bl && !Holdmyitemsnf.CUSTOM_KEY.isDown()) {
                                                                                                    this.inspectCounter = (float)((double)this.inspectCounter - 0.15 * tt);
                                                                                                    if (this.inspectCounter < 0.0f) {
                                                                                                        this.inspectCounter = 0.0f;
                                                                                                    }
                                                                                                }
                                                                                                this.inspectSpinCounter = this.inspectCounter == 1.0f ? (float)((double)this.inspectSpinCounter + 0.022 * tt) : 0.0f;
                                                                                                if (this.inspectSpinCounter > 1.0f) {
                                                                                                    this.inspectSpinCounter = 1.0f;
                                                                                                }
                                                                                                this.easeInOutBack(this.inspectSpinCounter);
                                                                                                if (bl) {
                                                                                                    if (p.getMainArm() == HumanoidArm.LEFT && Holdmyitemsnf.CUSTOM_KEY.isDown() && this.inspectCounter > 0.0f) {
                                                                                                        bl = !bl;
                                                                                                    }
                                                                                                    switchItems = bl ? 1.0f : -1.0f;
                                                                                                    poseStack.translate(0.7 * (double)this.easeInOutBack(this.inspectCounter) * (double)switchItems, 0.0, 0.0);
                                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-7.0f * Mth.sin((float)(this.easeInOutBack(this.inspectSpinCounter) * 6.28f)) * switchItems));
                                                                                                    poseStack.mulPose(Axis.YP.rotationDegrees(50.0f * this.easeInOutBack(this.inspectCounter) * switchItems));
                                                                                                }
                                                                                                this.globalAnimationCounter = (float)((double)this.globalAnimationCounter + 0.1 * tt);
                                                                                                this.headFallCount = p.getDeltaMovement().y() < -0.54 ? (float)((double)this.headFallCount + 0.1 * tt) : 0.0f;
                                                                                                switchItems = Mth.sin((float)(Mth.clamp((float)this.itemSwitchCount, (float)0.0f, (float)0.5f) * 3.14f));
                                                                                                float switch_fast = Mth.sin((float)(Mth.clamp((float)this.itemSwitchCount, (float)0.0f, (float)0.125f) * 12.56f));
                                                                                                switchItemsO = Mth.sin((float)(Mth.clamp((float)this.itemSwitchCountO, (float)0.0f, (float)0.5f) * 3.14f));
                                                                                                float switch_fastO = Mth.sin((float)(Mth.clamp((float)this.itemSwitchCountO, (float)0.0f, (float)0.125f) * 12.56f));
                                                                                                if (bl) {
                                                                                                    switchItems = this.easeInOutBack(switchItems);
                                                                                                    poseStack.translate((double)(0.0f * switch_fast), -0.75 * (double)switch_fast, 0.15 * (double)switch_fast);
                                                                                                    poseStack.mulPose(Axis.ZP.rotationDegrees(63.0f * switch_fast));
                                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(30.0f * switch_fast));
                                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-30.0f * switchItems));
                                                                                                    poseStack.mulPose(Axis.ZP.rotationDegrees(-63.0f * switchItems));
                                                                                                    poseStack.translate((double)(0.0f * switchItems), 0.75 * (double)switchItems, -0.2 * (double)switchItems);
                                                                                                } else {
                                                                                                    switchItemsO = this.easeInOutBack(switchItemsO);
                                                                                                    poseStack.translate((double)(0.0f * switch_fastO), -0.75 * (double)switch_fastO, 0.15 * (double)switch_fastO);
                                                                                                    poseStack.mulPose(Axis.ZP.rotationDegrees(-63.0f * switch_fastO));
                                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(30.0f * switch_fastO));
                                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-30.0f * switchItemsO));
                                                                                                    poseStack.mulPose(Axis.ZP.rotationDegrees(63.0f * switchItemsO));
                                                                                                    poseStack.translate((double)(0.0f * switchItemsO), 0.75 * (double)switchItemsO, -0.2 * (double)switchItemsO);
                                                                                                }
                                                                                                float swing_global = Mth.sin((float)(Mth.clamp((float)swingProgress, (float)0.4f, (float)1.0f) * 3.14f * 5.0f));
                                                                                                swing_rot = (double)swingProgress < 0.6 ? Mth.sin((float)(Mth.clamp((float)swingProgress, (float)0.0f, (float)0.12506f) * 12.56f)) : Mth.sin((float)(Mth.clamp((float)swingProgress, (float)0.62532f, (float)0.75038f) * 12.56f));
                                                                                                swing = Mth.sin((float)(swingProgress * 3.14f));
                                                                                                swing = this.easeInOutBack(swing);
                                                                                                if ((stack.getUseAnimation() == UseAnim.SPEAR && p.isUsingItem() || stack.is(Items.EXPERIENCE_BOTTLE) || stack.is(Items.WIND_CHARGE) || stack.is(Items.EGG) || stack.is(Items.ENDER_EYE) || stack.is(Items.SNOWBALL) || stack.is(Items.ENDER_PEARL) || stack.getItem() instanceof SplashPotionItem || stack.getItem() instanceof LingeringPotionItem) && p.getOffhandItem().isEmpty() && !stack.is(Items.FIRE_CHARGE) && !p.isSwimming() && !p.isVisuallyCrawling() && !p.onClimbable()) {
                                                                                                    if (p.getMainArm() == HumanoidArm.LEFT) {
                                                                                                        bl = !bl;
                                                                                                    }
                                                                                                    ll = bl ? 1.0f : -1.0f;
                                                                                                    poseStack.pushPose();
                                                                                                    poseStack.translate(-0.15 * (double)ll, 0.2, -0.25);
                                                                                                    poseStack.mulPose(Axis.YP.rotationDegrees(-25.0f * ll));
                                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-25.0f));
                                                                                                    poseStack.mulPose(Axis.YP.rotationDegrees(25.0f * ll * swing));
                                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(30.0f * swing));
                                                                                                    poseStack.translate(-0.15 * (double)ll, 0.1, 0.1);
                                                                                                    poseStack.translate(0.0, -0.55 * (double)swing, 0.4 * (double)swing * (double)3.14f);
                                                                                                    this.renderPlayerArm(poseStack, buffer, light, equipProgress, 0.0f, arm.getOpposite());
                                                                                                    poseStack.popPose();
                                                                                                }
                                                                                                if (Minecraft.getInstance().options.keyAttack.isDown() && !this.isAttacking && (double)swingProgress == 0.0) {
                                                                                                    boolean bl4 = this.left = !this.left;
                                                                                                }
                                                                                                if (stack.isEmpty()) break block265;
                                                                                                if (p.getMainArm() == HumanoidArm.LEFT) {
                                                                                                    bl = !bl;
                                                                                                }
                                                                                                float f = ll = bl ? 1.0f : -1.0f;
                                                                                                if (!this.left && !(stack.getItem() instanceof AxeItem) && stack.getUseAnimation() != UseAnim.SPEAR && stack.getUseAnimation() != UseAnim.BLOCK || stack.getItem() instanceof ShovelItem) break block266;
                                                                                                if (stack.getItem() instanceof SwordItem || stack.getItem() instanceof AxeItem) break block267;
                                                                                                if (stack.getUseAnimation() != UseAnim.SPEAR) break block268;
                                                                                                poseStack.translate(0.0, 0.0, 0.45 * (double)swing_rot);
                                                                                                poseStack.translate(-0.25 * (double)kj * (double)swing, -0.35 * (double)swing_rot, -0.6 * (double)swing);
                                                                                                poseStack.translate(0.0, 0.1 * (double)swing, 0.0);
                                                                                                poseStack.mulPose(Axis.YP.rotationDegrees(15.0f * swing_rot * ll));
                                                                                                poseStack.mulPose(Axis.ZP.rotationDegrees(30.0f * swing_rot * ll));
                                                                                                break block263;
                                                                                            }
                                                                                            if (stack.is(HoldMyItemsTags.TOOLS) && stack.getUseAnimation() != UseAnim.BLOCK && !(stack.getItem() instanceof ShovelItem)) {
                                                                                                poseStack.translate(0.1 * (double)ll * (double)swing_rot, 0.1 * (double)swing_rot, -0.5 * (double)swing);
                                                                                                poseStack.mulPose(Axis.XN.rotationDegrees(-30.0f * swing_rot));
                                                                                                poseStack.mulPose(Axis.ZP.rotationDegrees(-20.0f * swing_rot * ll));
                                                                                                poseStack.mulPose(Axis.XN.rotationDegrees(40.0f * swing));
                                                                                                break block263;
                                                                                            } else if (stack.getUseAnimation() != UseAnim.BLOCK) {
                                                                                                poseStack.translate(0.1 * (double)ll * (double)swing_rot, 0.1 * (double)swing_rot, -0.1 * (double)swing);
                                                                                                poseStack.mulPose(Axis.XN.rotationDegrees(-30.0f * swing_rot));
                                                                                                poseStack.mulPose(Axis.ZP.rotationDegrees(-10.0f * swing_rot * ll));
                                                                                                poseStack.mulPose(Axis.XN.rotationDegrees(40.0f * swing));
                                                                                                poseStack.mulPose(Axis.YP.rotationDegrees(10.0f * swing * ll));
                                                                                                break block263;
                                                                                            } else {
                                                                                                poseStack.translate(0.1 * (double)ll * (double)swing_rot, 0.1 * (double)swing_rot, -0.2 * (double)swing);
                                                                                                poseStack.mulPose(Axis.XN.rotationDegrees(-10.0f * swing_rot));
                                                                                                poseStack.mulPose(Axis.ZP.rotationDegrees(-10.0f * swing_rot * ll));
                                                                                                poseStack.mulPose(Axis.XN.rotationDegrees(20.0f * swing));
                                                                                            }
                                                                                            break block263;
                                                                                        }
                                                                                        poseStack.translate(0.8 * (double)ll * (double)swing_rot, 0.3 * (double)swing_rot, -0.5 * (double)swing);
                                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(15.0f * swing_rot * ll));
                                                                                        poseStack.mulPose(Axis.XN.rotationDegrees(-20.0f * swing_rot));
                                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees(-70.0f * swing_rot * ll));
                                                                                        if (stack.getItem() instanceof SwordItem) {
                                                                                            poseStack.mulPose(Axis.XN.rotationDegrees(40.0f * swing));
                                                                                            break block263;
                                                                                        } else {
                                                                                            poseStack.mulPose(Axis.XN.rotationDegrees(30.0f * swing));
                                                                                        }
                                                                                        break block263;
                                                                                    }
                                                                                    if (stack.getItem() instanceof ShovelItem) break block269;
                                                                                    if (stack.getItem() instanceof SwordItem) {
                                                                                        poseStack.translate(-0.55 * (double)ll * (double)swing_rot, -0.8 * (double)swing_rot, -0.77 * (double)swing);
                                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(5.0f * swing_rot * ll));
                                                                                        poseStack.mulPose(Axis.XN.rotationDegrees(-30.0f * swing_rot));
                                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees(70.0f * swing_rot * ll));
                                                                                        poseStack.mulPose(Axis.XN.rotationDegrees(50.0f * swing));
                                                                                        break block263;
                                                                                    } else if (stack.is(HoldMyItemsTags.TOOLS) && !(stack.getItem() instanceof ShovelItem)) {
                                                                                        poseStack.translate(0.1 * (double)ll * (double)swing_rot, 0.1 * (double)swing_rot, -0.5 * (double)swing);
                                                                                        poseStack.mulPose(Axis.XN.rotationDegrees(-30.0f * swing_rot));
                                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees(-20.0f * swing_rot * ll));
                                                                                        poseStack.mulPose(Axis.XN.rotationDegrees(40.0f * swing));
                                                                                        break block263;
                                                                                    } else {
                                                                                        poseStack.translate(0.1 * (double)ll * (double)swing_rot, 0.1 * (double)swing_rot, -0.1 * (double)swing);
                                                                                        poseStack.mulPose(Axis.XN.rotationDegrees(-30.0f * swing_rot));
                                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees(-10.0f * swing_rot * ll));
                                                                                        poseStack.mulPose(Axis.XN.rotationDegrees(40.0f * swing));
                                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(10.0f * swing * ll));
                                                                                    }
                                                                                    break block263;
                                                                                }
                                                                                if (stack.getItem() instanceof ShovelItem) {
                                                                                    poseStack.translate(0.0, 0.15 * (double)swing_rot, -0.25 * (double)swing_rot);
                                                                                    poseStack.translate(0.0, 0.0, -0.2 * (double)swing);
                                                                                    poseStack.mulPose(Axis.YP.rotationDegrees(15.0f * swing_rot));
                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-35.0f * swing_rot));
                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(30.0f * swing));
                                                                                }
                                                                                break block263;
                                                                            }
                                                                            if (!(Block.byItem((Item)stack.getItem()) == Blocks.AIR || stack.is(HoldMyItemsTags.TOOLS) && !stack.is(ItemTags.TRIMMABLE_ARMOR) && !stack.is(ItemTags.BOOKSHELF_BOOKS) && stack.getUseAnimation() != UseAnim.EAT || stack.getUseAnimation() == UseAnim.BOW || stack.getUseAnimation() == UseAnim.SPYGLASS || this.getAttackDamage(stack) != 0.0f || stack.getUseAnimation() == UseAnim.BLOCK || stack.is(Items.WARPED_FUNGUS_ON_A_STICK) || stack.is(Items.CARROT_ON_A_STICK) || stack.getItem() instanceof FishingRodItem || stack.is(Items.SHEARS))) {
                                                                                if ((swingProgress = (float)((double)swingProgress * 1.2)) > 1.0f) {
                                                                                    swingProgress = 0.0f;
                                                                                }
                                                                            } else if (!(stack.getItem() instanceof ShovelItem) && (swingProgress = (float)((double)swingProgress * 1.5)) > 1.0f) {
                                                                                swingProgress = 0.0f;
                                                                            }
                                                                        }
                                                                        if (p.getDeltaMovement().length() >= 0.08) {
                                                                            this.crawlCount = (float)((double)this.crawlCount + 0.1 * p.getDeltaMovement().length() * 2.0 * tt);
                                                                            this.directionalCrawlCount = (float)((double)this.directionalCrawlCount + 0.1 * dotProduct * 4.0 * tt);
                                                                            this.directionalCrawlCount = (float)((double)this.directionalCrawlCount + (dotProduct > 0.0 ? 0.1 * Math.abs(crossProduct) * 4.0 * tt : 0.1 * Math.abs(crossProduct) * -1.0 * 4.0 * tt));
                                                                        }
                                                                        if (p.getDeltaMovement().y() > 0.0) {
                                                                            this.climbCount = (float)((double)this.climbCount + 0.1 * tt);
                                                                        }
                                                                        if (p.getDeltaMovement().y() < 0.0) {
                                                                            this.climbCount = (float)((double)this.climbCount - 0.1 * tt);
                                                                        }
                                                                        if ((p.isVisuallyCrawling() && ((Boolean)HoldMyItemsClientConfig.ENABLE_CLIMB_AND_CRAWL.get()).booleanValue() || p.onClimbable() && !p.isCrouching() && !p.onGround() && Math.abs(p.getDeltaMovement().y()) > 0.0 && ((Boolean)HoldMyItemsClientConfig.ENABLE_CLIMB_AND_CRAWL.get()).booleanValue()) && !p.isUsingItem() && swingProgress == 0.0f) {
                                                                            this.clCount = (float)((double)this.clCount + 0.1 * tt);
                                                                            if (this.clCount > 1.0f) {
                                                                                this.clCount = 1.0f;
                                                                            }
                                                                            if (!stack.is(Items.LANTERN) && !stack.is(Items.SOUL_LANTERN)) {
                                                                                poseStack.mulPose(Axis.XP.rotationDegrees(-20.0f * this.clCount));
                                                                            }
                                                                        } else {
                                                                            this.clCount = (float)((double)this.clCount * Math.pow(0.88f, tt));
                                                                        }
                                                                        if (swingProgress == 0.0f) {
                                                                            poseStack.translate(bl ? p.getXRot() / 650.0f * this.clCount * -1.0f : p.getXRot() / 650.0f * this.clCount, 0.0f, 0.0f);
                                                                            poseStack.mulPose(Axis.XP.rotationDegrees(p.getXRot() * this.clCount));
                                                                        }
                                                                        if (!stack.is(Items.LANTERN) && !stack.is(Items.SOUL_LANTERN)) {
                                                                            poseStack.translate(0.0f, 0.0f, p.getXRot() / 120.0f * this.clCount);
                                                                        } else if (swingProgress == 0.0f) {
                                                                            poseStack.translate(0.0f, 0.0f, p.getXRot() / 80.0f * this.clCount);
                                                                        }
                                                                        if (!(!p.onClimbable() || p.isCrouching() || !((Boolean)HoldMyItemsClientConfig.ENABLE_CLIMB_AND_CRAWL.get()).booleanValue() || p.onGround() || stack.is(Items.LANTERN) || stack.is(Items.SOUL_LANTERN) || p.isUsingItem())) {
                                                                            poseStack.translate(0.0, 0.1, -0.2);
                                                                        }
                                                                        if ((PlatformHooks.isInFluid(p) || p.isInPowderSnow) && !p.isSwimming() && !p.isUnderWater()) {
                                                                            this.inWaterCounter = (float)((double)this.inWaterCounter + 0.1 * tt);
                                                                            if (this.inWaterCounter >= 1.0f) {
                                                                                this.inWaterCounter = 1.0f;
                                                                            }
                                                                        } else {
                                                                            this.inWaterCounter = (float)((double)this.inWaterCounter * Math.pow(0.88f, tt));
                                                                        }
                                                                        boolean holdingMap = p.getMainHandItem().getItem() instanceof MapItem || p.getOffhandItem().getItem() instanceof MapItem;
                                                                        double mapRenderProgress = holdingMap ? 1.0 : 0.0;
                                                                        this.freezeCounter = p.isInPowderSnow && mapRenderProgress > 0.1 ? (float)((double)this.freezeCounter + 0.1 * tt) : (float)((double)this.freezeCounter * Math.pow(0.88f, tt));
                                                                        poseStack.translate(0.0, 0.02 * (double)this.inWaterCounter, 0.0);
                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees(8.0f * kj * this.inWaterCounter));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(0.3f * Mth.sin((float)(this.freezeCounter * 5.0f))));
                                                                        if (p.getDeltaMovement().y() < -0.85 && stack.is(Items.MACE) && p.getMainHandItem() == stack) {
                                                                            this.fallCounter = (float)((double)this.fallCounter + 0.1 * tt);
                                                                            if (this.fallCounter >= 1.0f) {
                                                                                this.fallCounter = 1.0f;
                                                                            }
                                                                        } else {
                                                                            this.fallCounter = (float)((double)this.fallCounter * Math.pow(0.88f, tt));
                                                                        }
                                                                        if (bl) {
                                                                            poseStack.mulPose(Axis.XP.rotationDegrees(45.0f * this.fallCounter));
                                                                            poseStack.translate(0.0, -0.2 * (double)this.fallCounter, 0.0);
                                                                        }
                                                                        this.vertAngleY = (float)((double)this.vertAngleY + p.getDeltaMovement().y() * (double)0.015f * tt);
                                                                        this.vertAngleY = (float)((double)this.vertAngleY - (double)(0.1f * this.vertAngleY) * tt);
                                                                        this.vertAngleY = (float)((double)this.vertAngleY * Math.pow(0.88f, tt));
                                                                        this.vertVelocityYSlime = (float)((double)this.vertVelocityYSlime + p.getDeltaMovement().y() * (double)0.015f * tt);
                                                                        this.vertVelocityYSlime = (float)((double)this.vertVelocityYSlime - (double)(0.1f * this.vertAngleYSlime) * tt);
                                                                        this.vertVelocityYSlime = (float)((double)this.vertVelocityYSlime * Math.pow(0.88f, tt));
                                                                        this.vertAngleYSlime = (float)((double)this.vertAngleYSlime + (double)this.vertVelocityYSlime * tt);
                                                                        this.vertAngleYSlime = (float)Mth.clamp((double)this.vertAngleYSlime, (double)-0.3, (double)255.0);
                                                                        poseStack.translate(0.0f, this.vertAngleY * -1.0f, 0.0f);
                                                                        poseStack.translate(0.0, Math.sin((double)p.tickCount * 0.1) * 0.007 * (double)kj, 0.0);
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(0.15f * Mth.sin((float)((float)p.tickCount * 0.15f)) * kj));
                                                                        if (!stack.isEmpty() || p.isVisuallyCrawling() || p.onClimbable() && !p.isCrouching() && !p.onGround() || p.isSwimming()) {
                                                                            if (p.getMainArm() == HumanoidArm.LEFT) {
                                                                                boolean bl5 = bl = !bl;
                                                                            }
                                                                            if (stack.getUseAnimation() == UseAnim.BLOCK) {
                                                                                poseStack.translate(0.0f, 0.0f, 0.0f);
                                                                            } else {
                                                                                poseStack.translate(0.0, -0.1, 0.1);
                                                                            }
                                                                        }
                                                                        if (stack.is(Items.LANTERN) || stack.is(Items.SOUL_LANTERN) || stack.is(ItemTags.HANGING_SIGNS)) {
                                                                            poseStack.translate(0.0, 0.1, 0.0);
                                                                            if (p.isSwimming()) {
                                                                                poseStack.translate(0.0, -0.1, 0.1);
                                                                            }
                                                                        }
                                                                        if (p.isSwimming() && swingProgress == 0.0f && ((Boolean)HoldMyItemsClientConfig.ENABLE_SWIMMING_ANIM.get()).booleanValue()) {
                                                                            double a;
                                                                            s = this.crawlCount;
                                                                            double swingAmplitude = 1.5;
                                                                            double frequency = 2.0;
                                                                            double handRotation = Math.sin(s *= frequency) * swingAmplitude;
                                                                            double smoothRotation = handRotation * 0.8 + this.previousRotation * 0.2;
                                                                            poseStack.mulPose(Axis.YP.rotationDegrees((float)(bl ? smoothRotation : -smoothRotation)));
                                                                            poseStack.translate(0.0, 0.0, smoothRotation * (double)0.2f);
                                                                            currentSpeed = this.crawlCount * 2.0f;
                                                                            double b = a = Math.cos(currentSpeed);
                                                                            if (a <= 0.0) {
                                                                                b = a * 0.5;
                                                                            }
                                                                            poseStack.mulPose(Axis.YN.rotationDegrees((float)(bl ? b * 30.0 : b * 30.0 * -1.0)));
                                                                            poseStack.translate(0.0, 0.0, a * (double)0.2f);
                                                                            if (stack.isEmpty() && !bl && !p.isInvisible()) {
                                                                                j1 = bl ? 1.0f : -1.0f;
                                                                                poseStack.translate((double)j1, 0.0 - (double)equipProgress * 0.3, 0.3);
                                                                                poseStack.mulPose(Axis.YP.rotationDegrees(45.0f * j1));
                                                                                poseStack.mulPose(Axis.ZP.rotationDegrees(-40.0f * j1));
                                                                                poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                                this.altSwing(poseStack, arm, swingProgress);
                                                                                h5 = Mth.sin((float)(equipProgress * 3.14f));
                                                                                poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                                this.renderPlayerArm(poseStack, buffer, light, 0.0f, 0.0f, arm);
                                                                                ci.cancel();
                                                                            }
                                                                            this.previousRotation = smoothRotation;
                                                                        }
                                                                        if ((p.onClimbable() && !p.isCrouching() && !p.onGround() || p.isVisuallyCrawling() && swingProgress == 0.0f) && !p.isUsingItem()) {
                                                                            float j;
                                                                            s = this.climbCount;
                                                                            g = (float)p.getDeltaMovement().y();
                                                                            float h = Mth.cos((float)((float)s * 2.0f));
                                                                            float f = j = bl ? 1.0f : -1.0f;
                                                                            if (p.onClimbable()) {
                                                                                if (!stack.is(Items.LANTERN) && !stack.is(Items.SOUL_LANTERN)) {
                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(20.0f * h * j));
                                                                                } else {
                                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(1.0f * h * j));
                                                                                }
                                                                            }
                                                                            if (p.isVisuallyCrawling() && !p.isUsingItem() && swingProgress == 0.0f) {
                                                                                float l2 = Mth.sin((float)(this.directionalCrawlCount * 4.0f * 1.0f));
                                                                                dt = Mth.cos((float)(this.directionalCrawlCount * 4.0f * 1.0f));
                                                                                if (stack.is(Items.LANTERN) || stack.is(Items.SOUL_LANTERN)) {
                                                                                    l2 *= 0.14f;
                                                                                    dt *= 0.14f;
                                                                                }
                                                                                poseStack.translate(0.2 * (double)l2, 0.3 * (double)l2 * (double)j, -0.2 * (double)l2 * (double)j * (double)al);
                                                                                poseStack.mulPose(Axis.YP.rotationDegrees(25.0f * l2));
                                                                                poseStack.mulPose(Axis.XP.rotationDegrees(Mth.clamp((float)(20.0f * dt * j), (float)0.0f, (float)20.0f)));
                                                                            }
                                                                            if (stack.isEmpty() && !bl && !p.isInvisible() && (!p.onGround() && !p.isCrouching() && p.onClimbable() || p.isVisuallyCrawling())) {
                                                                                float l3 = bl ? 1.0f : -1.0f;
                                                                                poseStack.translate((double)l3, 0.0 - (double)equipProgress * 0.3, 0.3);
                                                                                poseStack.mulPose(Axis.YP.rotationDegrees(45.0f * l3));
                                                                                poseStack.mulPose(Axis.ZP.rotationDegrees(-40.0f * l3));
                                                                                poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                                this.altSwing(poseStack, arm, swingProgress);
                                                                                poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                                this.renderPlayerArm(poseStack, buffer, light, 0.0f, 0.0f, arm);
                                                                                ci.cancel();
                                                                            }
                                                                        }
                                                                        if (!stack.isEmpty()) break block270;
                                                                        if (bl && !p.isInvisible()) {
                                                                            if (!(!p.onGround() && p.onClimbable() || p.isSwimming() || p.isVisuallyCrawling())) {
                                                                                if (p.getMainArm() == HumanoidArm.LEFT) {
                                                                                    bl = !bl;
                                                                                }
                                                                                ll = bl ? 1.0f : -1.0f;
                                                                                poseStack.translate(0.0, 0.2 * (double)swing_rot, 0.15 * (double)swing_rot);
                                                                                poseStack.translate(0.1 * (double)ll * (double)swing, 0.15 * (double)swing, -0.45 * (double)swing);
                                                                                poseStack.mulPose(Axis.YP.rotationDegrees(35.0f * swing * ll));
                                                                                poseStack.mulPose(Axis.XP.rotationDegrees(-30.0f * swing));
                                                                                poseStack.mulPose(Axis.YP.rotationDegrees(-10.0f * swing_rot * ll));
                                                                                poseStack.mulPose(Axis.XP.rotationDegrees(10.0f * swing_rot));
                                                                                this.renderPlayerArm(poseStack, buffer, light, 0.0f, 0.0f, arm);
                                                                                ci.cancel();
                                                                                break block264;
                                                                            } else {
                                                                                ll = bl ? 1.0f : -1.0f;
                                                                                poseStack.translate((double)ll, 0.0 - (double)equipProgress * 0.3, 0.3);
                                                                                poseStack.mulPose(Axis.YP.rotationDegrees(45.0f * ll));
                                                                                poseStack.mulPose(Axis.ZP.rotationDegrees(-40.0f * ll));
                                                                                poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                                this.altSwing(poseStack, arm, swingProgress);
                                                                                float f = Mth.sin((float)(equipProgress * 3.14f));
                                                                                poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                                this.renderPlayerArm(poseStack, buffer, light, 0.0f, 0.0f, arm);
                                                                                ci.cancel();
                                                                            }
                                                                        }
                                                                        break block264;
                                                                    }
                                                                    if (!stack.has(DataComponents.MAP_ID)) break block271;
                                                                    if (bl && this.offHandItem.isEmpty()) {
                                                                        poseStack.translate(0.0, 0.1, 0.0);
                                                                        this.renderTwoHandedMap(poseStack, buffer, light, pitch, equipProgress, swingProgress);
                                                                        break block264;
                                                                    } else {
                                                                        poseStack.translate(bl ? -0.1 : 0.1, 0.1, 0.0);
                                                                        this.renderOneHandedMap(poseStack, buffer, light, equipProgress, arm, swingProgress, stack);
                                                                    }
                                                                    break block264;
                                                                }
                                                                if (stack.getUseAnimation() != UseAnim.CROSSBOW) break block272;
                                                                poseStack.pushPose();
                                                                if (p.getMainArm() == HumanoidArm.LEFT) {
                                                                    bl = !bl;
                                                                }
                                                                boolean bl22 = CrossbowItem.isCharged((ItemStack)stack);
                                                                boolean bl3 = arm == HumanoidArm.RIGHT;
                                                                int n = i = bl3 ? 1 : -1;
                                                                if (p.isUsingItem() && p.getUseItemRemainingTicks() > 0 && p.getUsedItemHand() == hand) {
                                                                    float f = (float)stack.getUseDuration((LivingEntity)p) - ((float)p.getUseItemRemainingTicks() - partialTicks + 1.0f);
                                                                    g = f / (float)CrossbowItem.getChargeDuration((ItemStack)stack, (LivingEntity)p);
                                                                    if (g > 1.0f) {
                                                                        g = 1.0f;
                                                                    }
                                                                    if (g > 0.1f) {
                                                                        float h = Mth.sin((float)((f - 0.1f) * 1.3f));
                                                                        float j = g - 0.1f;
                                                                        jn2 = h * j;
                                                                        poseStack.translate(jn2 * 0.0f, jn2 * 0.004f, jn2 * 0.0f);
                                                                    }
                                                                    this.applyItemArmTransform(poseStack, arm, equipProgress);
                                                                    jn2 = this.easeInOutBack(Mth.clamp((float)(g * 3.0f), (float)0.0f, (float)1.0f));
                                                                    poseStack.translate((float)i * -0.4785682f * jn2, -0.24387f * jn2, 0.05731531f * jn2);
                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-11.935f * jn2));
                                                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)i * 65.3f * jn2));
                                                                    poseStack.mulPose(Axis.ZP.rotationDegrees((float)i * 9.785f * jn2));
                                                                    poseStack.translate(g * 0.0f, g * 0.0f, g * 0.04f);
                                                                    poseStack.scale(1.0f, 1.0f, 1.0f);
                                                                    poseStack.mulPose(Axis.YN.rotationDegrees((float)i * 45.0f));
                                                                } else {
                                                                    this.swingArm(swingProgress, equipProgress, poseStack, i, arm);
                                                                    if (bl22 && swingProgress < 0.001f && bl) {
                                                                        poseStack.translate((float)i * -0.341864f, 0.0f, 0.0f);
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)i * 10.0f));
                                                                    }
                                                                }
                                                                jn2 = bl ? 1.0f : -1.0f;
                                                                poseStack.translate(0.0f, 0.0f, -1.0f);
                                                                poseStack.translate(-0.45 * (double)i, 0.45, 1.7);
                                                                poseStack.translate((double)(1.0f * jn2), 0.0 - (double)equipProgress * 0.3, 0.3);
                                                                poseStack.mulPose(Axis.YP.rotationDegrees(45.0f * jn2));
                                                                poseStack.mulPose(Axis.ZP.rotationDegrees(-40.0f * jn2));
                                                                poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                this.altSwing(poseStack, arm, swingProgress);
                                                                float breathe = Mth.sin((float)(equipProgress * 3.14f));
                                                                poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                this.renderPlayerArm(poseStack, buffer, light, 0.0f, 0.0f, arm);
                                                                poseStack.translate(-0.25 * (double)i, 1.25, 0.05);
                                                                poseStack.mulPose(Axis.YP.rotationDegrees((float)(-90 * i)));
                                                                poseStack.mulPose(Axis.XP.rotationDegrees(77.0f));
                                                                poseStack.mulPose(Axis.ZP.rotationDegrees((float)(85 * i)));
                                                                poseStack.scale(1.2f, 1.2f, 1.2f);
                                                                poseStack.mulPose(Axis.XP.rotationDegrees(-10.0f));
                                                                poseStack.translate(0.0, -0.15, 0.15);
                                                                this.renderItem((LivingEntity)p, stack, bl3 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl, poseStack, buffer, light);
                                                                poseStack.popPose();
                                                                ci.cancel();
                                                                if (p.isUsingItem() && p.getUseItemRemainingTicks() > 0 && p.getUsedItemHand() == hand) {
                                                                    float f = (float)stack.getUseDuration((LivingEntity)p) - ((float)p.getUseItemRemainingTicks() - partialTicks + 1.0f);
                                                                    g = f / (float)CrossbowItem.getChargeDuration((ItemStack)stack, (LivingEntity)p);
                                                                    if (g > 1.0f) {
                                                                        g = 1.0f;
                                                                    }
                                                                    if (g > 0.1f) {
                                                                        float h = Mth.sin((float)((f - 0.1f) * 1.3f));
                                                                        float j = g - 0.1f;
                                                                        float yawDelta = h * j;
                                                                        poseStack.translate(yawDelta * 0.0f, yawDelta * 0.004f, yawDelta * 0.0f);
                                                                    }
                                                                    poseStack.mulPose(Axis.YN.rotationDegrees((double)g <= 0.2 ? 75.0f * g * 5.0f * (float)i : (float)(75 * i)));
                                                                    poseStack.mulPose(Axis.XN.rotationDegrees(10.0f * g * 1.5f));
                                                                    poseStack.translate(-0.37 * (double)i, 0.05, 0.6);
                                                                    poseStack.translate(0.15 * (double)g * (double)i, 0.0, 0.0);
                                                                    this.renderPlayerArm(poseStack, buffer, light, equipProgress, swingProgress, arm.getOpposite());
                                                                    ci.cancel();
                                                                }
                                                                break block264;
                                                            }
                                                            bl2 = arm == HumanoidArm.RIGHT;
                                                            int n = l = bl2 ? 1 : -1;
                                                            if (p.isUsingItem() && p.getUseItemRemainingTicks() > 0 && p.getUsedItemHand() == hand) {
                                                                switch (stack.getUseAnimation()) {
                                                                    case NONE: {
                                                                        this.applyItemArmTransform(poseStack, arm, equipProgress);
                                                                        break;
                                                                    }
                                                                    case EAT:
                                                                    case DRINK: {
                                                                        jn = (float)stack.getUseDuration((LivingEntity)p) - ((float)p.getUseItemRemainingTicks() - partialTicks + 1.0f);
                                                                        float breathe = jn / 5.0f;
                                                                        if (breathe > 1.0f) {
                                                                            breathe = 1.0f;
                                                                        }
                                                                        float yawDelta = Mth.sin((float)(jn / 2.0f * 3.14f));
                                                                        poseStack.translate((double)l, 0.1, 0.3);
                                                                        poseStack.translate((double)((float)(0 * l) * breathe), -0.7 * (double)breathe, -0.2 * (double)breathe);
                                                                        poseStack.translate(0.0, -0.2 * (double)(yawDelta /= 10.0f), -0.2 * (double)yawDelta);
                                                                        poseStack.translate(0.0, 0.1 * (double)this.easeInOutBack(Mth.sin((float)(breathe * 3.14f))), 0.0);
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(45 * l)));
                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(-40 * l)));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                        this.altSwing(poseStack, arm, swingProgress);
                                                                        pitchDelta = Mth.sin((float)(equipProgress * 3.14f));
                                                                        poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(45.0f * breathe * (float)l));
                                                                        this.renderPlayerArm(poseStack, buffer, light, 0.0f, swingProgress, arm);
                                                                        break;
                                                                    }
                                                                    case BLOCK: {
                                                                        float angularSpeed = (float)stack.getUseDuration((LivingEntity)p) - ((float)p.getUseItemRemainingTicks() - partialTicks + 1.0f);
                                                                        s = angularSpeed / 4.0f;
                                                                        float s2 = angularSpeed / 6.0f;
                                                                        if (s > 1.0) {
                                                                            s = 1.0;
                                                                        }
                                                                        if (s2 > 1.0f) {
                                                                            s2 = 1.0f;
                                                                        }
                                                                        poseStack.translate(0.0, -0.2, 0.0);
                                                                        poseStack.translate((double)l, 0.0, 0.3);
                                                                        poseStack.translate(0.37 * s * (double)l, 0.0, -1.1 * s);
                                                                        poseStack.translate(-0.2 * (double)l * (double)s2, 0.0, 0.0);
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees((float)(10.0 * Math.sin((double)s2 * 3.14))));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(70.0 * s * (double)l)));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(45 * l)));
                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(-40 * l)));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)((double)(5 * l) * s)));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees((float)(-10.0 * s)));
                                                                        poseStack.translate(0.0, 0.0, -0.2 * s);
                                                                        this.altSwing(poseStack, arm, swingProgress);
                                                                        poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                        this.renderPlayerArm(poseStack, buffer, light, 0.0f, swingProgress, arm);
                                                                        poseStack.translate(0.35 * (double)l, -0.13, -0.12);
                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees(10.0f * (float)l));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(10.0f * (float)l));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(0.0f));
                                                                        poseStack.translate(-0.2 * (double)l, -0.04, 0.15);
                                                                        poseStack.scale(1.0f, 1.0f, 1.0f);
                                                                        break;
                                                                    }
                                                                    case BOW: {
                                                                        float h1;
                                                                        float g1;
                                                                        if (p.getMainArm() == HumanoidArm.LEFT) {
                                                                            bl = !bl;
                                                                        }
                                                                        l = bl ? 1 : -1;
                                                                        float m1 = (float)stack.getUseDuration((LivingEntity)p) - ((float)p.getUseItemRemainingTicks() - partialTicks + 1.0f);
                                                                        float f1 = m1 / 15.0f;
                                                                        float f = (f1 * f1 + f1 * 2.0f) / 3.0f;
                                                                        if (f1 > 1.0f) {
                                                                            f1 = 1.0f;
                                                                        }
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(-30.0f));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(-15.0f));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(15.0f * this.easeInOutBack(Mth.clamp((float)(f1 * 2.0f), (float)0.0f, (float)1.0f))));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(30.0f * this.easeInOutBack(Mth.clamp((float)(f1 * 2.0f), (float)0.0f, (float)1.0f))));
                                                                        poseStack.pushPose();
                                                                        if (f1 > 0.1f) {
                                                                            g1 = Mth.sin((float)((m1 - 0.1f) * 1.3f));
                                                                            j1 = g1 * f1;
                                                                            poseStack.translate(j1 * 0.0f, j1 * 0.004f, j1 * 0.0f);
                                                                        }
                                                                        poseStack.translate(bl ? -0.1 : 0.1, 0.0, (double)f1 * 0.15);
                                                                        this.renderPlayerArm(poseStack, buffer, light, equipProgress, swingProgress, arm);
                                                                        poseStack.popPose();
                                                                        poseStack.translate(-1.03 * (double)l, 0.0, -0.97);
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(-65 * l)));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(-45 * l)));
                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(40 * l)));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                        this.altSwing(poseStack, arm, swingProgress);
                                                                        poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                        this.renderPlayerArm(poseStack, buffer, light, equipProgress, swingProgress, arm.getOpposite());
                                                                        poseStack.mulPose(Axis.YN.rotation(2.5f * (float)l));
                                                                        poseStack.translate(bl ? -0.65 : 0.65, -0.35, 0.27);
                                                                        if (f1 > 1.0f) {
                                                                            f1 = 1.0f;
                                                                        }
                                                                        poseStack.popPose();
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(-30.0f));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(-15.0f));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(15.0f * this.easeInOutBack(Mth.clamp((float)(f1 * 2.0f), (float)0.0f, (float)1.0f))));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(30.0f * this.easeInOutBack(Mth.clamp((float)(f1 * 2.0f), (float)0.0f, (float)1.0f))));
                                                                        if (((Boolean)HoldMyItemsClientConfig.MB3D_COMPAT.get()).booleanValue() && BuiltInRegistries.ITEM.getKey(stack.getItem()).getNamespace().equals("minecraft") && !(item instanceof BucketItem) && !(item instanceof MilkBucketItem) && !stack.is(Items.POWDER_SNOW_BUCKET)) {
                                                                            poseStack.mulPose(Axis.YP.rotationDegrees((float)(10 * l)));
                                                                        }
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(10 * l)));
                                                                        poseStack.mulPose(Axis.XN.rotationDegrees(75.0f));
                                                                        poseStack.mulPose(Axis.ZN.rotationDegrees((float)(-5 * l)));
                                                                        poseStack.translate(0.8 * (double)l, (double)(0.0f - equipProgress * 0.3f), -0.1);
                                                                        if (f > 0.1f) {
                                                                            g1 = Mth.sin((float)((m1 - 0.1f) * 1.3f));
                                                                            h1 = f1 - 0.1f;
                                                                            j1 = g1 * h1;
                                                                            poseStack.translate(j1 * 0.0f, j1 * 0.004f, j1 * 0.0f);
                                                                        }
                                                                        poseStack.pushPose();
                                                                        break;
                                                                    }
                                                                    case SPEAR: {
                                                                        dt = (float)stack.getUseDuration((LivingEntity)p) - ((float)p.getUseItemRemainingTicks() - partialTicks + 1.0f);
                                                                        float f = dt / 10.0f;
                                                                        if (f > 1.0f) {
                                                                            f = 1.0f;
                                                                        }
                                                                        if (f > 0.1f) {
                                                                            g = Mth.sin((float)((dt - 0.1f) * 1.3f));
                                                                            float h = f - 0.1f;
                                                                            float j = g * h;
                                                                            poseStack.translate(j * 0.0f, j * 0.004f, j * 0.0f);
                                                                        }
                                                                        float g1 = this.easeInOutBack(Mth.clamp((float)(f * 1.35f), (float)0.0f, (float)1.0f));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(45.0f * g1));
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(25 * l) * g1));
                                                                        poseStack.translate(0.2 * (double)g1 * (double)l, 0.0, 0.8 * (double)g1);
                                                                        this.renderPlayerArm(poseStack, buffer, light, equipProgress, swingProgress, arm);
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(135.0f));
                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(-65 * l)));
                                                                        poseStack.translate((double)(0.65f * (float)l), -1.0, -0.6);
                                                                        break;
                                                                    }
                                                                    case BRUSH: {
                                                                        float h1 = p.getUseItemRemainingTicks() % 10;
                                                                        j1 = h1 - partialTicks + 1.0f;
                                                                        h5 = 1.0f - j1 / 10.0f;
                                                                        float z = (float)stack.getUseDuration((LivingEntity)p) - ((float)p.getUseItemRemainingTicks() - partialTicks + 1.0f);
                                                                        float x = z / 6.0f;
                                                                        if (x > 1.0f) {
                                                                            x = 1.0f;
                                                                        }
                                                                        x = this.easeInOutBack(x);
                                                                        float sway = Mth.sin((float)(z / 2.5f));
                                                                        poseStack.translate(-0.1 * (double)sway * (double)l, 0.0, 0.0);
                                                                        poseStack.translate(0.06 * (double)x * (double)l, 0.1 * (double)x, 0.0);
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees(20.0f * x * (float)l));
                                                                        poseStack.translate(-0.1 * (double)sway * (double)l, -0.2 * (double)sway, 0.0);
                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees(20.0f * sway * (float)l));
                                                                        poseStack.translate((double)l, 0.0 - (double)equipProgress * 0.3, 0.3);
                                                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(45 * l)));
                                                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(-40 * l)));
                                                                        poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                        this.altSwing(poseStack, arm, swingProgress);
                                                                        poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                        this.renderPlayerArm(poseStack, buffer, light, equipProgress, swingProgress, arm);
                                                                        break;
                                                                    }
                                                                }
                                                            } else if (p.isAutoSpinAttack() && stack.getUseAnimation() == UseAnim.SPEAR) {
                                                                this.riptideCounter = (float)((double)this.riptideCounter + 0.15 * tt);
                                                                dt = (float)stack.getUseDuration((LivingEntity)p) - ((float)p.getUseItemRemainingTicks() - partialTicks + 1.0f);
                                                                float f = dt / 10.0f;
                                                                if (f > 1.0f) {
                                                                    f = 1.0f;
                                                                }
                                                                if (f > 0.1f) {
                                                                    g = Mth.sin((float)((dt - 0.1f) * 1.3f));
                                                                    float h = f - 0.1f;
                                                                    float j = g * h;
                                                                    poseStack.translate(j * 0.0f, j * 0.004f, j * 0.0f);
                                                                }
                                                                poseStack.mulPose(Axis.XP.rotationDegrees(45.0f - this.riptideCounter * 2.0f));
                                                                poseStack.mulPose(Axis.YP.rotationDegrees((float)(25 * l)));
                                                                poseStack.translate(0.2 * (double)l, 0.0, 0.75);
                                                                poseStack.translate(0.0, 0.0, 0.01 * (double)Mth.sin((float)(this.riptideCounter * 6.28f)));
                                                                this.renderPlayerArm(poseStack, buffer, light, equipProgress, swingProgress, arm);
                                                                poseStack.mulPose(Axis.XP.rotationDegrees(135.0f));
                                                                poseStack.mulPose(Axis.ZP.rotationDegrees((float)(-65 * l)));
                                                                poseStack.translate((double)(0.65f * (float)l), -1.0, -0.6);
                                                            } else {
                                                                this.riptideCounter = 0.0f;
                                                                if (bl) {
                                                                    dt = this.itemSwitchCount < 0.75038f ? Mth.sin((float)(Mth.clamp((float)this.itemSwitchCount, (float)0.0f, (float)0.25f) * 3.14f * 2.0f)) : Mth.sin((float)(Mth.clamp((float)this.itemSwitchCount, (float)0.75038f, (float)1.0f) * 3.14f * 4.0f)) * 1.2f;
                                                                } else {
                                                                    float f = dt = this.itemSwitchCountO < 0.75038f ? Mth.sin((float)(Mth.clamp((float)this.itemSwitchCountO, (float)0.0f, (float)0.25f) * 3.14f * 2.0f)) : Mth.sin((float)(Mth.clamp((float)this.itemSwitchCountO, (float)0.75038f, (float)1.0f) * 3.14f * 4.0f)) * 1.2f;
                                                                }
                                                                if (!(stack.is(Items.LANTERN) || stack.is(Items.SOUL_LANTERN) || stack.is(ItemTags.HANGING_SIGNS) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(HoldMyItemsTags.CHAINS) || stack.is(Items.BELL))) {
                                                                    if (stack.getUseAnimation() == UseAnim.BLOCK) {
                                                                        poseStack.translate(0.0, -0.2, 0.0);
                                                                    }
                                                                } else {
                                                                    poseStack.translate(0.1 * (double)l, 0.0, -0.1);
                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(10.0f));
                                                                }
                                                                if (item.getDescriptionId().contains("music_disc")) {
                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-5.0f * dt));
                                                                }
                                                                jn = this.shieldCounter;
                                                                float breathe = this.shieldCounter;
                                                                float yawDelta = this.shieldCounterO;
                                                                pitchDelta = this.shieldCounterO;
                                                                poseStack.translate((double)l, 0.0 - (double)equipProgress * 0.3, 0.3);
                                                                if (stack.getUseAnimation() == UseAnim.BLOCK && bl) {
                                                                    poseStack.translate(0.37 * (double)jn * (double)l, 0.0, -1.1 * (double)jn);
                                                                    poseStack.translate(-0.2 * (double)l * (double)breathe, 0.0, 0.0);
                                                                    poseStack.mulPose(Axis.XP.rotationDegrees((float)(10.0 * Math.sin((double)breathe * 3.14))));
                                                                    poseStack.mulPose(Axis.YP.rotationDegrees(70.0f * jn * (float)l));
                                                                } else if (stack.getUseAnimation() == UseAnim.BLOCK && !bl) {
                                                                    poseStack.translate(0.37 * (double)yawDelta * (double)l, 0.0, -1.1 * (double)yawDelta);
                                                                    poseStack.translate(-0.2 * (double)l * (double)pitchDelta, 0.0, 0.0);
                                                                    poseStack.mulPose(Axis.XP.rotationDegrees((float)(10.0 * Math.sin((double)pitchDelta * 3.14))));
                                                                    poseStack.mulPose(Axis.YP.rotationDegrees(70.0f * yawDelta * (float)l));
                                                                }
                                                                poseStack.mulPose(Axis.YP.rotationDegrees((float)(45 * l)));
                                                                poseStack.mulPose(Axis.ZP.rotationDegrees((float)(-40 * l)));
                                                                poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                                if (stack.getUseAnimation() == UseAnim.BLOCK && bl) {
                                                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(5 * l) * jn));
                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-10.0f * jn));
                                                                    poseStack.translate(0.0, 0.0, -0.2 * (double)jn);
                                                                } else if (stack.getUseAnimation() == UseAnim.BLOCK && !bl) {
                                                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(5 * l) * yawDelta));
                                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-10.0f * yawDelta));
                                                                    poseStack.translate(0.0, 0.0, -0.2 * (double)yawDelta);
                                                                }
                                                                this.altSwing(poseStack, arm, swingProgress);
                                                                poseStack.scale(0.9f, 0.9f, 0.9f);
                                                                this.renderPlayerArm(poseStack, buffer, light, 0.0f, 0.0f, arm);
                                                            }
                                                            poseStack.translate(-0.3 * (double)l, 0.65, -0.1);
                                                            poseStack.mulPose(Axis.YP.rotationDegrees((float)(-65 * l)));
                                                            poseStack.mulPose(Axis.XP.rotationDegrees(10.0f));
                                                            if (stack.is(ItemTags.WOOL_CARPETS)) {
                                                                poseStack.translate(0.2 * (double)l, -0.1, 0.0);
                                                            }
                                                            if (Block.byItem((Item)stack.getItem()) == Blocks.AIR || stack.getUseAnimation() == UseAnim.EAT || item instanceof BucketItem || item instanceof MilkBucketItem || stack.is(Items.POWDER_SNOW_BUCKET)) break block273;
                                                            if (!stack.getDisplayName().toString().toLowerCase().contains("TORCH".toLowerCase())) break block274;
                                                            if (!stack.is(Items.TORCHFLOWER)) {
                                                                poseStack.scale(1.5f, 1.5f, 1.5f);
                                                            }
                                                            poseStack.mulPose(Axis.YN.rotationDegrees((float)(25 * l)));
                                                            poseStack.mulPose(Axis.XP.rotationDegrees(5.0f));
                                                            poseStack.mulPose(Axis.ZP.rotationDegrees((float)(75 * l)));
                                                            poseStack.translate(0.16 * (double)l, 0.17, 0.05);
                                                            break block275;
                                                        }
                                                        if (!stack.is(Items.STRING) && !stack.is(Items.REDSTONE) && !stack.is(Items.LEVER) && !stack.is(Items.TRIPWIRE_HOOK) && !Block.byItem((Item)stack.getItem()).defaultBlockState().is(HoldMyItemsTags.GLASS_PANES) && !Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.RAILS) && !Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.CLIMBABLE) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.LEAVES) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.COMBINATION_STEP_SOUND_BLOCKS) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.BANNERS)) break block276;
                                                        poseStack.translate(0.0, 0.0, -0.1);
                                                        poseStack.mulPose(Axis.YN.rotationDegrees((float)(5 * l)));
                                                        poseStack.mulPose(Axis.XP.rotationDegrees(15.0f));
                                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(75 * l)));
                                                        break block275;
                                                    }
                                                    if (!(stack.is(Items.LANTERN) || stack.is(Items.SOUL_LANTERN) || stack.is(ItemTags.HANGING_SIGNS) || stack.is(Items.NETHER_STAR))) {
                                                        poseStack.mulPose(Axis.YN.rotationDegrees((float)(25 * l)));
                                                        poseStack.mulPose(Axis.XP.rotationDegrees(5.0f));
                                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(75 * l)));
                                                        poseStack.translate(0.2 * (double)l, 0.2, 0.05);
                                                        if (Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.BANNERS)) {
                                                            poseStack.translate(-0.2 * (double)l, 0.0, 0.0);
                                                            poseStack.scale(1.1f, 1.1f, 1.1f);
                                                        }
                                                        break block275;
                                                    } else {
                                                        dt = (float)(Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
                                                        jn = p.yRotO - p.getYRot();
                                                        float breathe = p.xRotO - p.getXRot();
                                                        this.swingVelocityY += jn * 0.015f * dt;
                                                        this.swingVelocityY += swingProgress * 2.0f * dt;
                                                        this.swingVelocityX += breathe * 0.015f * dt;
                                                        this.swingVelocityY -= 0.1f * this.swingAngleY * dt;
                                                        this.swingVelocityX -= 0.1f * this.swingAngleX * dt;
                                                        this.swingVelocityY = (float)((double)this.swingVelocityY * Math.pow(0.88f, dt));
                                                        this.swingVelocityX = (float)((double)this.swingVelocityX * Math.pow(0.88f, dt));
                                                        this.swingAngleY += this.swingVelocityY * dt;
                                                        this.swingAngleX += this.swingVelocityX * dt;
                                                        currentSpeed = p.getDeltaMovement().length();
                                                        this.swingVelocityZ = (float)((double)this.swingVelocityZ + (bl ? (currentSpeed * -1.0 * 15.0 - (double)this.swingVelocityZ) * (double)0.1f * (double)dt : (currentSpeed * 15.0 - (double)this.swingVelocityZ) * (double)0.1f * (double)dt));
                                                        if ((currentSpeed > 0.09 && p.onGround() || p.isSwimming() || p.onClimbable() && !p.isCrouching() && !p.onGround()) && ((Boolean)Minecraft.getInstance().options.bobView().get()).booleanValue()) {
                                                            Random random = new Random();
                                                            boolean randomBoolean = random.nextBoolean();
                                                            this.swingVelocityY += (float)(randomBoolean ? -5.5 * currentSpeed * (double)dt : 5.5 * currentSpeed * (double)dt);
                                                        }
                                                        if (!stack.is(Items.NETHER_STAR)) {
                                                            poseStack.translate(0.0, 0.0, -0.1);
                                                            poseStack.mulPose(Axis.YN.rotationDegrees((float)(35 * l) + this.swingAngleY));
                                                            poseStack.mulPose(Axis.XP.rotationDegrees(15.0f + this.swingAngleX));
                                                            poseStack.mulPose(Axis.ZP.rotationDegrees((float)(75 * l) + this.swingVelocityZ));
                                                            if (stack.is(ItemTags.HANGING_SIGNS) && !((Boolean)HoldMyItemsClientConfig.MB3D_COMPAT.get()).booleanValue()) {
                                                                poseStack.translate(-0.25 * (double)l, -0.4, 0.25);
                                                                poseStack.mulPose(Axis.YP.rotationDegrees((float)(40 * l)));
                                                                poseStack.mulPose(Axis.XP.rotationDegrees(30.0f));
                                                            } else if (stack.is(ItemTags.HANGING_SIGNS) && ((Boolean)HoldMyItemsClientConfig.MB3D_COMPAT.get()).booleanValue()) {
                                                                poseStack.translate(-0.1 * (double)l, 0.0, 0.0);
                                                            }
                                                            poseStack.translate(0.3 * (double)l, -0.35, 0.0);
                                                            poseStack.translate(0.0, 0.0, 0.1);
                                                            poseStack.scale(1.5f, 1.5f, 1.5f);
                                                        }
                                                    }
                                                    break block275;
                                                }
                                                if (!(stack.is(HoldMyItemsTags.TOOLS) && !stack.is(ItemTags.TRIMMABLE_ARMOR) && !stack.is(ItemTags.BOOKSHELF_BOOKS) && stack.getUseAnimation() != UseAnim.EAT || stack.getUseAnimation() == UseAnim.BOW || stack.getUseAnimation() == UseAnim.SPYGLASS || this.getAttackDamage(stack) != 0.0f || stack.getUseAnimation() == UseAnim.BLOCK || stack.is(Items.WARPED_FUNGUS_ON_A_STICK) || stack.is(Items.CARROT_ON_A_STICK) || stack.getItem() instanceof FishingRodItem || stack.is(Items.SHEARS) || stack.getItem() instanceof HoeItem || ((Boolean)HoldMyItemsClientConfig.MB3D_COMPAT.get()).booleanValue() && !(item instanceof BucketItem) && !(item instanceof MilkBucketItem) && !stack.is(Items.POWDER_SNOW_BUCKET))) {
                                                    if (stack.getUseAnimation() == UseAnim.BRUSH) {
                                                        poseStack.mulPose(Axis.XN.rotationDegrees(25.0f));
                                                        poseStack.translate(bl ? 0.0 : 0.35, bl ? 0.0 : 0.25, bl ? 0.0 : 0.37);
                                                        if (!bl) {
                                                            poseStack.scale(0.75f, 0.75f, 0.75f);
                                                        }
                                                        poseStack.mulPose(Axis.ZN.rotationDegrees((float)(-75 * l)));
                                                        poseStack.mulPose(Axis.XN.rotationDegrees(35.0f));
                                                        poseStack.translate(bl ? -0.05 : 0.85, bl ? 0.0 : 0.05, bl ? 0.08 : -0.2);
                                                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30.0f * Mth.clamp((float)this.brush_counter, (float)0.0f, (float)1.0f)));
                                                        poseStack.mulPose(Axis.XP.rotationDegrees(-15.0f * Mth.sin((float)this.brush_counter)));
                                                    } else {
                                                        poseStack.mulPose(Axis.YN.rotationDegrees((float)(5 * l)));
                                                        poseStack.mulPose(Axis.XP.rotationDegrees(15.0f));
                                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(75 * l)));
                                                        poseStack.translate(0.0, -0.05, -0.1);
                                                        poseStack.scale(0.7f, 0.7f, 0.7f);
                                                    }
                                                    if (stack.is(Items.FEATHER) || stack.is(Items.SLIME_BALL) || stack.is(Items.PUFFERFISH)) {
                                                        this.vertVelocityYSlime = (float)((double)this.vertVelocityYSlime + (double)swingProgress * 0.03 * Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
                                                        if ((p.getDeltaMovement().length() > 0.09 && p.onGround() || p.isSwimming() || p.isVisuallyCrawling() || p.onClimbable() && !p.isCrouching() && !p.onGround()) && ((Boolean)Minecraft.getInstance().options.bobView().get()).booleanValue()) {
                                                            Random random = new Random();
                                                            boolean randomBoolean = random.nextBoolean();
                                                            this.vertVelocityYSlime += (float)(-0.05 * p.getDeltaMovement().length() * Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
                                                        }
                                                        poseStack.scale(1.0f, 1.0f + this.vertAngleYSlime * -2.0f, 1.0f);
                                                    }
                                                } else if (stack.getUseAnimation() == UseAnim.BLOCK && stack.getUseAnimation() != UseAnim.SPEAR) {
                                                    poseStack.mulPose(Axis.ZP.rotationDegrees((float)(160 * l)));
                                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(-60 * l)));
                                                    poseStack.mulPose(Axis.XP.rotationDegrees(-70.0f));
                                                    poseStack.scale(0.75f, 0.75f, 0.75f);
                                                    poseStack.translate(0.15 * (double)l, bl ? 0.35 : 0.45, bl ? -0.15 : -0.1);
                                                    poseStack.translate(0.17 * (double)l, 0.0, 0.3);
                                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(-90 * l)));
                                                } else if (stack.getUseAnimation() == UseAnim.SPEAR) {
                                                    poseStack.mulPose(Axis.YN.rotationDegrees((float)(75 * l)));
                                                    poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
                                                    poseStack.mulPose(Axis.ZP.rotationDegrees((float)(45 * l)));
                                                    poseStack.translate(-0.3f * (float)l, 0.0f, 0.0f);
                                                } else if (stack.getUseAnimation() != UseAnim.SPEAR) {
                                                    poseStack.mulPose(Axis.YN.rotationDegrees((float)(75 * l)));
                                                    poseStack.mulPose(Axis.XP.rotationDegrees(70.0f));
                                                    poseStack.mulPose(Axis.ZP.rotationDegrees((float)(45 * l)));
                                                }
                                                if (stack.getUseAnimation() != UseAnim.BLOCK) {
                                                    poseStack.scale(1.2f, 1.2f, 1.2f);
                                                }
                                                if (stack.getUseAnimation() == UseAnim.BOW && !p.isUsingItem()) {
                                                    poseStack.translate(-0.1 * (double)l, -0.2, 0.0);
                                                }
                                                if (stack.is(Items.MACE)) {
                                                    if (((Boolean)HoldMyItemsClientConfig.MB3D_COMPAT.get()).booleanValue()) {
                                                        poseStack.translate(-0.08, 0.17, 0.0);
                                                        poseStack.mulPose(Axis.XP.rotationDegrees(40.0f));
                                                    }
                                                    poseStack.translate(0.1 * (double)l, 0.0, 0.0);
                                                    poseStack.scale(0.9f, 0.9f, 0.9f);
                                                }
                                            }
                                            Item var75 = stack.getItem();
                                            if (!RenderHelper.shouldRenderCustom(stack)) break block277;
                                            BlockItem blockItem = (BlockItem)var75;
                                            Block block = blockItem.getBlock();
                                            if (block instanceof SkullBlock) {
                                                SkullBlock skullBlock = (SkullBlock)block;
                                                poseStack.pushPose();
                                                poseStack.scale(0.4f, 0.4f, 0.4f);
                                                if (!bl2) {
                                                    poseStack.translate(-0.9f, 0.0f, 0.0f);
                                                }
                                                poseStack.translate(-0.9 * (double)l, -0.45, -0.5);
                                                float rotation = -80.0f;
                                                if (!bl2) {
                                                    rotation = 80.0f;
                                                }
                                                SkullBlock.Type skullType = skullBlock.getType();
                                                SkullModelBase skullModelBase = SkullHelper.SKULL_MODELS.get(skullType);
                                                ResolvableProfile gameProfile = null;
                                                if (skullType == SkullBlock.Types.PLAYER) {
                                                    gameProfile = SkullHelper.getSkullOwner(stack);
                                                }
                                                SkullBlockRenderer.renderSkull(null, (float)rotation, (float)0.0f, (PoseStack)poseStack, (MultiBufferSource)buffer, (int)light, (SkullModelBase)skullModelBase, (RenderType)SkullBlockRenderer.getRenderType((SkullBlock.Type)skullType, (ResolvableProfile)gameProfile));
                                                poseStack.popPose();
                                                ci.cancel();
                                            }
                                            if ((item instanceof BucketItem || item instanceof MilkBucketItem || stack.is(Items.POWDER_SNOW_BUCKET) || stack.getUseAnimation() == UseAnim.EAT || stack.is(ItemTags.BANNERS) || stack.is(Items.STRING) || stack.is(Items.REDSTONE) || stack.is(Items.LEVER) || stack.is(Items.TRIPWIRE_HOOK) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(HoldMyItemsTags.GLASS_PANES) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.RAILS) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.CLIMBABLE)) && !Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.LEAVES) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.COMBINATION_STEP_SOUND_BLOCKS)) break block277;
                                            blockRenderManager = Minecraft.getInstance().getBlockRenderer();
                                            poseStack.pushPose();
                                            if (!bl2) {
                                                poseStack.translate(-0.4f, 0.0f, 0.0f);
                                            }
                                            poseStack.scale(0.4f, 0.4f, 0.4f);
                                            poseStack.translate(-0.9 * (double)l, -0.45, -0.5);
                                            if (Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.BUTTONS)) {
                                                poseStack.translate(0.2 * (double)l, -0.15, -0.2);
                                            }
                                            if (Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.PRESSURE_PLATES)) {
                                                poseStack.translate(0.0, 0.1, 0.0);
                                            }
                                            if ((blockState = blockItem.getBlock().defaultBlockState()).is(BlockTags.FLOWERS) || blockState.is(BlockTags.SAPLINGS) || blockState.is(Blocks.TALL_GRASS) || blockState.is(BlockTags.REPLACEABLE) || blockState.is(HoldMyItemsTags.REPLACEABLE_BY_MUSHROOMS)) {
                                                poseStack.pushPose();
                                                ((AlternateBlockRenderer)blockRenderManager).renderSingleBlockEmission(Blocks.FLOWER_POT.defaultBlockState(), poseStack, buffer, light);
                                                poseStack.popPose();
                                                poseStack.mulPose(Axis.XN.rotationDegrees(this.swingAngleY / 3.0f));
                                            }
                                            if (stack.is(Items.SLIME_BLOCK) || stack.is(Items.HONEY_BLOCK) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.FLOWERS) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.LEAVES) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.SAPLINGS) || Block.byItem((Item)stack.getItem()).defaultBlockState().is(BlockTags.SWORD_EFFICIENT) || blockState.is(HoldMyItemsTags.REPLACEABLE_BY_MUSHROOMS) || blockState.is(BlockTags.REPLACEABLE)) {
                                                this.vertVelocityYSlime = (float)((double)this.vertVelocityYSlime + (double)swingProgress * 0.03 * Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
                                                if ((p.getDeltaMovement().length() > 0.09 && p.onGround() || p.isSwimming() || p.isVisuallyCrawling() || p.onClimbable() && !p.isCrouching() && !p.onGround()) && ((Boolean)Minecraft.getInstance().options.bobView().get()).booleanValue()) {
                                                    Random random = new Random();
                                                    boolean randomBoolean = random.nextBoolean();
                                                    this.vertVelocityYSlime += (float)(-0.05 * p.getDeltaMovement().length() * Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
                                                }
                                                poseStack.scale(1.0f - this.vertAngleYSlime * -2.0f, 1.0f + this.vertAngleYSlime * -2.0f, 1.0f);
                                            }
                                            if (blockState.is(BlockTags.FLOWERS) || blockState.is(BlockTags.SAPLINGS) || blockState.is(Blocks.TALL_GRASS) || blockState.is(BlockTags.REPLACEABLE) || blockState.is(HoldMyItemsTags.REPLACEABLE_BY_MUSHROOMS) || blockState.is(HoldMyItemsTags.CHAINS) || stack.is(Items.BELL)) {
                                                float yawDelta = (float)(Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
                                                pitchDelta = p.yRotO - p.getYRot();
                                                float angularSpeed = p.xRotO - p.getXRot();
                                                this.swingVelocityY += pitchDelta * 0.015f * yawDelta;
                                                this.swingVelocityY += swingProgress * 2.0f * yawDelta;
                                                this.swingVelocityX += angularSpeed * 0.015f * yawDelta;
                                                this.swingVelocityY -= 0.1f * this.swingAngleY * yawDelta;
                                                this.swingVelocityX -= 0.1f * this.swingAngleX * yawDelta;
                                                this.swingVelocityY = (float)((double)this.swingVelocityY * Math.pow(0.88f, yawDelta));
                                                this.swingVelocityX = (float)((double)this.swingVelocityX * Math.pow(0.88f, yawDelta));
                                                this.swingAngleY += this.swingVelocityY * yawDelta;
                                                this.swingAngleX += this.swingVelocityX * yawDelta;
                                                currentSpeed = p.getDeltaMovement().length();
                                                this.swingVelocityZ = (float)((double)this.swingVelocityZ + (bl ? (currentSpeed * -1.0 * 15.0 - (double)this.swingVelocityZ) * (double)0.1f * (double)yawDelta : (currentSpeed * 15.0 - (double)this.swingVelocityZ) * (double)0.1f * (double)yawDelta));
                                                if ((currentSpeed > 0.09 && p.onGround() || p.isSwimming() || p.onClimbable() && !p.isCrouching() && !p.onGround()) && ((Boolean)Minecraft.getInstance().options.bobView().get()).booleanValue()) {
                                                    Random random = new Random();
                                                    boolean randomBoolean = random.nextBoolean();
                                                    this.swingVelocityY += (float)(randomBoolean ? -5.5 * currentSpeed * (double)yawDelta : 5.5 * currentSpeed * (double)yawDelta);
                                                }
                                            }
                                            if ((float)p.tickCount - this.prevAge >= 100.0f) {
                                                this.repPower = !this.repPower;
                                                this.prevAge = p.tickCount;
                                            }
                                            if (blockItem.getBlock() == Blocks.NOTE_BLOCK) {
                                                if (this.isNearRedstonePrev != this.isNearRedstoneBlock((Player)p) && this.isNearRedstoneBlock((Player)p)) {
                                                    p.playSound((SoundEvent)SoundEvents.NOTE_BLOCK_HARP.value(), 0.7f, 1.0f);
                                                }
                                                if (this.isNearRedstoneBlock((Player)p) && this.isCrouchingPrev != p.isCrouching() && this.isCrouchingPrev != p.isCrouching() && p.isCrouching()) {
                                                    p.playSound((SoundEvent)SoundEvents.NOTE_BLOCK_HARP.value(), 0.7f, ThreadLocalRandom.current().nextFloat());
                                                }
                                            }
                                            if (blockItem.getBlock() == Blocks.REPEATER && this.repPower) {
                                                blockState = (BlockState)blockState.setValue((Property)RepeaterBlock.POWERED, (Comparable)Boolean.valueOf(true));
                                            }
                                            if (blockItem.getBlock() == Blocks.COMPARATOR && this.repPower) {
                                                blockState = (BlockState)blockState.setValue((Property)ComparatorBlock.POWERED, (Comparable)Boolean.valueOf(true));
                                            }
                                            if (blockItem.getBlock() == Blocks.REDSTONE_TORCH && p.isUnderWater() || this.isNearRedstoneBlock((Player)p) && blockItem.getBlock() == Blocks.REDSTONE_TORCH) {
                                                if (p.isUnderWater() != this.wasSubmerged) {
                                                    p.playSound(SoundEvents.FIRE_EXTINGUISH, 0.5f, 1.0f);
                                                }
                                                blockState = (BlockState)blockState.setValue((Property)RedstoneTorchBlock.LIT, (Comparable)Boolean.valueOf(false));
                                            }
                                            if ((blockItem.getBlock() == Blocks.CAMPFIRE || blockItem.getBlock() == Blocks.SOUL_CAMPFIRE) && p.isUnderWater()) {
                                                if (p.isUnderWater() != this.wasSubmerged) {
                                                    p.playSound(SoundEvents.FIRE_EXTINGUISH, 0.5f, 1.0f);
                                                }
                                                blockState = (BlockState)blockState.setValue((Property)CampfireBlock.LIT, (Comparable)Boolean.valueOf(false));
                                            }
                                            if (blockItem.getBlock() instanceof ChestBlock || blockItem.getBlock() instanceof EnderChestBlock || blockItem.getBlock() instanceof ShulkerBoxBlock || blockItem.getBlock() instanceof BedBlock) {
                                                if (stack.is(ItemTags.BEDS)) {
                                                    if (bl) {
                                                        poseStack.translate(0.9, 0.0, 0.8);
                                                    }
                                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(90 * l)));
                                                } else {
                                                    if (!bl) {
                                                        poseStack.translate(0.1, 0.0, 0.9);
                                                    } else {
                                                        poseStack.translate(0.9, 0.0, -0.1);
                                                    }
                                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(-90 * l)));
                                                }
                                                BlockEntityWithoutLevelRenderer renderer = ((ItemRendererAccessor)this.itemRenderer).holdmyitemsnf$getBlockEntityRenderer();
                                                renderer.renderByItem(stack, bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, poseStack, buffer, light, OverlayTexture.NO_OVERLAY);
                                                ci.cancel();
                                            }
                                            if (stack.is(Items.PISTON) || stack.is(Items.STICKY_PISTON)) break block278;
                                            if (blockState.getLightEmission() <= 0) break block279;
                                            if (blockState.is(BlockTags.FLOWERS) || blockState.is(BlockTags.SAPLINGS) || blockState.is(Blocks.TALL_GRASS) || blockState.is(BlockTags.REPLACEABLE) || blockState.is(HoldMyItemsTags.REPLACEABLE_BY_MUSHROOMS)) {
                                                poseStack.translate(0.0, 0.3, 0.0);
                                                if (blockState.is(BlockTags.FLOWERS)) {
                                                    poseStack.mulPose(Axis.XN.rotationDegrees(this.swingAngleY / 3.0f));
                                                }
                                            }
                                            ((AlternateBlockRenderer)blockRenderManager).renderSingleBlockEmission(blockState, poseStack, buffer, light);
                                            break block280;
                                        }
                                        if (stack.is(Items.BELL)) {
                                            poseStack.translate(0.0, -1.45, 0.0);
                                            poseStack.pushPose();
                                            float yawDelta = p.yRotO - p.getYRot();
                                            pitchDelta = p.xRotO - p.getXRot();
                                            float angularSpeed = (float)Math.sqrt(yawDelta * yawDelta + pitchDelta * pitchDelta);
                                            this.soundCooldownTimer = (float)Math.max(0.0, (double)this.soundCooldownTimer - tt);
                                            if (Mth.abs((float)this.swingAngleY) > 13.5f && this.soundCooldownTimer <= 0.0f) {
                                                p.playSound(SoundEvents.BELL_BLOCK, 1.0f, 1.0f);
                                                this.soundCooldownTimer = 14.5f;
                                            }
                                            poseStack.mulPose(Axis.XP.rotationDegrees(this.swingAngleY));
                                            BellBlockEntity bellBlockEntity = new BellBlockEntity(BlockPos.ZERO, Blocks.BELL.defaultBlockState());
                                            bellBlockEntity.setLevel((Level)Minecraft.getInstance().level);
                                            Minecraft.getInstance().getBlockEntityRenderDispatcher().getRenderer((BlockEntity)bellBlockEntity).render((BlockEntity)bellBlockEntity, 0.0f, poseStack, buffer, light, OverlayTexture.NO_OVERLAY);
                                            poseStack.popPose();
                                            EnumProperty attachFaceProp = null;
                                            for (Property prop : blockState.getProperties()) {
                                                if (!prop.getName().equals("face") || !(prop instanceof EnumProperty)) continue;
                                                attachFaceProp = (EnumProperty)prop;
                                                break;
                                            }
                                            if (attachFaceProp != null) {
                                                ((AlternateBlockRenderer)blockRenderManager).renderSingleBlockEmission((BlockState)blockState.setValue(attachFaceProp, (Comparable)AttachFace.CEILING), poseStack, buffer, light);
                                            }
                                            break block280;
                                        } else {
                                            if (blockState.is(BlockTags.FLOWERS) || blockState.is(BlockTags.SAPLINGS) || blockState.is(Blocks.TALL_GRASS) || blockState.is(BlockTags.REPLACEABLE) || blockState.is(HoldMyItemsTags.REPLACEABLE_BY_MUSHROOMS)) {
                                                poseStack.translate(0.0, 0.3, 0.0);
                                                if (blockState.is(BlockTags.FLOWERS)) {
                                                    poseStack.mulPose(Axis.XN.rotationDegrees(this.swingAngleY / 3.0f));
                                                }
                                            }
                                            if (blockState.is(BlockTags.DOORS)) {
                                                poseStack.translate(-0.4 * (double)l, -0.2, -0.3);
                                                poseStack.scale(0.7f, 0.7f, 0.7f);
                                                poseStack.mulPose(Axis.YP.rotationDegrees((float)(20 * l)));
                                                poseStack.translate(0.0f, 0.0f, 0.5f);
                                            }
                                            if (blockState.is(HoldMyItemsTags.CHAINS)) {
                                                poseStack.translate(-0.1 * (double)l, -1.0, 0.0);
                                                poseStack.mulPose(Axis.XN.rotationDegrees(this.swingAngleY / 3.0f));
                                                poseStack.translate(0.0f, 0.0f, 0.5f);
                                            }
                                            ((AlternateBlockRenderer)blockRenderManager).renderSingleBlockEmission(blockState, poseStack, buffer, light);
                                            if (blockState.hasProperty((Property)BlockStateProperties.DOUBLE_BLOCK_HALF)) {
                                                poseStack.translate(0.0f, 1.0f, 0.0f);
                                                if (blockState.is(BlockTags.FLOWERS) || blockState.is(Blocks.TALL_GRASS) || blockState.is(BlockTags.REPLACEABLE) || blockState.is(HoldMyItemsTags.REPLACEABLE_BY_MUSHROOMS)) {
                                                    poseStack.mulPose(Axis.XN.rotationDegrees(this.swingAngleY));
                                                }
                                                ((AlternateBlockRenderer)blockRenderManager).renderSingleBlockEmission((BlockState)blockState.setValue((Property)BlockStateProperties.DOUBLE_BLOCK_HALF, (Comparable)DoubleBlockHalf.UPPER), poseStack, buffer, light);
                                            }
                                            if (blockState.is(HoldMyItemsTags.CHAINS)) {
                                                poseStack.translate(0.0f, -1.0f, 0.0f);
                                                poseStack.mulPose(Axis.XN.rotationDegrees(this.swingAngleY));
                                                poseStack.translate(0.0f, 0.0f, 0.5f);
                                                ((AlternateBlockRenderer)blockRenderManager).renderSingleBlockEmission(blockState, poseStack, buffer, light);
                                            }
                                        }
                                        break block280;
                                    }
                                    if (this.isNearRedstonePrev != this.isNearRedstoneBlock((Player)p)) {
                                        if (this.isNearRedstoneBlock((Player)p)) {
                                            p.playSound(SoundEvents.PISTON_EXTEND, 0.7f, 1.0f);
                                        } else {
                                            p.playSound(SoundEvents.PISTON_CONTRACT, 0.7f, 1.0f);
                                        }
                                    }
                                    this.pistonCount = this.isNearRedstoneBlock((Player)p) ? (float)((double)this.pistonCount + 0.2 * tt) : (float)((double)this.pistonCount - 0.2 * tt);
                                    if (this.pistonCount > 1.0f) {
                                        this.pistonCount = 1.0f;
                                    } else if (this.pistonCount < 0.0f) {
                                        this.pistonCount = 0.0f;
                                    }
                                    poseStack.translate(0.08 * (double)l, 0.0, 0.0);
                                    BlockState pistonState = (BlockState)((BlockState)Blocks.PISTON.defaultBlockState().setValue((Property)PistonBaseBlock.EXTENDED, (Comparable)Boolean.valueOf(true))).setValue((Property)PistonBaseBlock.FACING, (Comparable)Direction.UP);
                                    BlockState pistonHeadState = Blocks.AIR.defaultBlockState();
                                    if (stack.is(Items.PISTON)) {
                                        pistonHeadState = (BlockState)((BlockState)Blocks.PISTON_HEAD.defaultBlockState().setValue((Property)BlockStateProperties.FACING, (Comparable)Direction.UP)).setValue((Property)BlockStateProperties.SHORT, (Comparable)Boolean.valueOf(false));
                                    }
                                    if (stack.is(Items.STICKY_PISTON)) {
                                        pistonHeadState = (BlockState)((BlockState)((BlockState)Blocks.PISTON_HEAD.defaultBlockState().setValue((Property)BlockStateProperties.FACING, (Comparable)Direction.UP)).setValue((Property)BlockStateProperties.SHORT, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.PISTON_TYPE, (Comparable)PistonType.STICKY);
                                    }
                                    ((AlternateBlockRenderer)blockRenderManager).renderSingleBlockEmission(pistonState, poseStack, buffer, light);
                                    poseStack.translate(0.0, -0.0312, 0.0);
                                    poseStack.translate(0.0, 0.4 * (double)Mth.clamp((float)(this.vertAngleYSlime * -1.0f), (float)0.0f, (float)255.0f), 0.0);
                                    poseStack.translate(0.0, 0.01 * (double)Mth.sin((float)(this.headFallCount * 4.14f)), 0.0);
                                    poseStack.translate(0.0, Mth.clamp((double)((double)this.vertAngleY * -6.5 + (double)this.pistonCount), (double)0.0312, (double)0.7), 0.0);
                                    ((AlternateBlockRenderer)blockRenderManager).renderSingleBlockEmission(pistonHeadState, poseStack, buffer, light);
                                }
                                poseStack.popPose();
                                break block264;
                            }
                            if (BuiltInRegistries.ITEM.getKey(stack.getItem()).getNamespace().equals("sophisticatedstorage") && (item.getDescriptionId().toLowerCase().contains("chest") || item.getDescriptionId().toLowerCase().contains("barrel") || item.getDescriptionId().toLowerCase().contains("shulker"))) {
                                if (!bl) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(45.0f));
                                    poseStack.translate(0.13, 0.0, 0.1);
                                } else {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(-45.0f));
                                    poseStack.translate(-0.13, 0.0, 0.1);
                                }
                            }
                            if (itemId.getNamespace().equals("create")) {
                                if (itemId.getPath().equals("belt_connector") || itemId.getPath().equals("clipboard")) {
                                    poseStack.translate(-0.15 * (double)l, -0.15, -0.1);
                                    poseStack.mulPose(Axis.XP.rotationDegrees(10.0f));
                                    poseStack.scale(0.7f, 0.7f, 0.7f);
                                } else if (itemId.getPath().equals("shaft") || itemId.getPath().equals("cogwheel") || itemId.getPath().equals("large_cogwheel")) {
                                    poseStack.translate(-0.15 * (double)l, 0.0, 0.0);
                                }
                            }
                            jn = Mth.sin((float)(Mth.clamp((float)swingProgress, (float)0.0f, (float)0.9f) * 3.48f));
                            jn = this.easeInOutBack(jn);
                            if (stack.is(HoldMyItemsTags.TOOLS) && !stack.is(ItemTags.TRIMMABLE_ARMOR) && !stack.is(ItemTags.BOOKSHELF_BOOKS) && stack.getUseAnimation() != UseAnim.EAT || stack.getUseAnimation() == UseAnim.BOW || stack.getUseAnimation() == UseAnim.SPYGLASS || this.getAttackDamage(stack) != 0.0f || stack.getUseAnimation() == UseAnim.BLOCK || stack.is(Items.WARPED_FUNGUS_ON_A_STICK) || stack.is(Items.CARROT_ON_A_STICK) || stack.getItem() instanceof FishingRodItem || stack.is(Items.SHEARS)) {
                                if (stack.getItem() instanceof SwordItem) {
                                    poseStack.mulPose(Axis.XP.rotationDegrees(-60.0f * jn));
                                    poseStack.translate(0.0, 0.1 * (double)jn, -0.1 * (double)jn);
                                }
                                if (stack.getItem() instanceof ShovelItem) {
                                    poseStack.mulPose(Axis.XP.rotationDegrees(-80.0f * swing_rot));
                                    poseStack.mulPose(Axis.XP.rotationDegrees(30.0f * swing));
                                } else if (stack.getUseAnimation() == UseAnim.SPEAR) {
                                    poseStack.mulPose(Axis.XP.rotationDegrees(-40.0f * swing_rot));
                                    poseStack.translate(0.0, 0.1 * (double)swing_rot, -0.1 * (double)swing_rot);
                                } else if (stack.getUseAnimation() != UseAnim.BLOCK) {
                                    poseStack.mulPose(Axis.XP.rotationDegrees(-35.0f * jn));
                                    poseStack.translate(0.0, 0.05 * (double)jn, -0.05 * (double)jn);
                                }
                            }
                            if (!stack.is(Items.NETHER_STAR) && (!stack.is(Items.END_CRYSTAL) || !((Boolean)HoldMyItemsClientConfig.MB3D_COMPAT.get()).booleanValue() || item instanceof BucketItem || item instanceof MilkBucketItem || stack.is(Items.POWDER_SNOW_BUCKET))) {
                                this.netherCounter = 0.0f;
                            } else {
                                this.netherCounter = (float)((double)this.netherCounter + 0.9 * tt);
                                poseStack.translate(0.0, 0.25 + 0.02 * (double)Mth.sin((float)(this.netherCounter * 0.1f)), 0.0);
                                poseStack.mulPose(Axis.XP.rotationDegrees(3.0f * Mth.sin((float)(this.netherCounter * 0.2f))));
                                poseStack.scale(1.0f + 0.01f * Mth.sin((float)this.netherCounter), 1.0f + 0.01f * Mth.sin((float)this.netherCounter), 1.0f + 0.01f * Mth.sin((float)this.netherCounter));
                                poseStack.mulPose(Axis.XP.rotationDegrees(-10.0f * this.easeInOutBack(Mth.sin((float)(this.itemSwitchCount * 3.14f)))));
                                poseStack.mulPose(Axis.YP.rotationDegrees(360.0f * this.easeInOutBack(this.itemSwitchCount)));
                                poseStack.translate(0.25f * (float)l, 0.0f, 0.0f);
                            }
                            if (((Boolean)HoldMyItemsClientConfig.MB3D_COMPAT.get()).booleanValue() && BuiltInRegistries.ITEM.getKey(stack.getItem()).getNamespace().equals("minecraft") && !(item instanceof BucketItem) && !(item instanceof MilkBucketItem) && !stack.is(Items.POWDER_SNOW_BUCKET)) {
                                if (stack.getItem() instanceof SwordItem) {
                                    poseStack.translate(0.0, 0.2, 0.0);
                                }
                                if (stack.is(Items.FEATHER) || stack.is(Items.SLIME_BALL)) {
                                    this.vertVelocityYSlime = (float)((double)this.vertVelocityYSlime + (double)swingProgress * 0.03 * Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
                                    if ((p.getDeltaMovement().length() > 0.09 && p.onGround() || p.isSwimming() || p.isVisuallyCrawling() || p.onClimbable() && !p.isCrouching() && !p.onGround()) && ((Boolean)Minecraft.getInstance().options.bobView().get()).booleanValue()) {
                                        Random random = new Random();
                                        boolean randomBoolean = random.nextBoolean();
                                        this.vertVelocityYSlime += (float)(-0.05 * p.getDeltaMovement().length() * Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
                                    }
                                    poseStack.scale(1.0f, 1.0f + this.vertAngleYSlime * -2.0f, 1.0f);
                                }
                            }
                            if (stack.getItem() instanceof ShovelItem) {
                                poseStack.translate(0.07 * (double)l, 0.0, 0.05);
                                poseStack.mulPose(Axis.YP.rotationDegrees((float)(90 * l)));
                                poseStack.mulPose(Axis.XP.rotationDegrees(-15.0f));
                            }
                            if (stack.getDescriptionId().contains("music_disc")) {
                                float breathe;
                                float f = breathe = this.itemSwitchCount < 0.667f ? 0.0f : Mth.sin((float)(Mth.clamp((float)this.itemSwitchCount, (float)0.667f, (float)1.0f) * 3.14f * 4.0f)) * 1.2f;
                                if (bl) {
                                    poseStack.translate(0.0, 0.1 * (double)breathe, 0.0);
                                    float yawDelta = this.itemSwitchCount < 0.72783f ? Mth.sin((float)(Mth.clamp((float)this.itemSwitchCount, (float)0.0f, (float)0.1f) * 3.14f * 4.0f)) : Mth.sin((float)(Mth.clamp((float)this.itemSwitchCount, (float)0.72783f, (float)1.0f) * 3.14f * 2.0f - 3.0f));
                                    yawDelta = this.easeInOutBack(yawDelta);
                                    poseStack.translate(0.15 * (double)yawDelta * (double)l, 0.06 * (double)yawDelta, 0.0);
                                    poseStack.mulPose(Axis.ZP.rotationDegrees((float)(90 * l) * yawDelta));
                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(17 * l) * yawDelta));
                                    poseStack.mulPose(Axis.XP.rotationDegrees(360.0f * this.easeInOutBack(this.itemSwitchCount)));
                                } else {
                                    poseStack.translate(0.0, 0.1 * (double)breathe, 0.0);
                                    float yawDelta = this.itemSwitchCountO < 0.72783f ? Mth.sin((float)(Mth.clamp((float)this.itemSwitchCountO, (float)0.0f, (float)0.1f) * 3.14f * 4.0f)) : Mth.sin((float)(Mth.clamp((float)this.itemSwitchCountO, (float)0.72783f, (float)1.0f) * 3.14f * 2.0f - 3.0f));
                                    yawDelta = this.easeInOutBack(yawDelta);
                                    poseStack.translate(0.15 * (double)yawDelta * (double)l, 0.06 * (double)yawDelta, 0.0);
                                    poseStack.mulPose(Axis.ZP.rotationDegrees((float)(90 * l) * yawDelta));
                                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(17 * l) * yawDelta));
                                    poseStack.mulPose(Axis.XP.rotationDegrees(360.0f * this.easeInOutBack(this.itemSwitchCountO)));
                                }
                            }
                            if (stack.is(HoldMyItemsTags.GEMS_TAG) || stack.isEnchanted()) {
                                light = 0xF000F0;
                            }
                            if (bl) {
                                poseStack.scale(Mth.clamp((float)switchItems, (float)0.7f, (float)1.0f), Mth.clamp((float)switchItems, (float)0.7f, (float)1.0f), Mth.clamp((float)switchItems, (float)0.7f, (float)1.0f));
                            } else {
                                poseStack.scale(Mth.clamp((float)switchItemsO, (float)0.7f, (float)1.0f), Mth.clamp((float)switchItemsO, (float)0.7f, (float)1.0f), Mth.clamp((float)switchItemsO, (float)0.7f, (float)1.0f));
                            }
                            if (!stack.is(Items.AXOLOTL_BUCKET)) break block281;
                            this.test(1.0f);
                            Entity fish = EntityType.AXOLOTL.create((Level)Minecraft.getInstance().level);
                            EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                            if (fish instanceof Axolotl) {
                                EntityRenderer var95;
                                CompoundTag tag;
                                Axolotl axolotlEntity = (Axolotl)fish;
                                CustomData customData = (CustomData)stack.get(DataComponents.CUSTOM_DATA);
                                if (customData != null && (tag = customData.copyTag()).contains("Variant", 3)) {
                                    int variantId = tag.getInt("Variant");
                                    if (axolotlEntity != null) {
                                        axolotlEntity.setVariant(Axolotl.Variant.byId((int)variantId));
                                    }
                                }
                                if ((var95 = dispatcher.getRenderer((Entity)axolotlEntity)) instanceof AxolotlRenderer) {
                                    AxolotlRenderer axolotlRenderer = (AxolotlRenderer)var95;
                                    AxolotlModel model = (AxolotlModel)axolotlRenderer.getModel();
                                    model.setupAnim(axolotlEntity, 0.0f, 0.0f, partialTicks, 0.0f, 0.0f);
                                    if (model instanceof AxolotlModelAccessor) {
                                        AxolotlModelAccessor accessor = (AxolotlModelAccessor)model;
                                        ModelPart head = accessor.getHead();
                                        head.zRot = (float)Math.toRadians(10.0f * Mth.sin((float)(this.headFallCount * 2.7f)));
                                        head.xRot = (float)Math.toRadians(70.0f + 130.0f * this.vertAngleYSlime + 5.0f * Mth.sin((float)(this.globalAnimationCounter * 0.56f)));
                                        ModelPart left = accessor.getLeftLeg();
                                        ModelPart right = accessor.getRightLeg();
                                        ModelPart tail = accessor.getTail();
                                        ModelPart backLegL = accessor.getLeftLegB();
                                        ModelPart backLegR = accessor.getRightLegB();
                                        tail.visible = false;
                                        backLegL.visible = false;
                                        backLegR.visible = false;
                                        left.xRot = right.xRot = (float)Math.toRadians(30.0f + 220.0f * this.vertAngleYSlime * 1.4f + 10.0f * Mth.sin((float)(this.headFallCount * 2.7f)) + 2.0f * Mth.sin((float)this.globalAnimationCounter));
                                        right.yRot = left.yRot = (float)Math.toRadians(-10.0f * this.vertAngleYSlime);
                                        right.zRot = (float)Math.toRadians(30.0f - 60.0f * this.vertAngleYSlime + 10.0f * Mth.sin((float)(this.headFallCount * 2.7f)));
                                        left.zRot = (float)Math.toRadians(-30.0f - 60.0f * this.vertAngleYSlime + 10.0f * Mth.sin((float)(this.headFallCount * 2.7f)));
                                        poseStack.pushPose();
                                        poseStack.translate(0.76 * (double)l, 0.73, -0.025);
                                        poseStack.mulPose(Axis.ZP.rotationDegrees((float)(120 * l)));
                                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(-70 * l)));
                                        if (axolotlEntity.isBaby()) {
                                            poseStack.scale(1.0f, 1.0f, 1.0f);
                                        } else {
                                            poseStack.scale(0.7f, 0.7f, 0.7f);
                                        }
                                        Axolotl.Variant variant = axolotlEntity.getVariant();
                                        ResourceLocation texture = ResourceLocation.fromNamespaceAndPath((String)"minecraft", (String)("textures/entity/axolotl/axolotl_" + variant.name().toLowerCase() + ".png"));
                                        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutout((ResourceLocation)texture));
                                        model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
                                        tail.visible = true;
                                        backLegL.visible = true;
                                        backLegR.visible = true;
                                        poseStack.popPose();
                                    }
                                    this.renderItem((LivingEntity)p, Items.WATER_BUCKET.getDefaultInstance(), bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl2, poseStack, buffer, light);
                                    ci.cancel();
                                }
                            }
                            break block264;
                        }
                        if (stack.is(Items.PUFFERFISH_BUCKET)) break block282;
                        if (!stack.is(Items.SALMON_BUCKET)) break block283;
                        poseStack.pushPose();
                        if (!bl) {
                            poseStack.translate(-0.05, 0.0, 0.0);
                        }
                        poseStack.translate(0.07 * (double)l, 0.24 - (double)this.vertAngleYSlime, -0.06);
                        Entity fish = EntityType.SALMON.create((Level)Minecraft.getInstance().level);
                        EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                        poseStack.mulPose(Axis.YP.rotationDegrees(-100.0f));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(40.0f));
                        poseStack.mulPose(Axis.XP.rotationDegrees(-80.0f));
                        poseStack.scale(0.5f, 0.5f, 0.5f);
                        dispatcher.render(fish, 0.0, 0.0, 0.0, 0.0f, this.globalAnimationCounter, poseStack, buffer, light);
                        poseStack.popPose();
                        this.renderItem((LivingEntity)p, Items.WATER_BUCKET.getDefaultInstance(), bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl2, poseStack, buffer, light);
                        ci.cancel();
                        break block264;
                    }
                    if (!stack.is(Items.COD_BUCKET)) break block284;
                    poseStack.pushPose();
                    poseStack.translate(0.07 * (double)l, 0.24 - (double)this.vertAngleYSlime, -0.06);
                    Entity fish = EntityType.COD.create((Level)Minecraft.getInstance().level);
                    EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                    poseStack.mulPose(Axis.YP.rotationDegrees(-100.0f));
                    poseStack.mulPose(Axis.ZP.rotationDegrees(40.0f));
                    poseStack.mulPose(Axis.XP.rotationDegrees(-80.0f));
                    poseStack.scale(0.5f, 0.5f, 0.5f);
                    dispatcher.render(fish, 0.0, 0.0, 0.0, 0.0f, this.globalAnimationCounter, poseStack, buffer, light);
                    poseStack.popPose();
                    this.renderItem((LivingEntity)p, Items.WATER_BUCKET.getDefaultInstance(), bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl2, poseStack, buffer, light);
                    ci.cancel();
                    break block264;
                }
                if (stack.is(Items.TROPICAL_FISH_BUCKET)) {
                    poseStack.pushPose();
                    if (!bl) {
                        poseStack.translate(-0.05, 0.0, 0.0);
                    }
                    poseStack.translate(0.07 * (double)l, 0.24 - (double)this.vertAngleYSlime, 0.0);
                    Entity fish = EntityType.TROPICAL_FISH.create((Level)Minecraft.getInstance().level);
                    EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                    poseStack.mulPose(Axis.YP.rotationDegrees(-100.0f));
                    poseStack.mulPose(Axis.ZP.rotationDegrees(40.0f));
                    poseStack.mulPose(Axis.XP.rotationDegrees(-80.0f));
                    poseStack.scale(0.7f, 0.7f, 0.7f);
                    dispatcher.render(fish, 0.0, 0.0, 0.0, 0.0f, this.globalAnimationCounter, poseStack, buffer, light);
                    poseStack.popPose();
                    this.renderItem((LivingEntity)p, Items.WATER_BUCKET.getDefaultInstance(), bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl2, poseStack, buffer, light);
                    ci.cancel();
                    break block264;
                } else if (stack.is(Items.TADPOLE_BUCKET)) {
                    poseStack.pushPose();
                    poseStack.translate(-0.1 * (double)l, 0.16 - (double)this.vertAngleYSlime, 0.0);
                    Entity fish = EntityType.TADPOLE.create((Level)Minecraft.getInstance().level);
                    EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                    poseStack.mulPose(Axis.YP.rotationDegrees((float)(-100 * l)));
                    poseStack.mulPose(Axis.ZP.rotationDegrees((float)(20 * l)));
                    poseStack.mulPose(Axis.XP.rotationDegrees(-60.0f));
                    dispatcher.render(fish, 0.0, 0.0, 0.0, 0.0f, this.globalAnimationCounter, poseStack, buffer, light);
                    poseStack.popPose();
                    this.renderItem((LivingEntity)p, Items.WATER_BUCKET.getDefaultInstance(), bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl2, poseStack, buffer, light);
                    ci.cancel();
                    break block264;
                } else {
                    if (arm == p.getMainArm()) {
                        poseStack.translate(-0.2 * (double)Mth.sin((float)Mth.clamp((float)(this.inspectSpinCounter * 3.14f), (float)0.0f, (float)0.5f)) * (double)l, 0.0, 0.0);
                        poseStack.mulPose(Axis.XP.rotationDegrees(-360.0f * this.easeInOutBack(this.inspectSpinCounter) * (float)l));
                    }
                    this.renderItem((LivingEntity)p, stack, bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl2, poseStack, buffer, light);
                    ci.cancel();
                }
                break block264;
            }
            poseStack.pushPose();
            float breathe = 0.01f * Mth.sin((float)(this.globalAnimationCounter * 0.4f));
            poseStack.translate(0.0, 0.2 + (double)breathe, -0.01);
            poseStack.mulPose(Axis.XP.rotationDegrees(-10.0f));
            poseStack.mulPose(Axis.YP.rotationDegrees((float)(20 * l)));
            poseStack.mulPose(Axis.ZP.rotationDegrees((float)(10 * l)));
            this.vertVelocityYSlime = (float)((double)this.vertVelocityYSlime + (double)swingProgress * 0.03 * Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
            if ((p.getDeltaMovement().length() > 0.09 && p.onGround() || p.isSwimming() || p.isVisuallyCrawling() || p.onClimbable() && !p.isCrouching() && !p.onGround()) && ((Boolean)Minecraft.getInstance().options.bobView().get()).booleanValue()) {
                new Random();
                this.vertVelocityYSlime += (float)(-0.05 * p.getDeltaMovement().length() * Holdmyitemsnf.deltaTime * (Double)HoldMyItemsClientConfig.ANIMATION_SPEED.get() * 30.0);
            }
            poseStack.scale(0.83f + breathe, 0.83f + this.vertAngleYSlime * -2.0f + breathe, 0.83f + breathe);
            this.renderItem((LivingEntity)p, Items.PUFFERFISH.getDefaultInstance(), bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl2, poseStack, buffer, light);
            poseStack.popPose();
            this.renderItem((LivingEntity)p, Items.WATER_BUCKET.getDefaultInstance(), bl2 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, !bl2, poseStack, buffer, light);
            ci.cancel();
        }
        poseStack.popPose();
        poseStack.popPose();
        this.prevItemM = p.getMainHandItem();
        this.prevItemO = p.getOffhandItem();
        this.isAttacking = Minecraft.getInstance().options.keyAttack.isDown();
        this.wasSubmerged = p.isUnderWater();
        this.lastOnGroundState = p.onGround();
        this.isNearRedstonePrev = this.isNearRedstoneBlock((Player)p);
        this.isCrouchingPrev = p.isCrouching();
        this.useItemPrev = p.isUsingItem();
        this.swingAngleYPrev = this.swingAngleY;
        ci.cancel();
    }
}
