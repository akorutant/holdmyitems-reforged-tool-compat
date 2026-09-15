package de.bene2212.holdmyitemsnf.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class HoldMyItemsTags {
    public static final TagKey<Block> GLASS_PANES = blockTag("glass_panes");
    public static final TagKey<Item> TOOLS = itemTag("tools");
    public static final TagKey<Item> GEMS_TAG = itemTag("gems");
    public static final TagKey<Block> CHAINS = blockTag("chains");
    public static final TagKey<Block> REPLACEABLE_BY_MUSHROOMS = blockTag("replaceable_by_mushrooms");

    private HoldMyItemsTags() {
    }

    private static TagKey<Item> itemTag(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Block> blockTag(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
