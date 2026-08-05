/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.BucketItem
 *  net.minecraft.world.item.HangingSignItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.MilkBucketItem
 *  net.minecraft.world.item.SignItem
 *  net.minecraft.world.item.UseAnim
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.EntityBlock
 *  net.minecraft.world.level.block.state.BlockState
 */
package de.bene2212.holdmyitemsnf.util;

import de.bene2212.holdmyitemsnf.config.HoldMyItemsClientConfig;
import de.bene2212.holdmyitemsnf.util.HoldMyItemsTags;
import java.util.Set;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RenderHelper {
    private static final Set<String> DENIED_NAMESPACES = Set.of("laserio", "integrateddynamics");
    private static final Set<String> DENIED_ITEMS = Set.of("blue_skies:bluebright_chest", "blue_skies:starlit_chest", "blue_skies:frostbright_chest", "blue_skies:comet_chest", "blue_skies:lunar_chest", "blue_skies:dusk_chest", "blue_skies:maple_chest", "draconicevolution:basic_io_crystal", "draconicevolution:basic_relay_crystal", "draconicevolution:basic_wireless_crystal", "draconicevolution:dislocator_pedestal", "draconicevolution:draconic_io_crystal", "draconicevolution:draconic_relay_crystal", "draconicevolution:draconic_wireless_crystal", "draconicevolution:draconium_chest", "draconicevolution:reactor_core", "draconicevolution:reactor_injector", "draconicevolution:reactor_stabilizer", "draconicevolution:wyvern_io_crystal", "draconicevolution:wyvern_relay_crystal", "draconicevolution:wyvern_wireless_crystal", "bloodmagic:alchemytable", "industrialforegoing:machine_frame_pity", "industrialforegoing:machine_frame_simple", "industrialforegoing:machine_frame_advanced", "industrialforegoing:machine_frame_supreme", "ars_creo:starbuncle_wheel", "productivebees:feeder");

    public static boolean shouldRenderCustom(ItemStack stack) {
        Item item = stack.getItem();
        if (!(item instanceof BlockItem)) {
            return false;
        }
        BlockItem blockItem = (BlockItem)item;
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        if (itemId == null) {
            return false;
        }
        if (item instanceof BucketItem || item instanceof MilkBucketItem || stack.is(Items.POWDER_SNOW_BUCKET) || stack.getUseAnimation() == UseAnim.EAT || stack.is(ItemTags.BANNERS) || stack.is(Items.STRING) || stack.is(Items.REDSTONE) || stack.is(Items.LEVER) || stack.is(Items.TRIPWIRE_HOOK)) {
            return false;
        }
        String namespace = itemId.getNamespace();
        String fullItemId = itemId.toString();
        if (stack.is(Items.CONDUIT) || item instanceof SignItem || item instanceof HangingSignItem || namespace.equals("sophisticatedstorage") || HoldMyItemsClientConfig.isInRenderBlockAsItem(itemId.toString())) {
            return false;
        }
        Block block = blockItem.getBlock();
        BlockState blockState = block.defaultBlockState();
        if (blockState.is(HoldMyItemsTags.GLASS_PANES) || blockState.is(BlockTags.RAILS) || blockState.is(BlockTags.CLIMBABLE) || blockState.is(BlockTags.COMBINATION_STEP_SOUND_BLOCKS)) {
            return false;
        }
        if (!(block instanceof EntityBlock)) {
            return true;
        }
        return !DENIED_NAMESPACES.contains(namespace) && !DENIED_ITEMS.contains(fullItemId);
    }
}
