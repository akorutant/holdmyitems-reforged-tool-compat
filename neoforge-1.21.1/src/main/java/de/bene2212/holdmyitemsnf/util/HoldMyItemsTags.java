/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.block.Block
 */
package de.bene2212.holdmyitemsnf.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class HoldMyItemsTags {
    public static final TagKey<Block> GLASS_PANES = BlockTags.create((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"forge", (String)"glass_panes"));
    public static final TagKey<Item> TOOLS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "tools"));
    public static final TagKey<Item> GEMS_TAG = TagKey.create((ResourceKey)Registries.ITEM, (ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"forge", (String)"gems"));
    public static final TagKey<Block> CHAINS = BlockTags.create((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"forge", (String)"chains"));
    public static final TagKey<Block> REPLACEABLE_BY_MUSHROOMS = BlockTags.create((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"forge", (String)"replaceable_by_mushrooms"));
}
