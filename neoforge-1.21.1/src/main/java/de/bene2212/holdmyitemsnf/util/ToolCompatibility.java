package de.bene2212.holdmyitemsnf.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;

public final class ToolCompatibility {
    private static final ResourceLocation CREATE_WRENCH =
            ResourceLocation.fromNamespaceAndPath("create", "wrench");

    private ToolCompatibility() {
    }

    public static boolean isTaggedTool(ItemStack stack) {
        return !stack.isEmpty() && stack.is(HoldMyItemsTags.TOOLS);
    }

    public static boolean isCreateWrench(ItemStack stack) {
        return !stack.isEmpty()
                && CREATE_WRENCH.equals(BuiltInRegistries.ITEM.getKey(stack.getItem()));
    }

    public static boolean canInspect(ItemStack stack, float attackDamage) {
        return !stack.isEmpty()
                && (isTaggedTool(stack)
                || isCreateWrench(stack)
                || attackDamage > 0.0f
                || stack.getItem() instanceof HoeItem);
    }
}
