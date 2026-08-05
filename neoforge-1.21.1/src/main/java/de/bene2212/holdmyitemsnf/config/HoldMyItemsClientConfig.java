/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.neoforged.neoforge.common.ModConfigSpec
 *  net.neoforged.neoforge.common.ModConfigSpec$BooleanValue
 *  net.neoforged.neoforge.common.ModConfigSpec$Builder
 *  net.neoforged.neoforge.common.ModConfigSpec$ConfigValue
 *  net.neoforged.neoforge.common.ModConfigSpec$DoubleValue
 *  net.neoforged.neoforge.common.ModConfigSpec$IntValue
 */
package de.bene2212.holdmyitemsnf.config;

import java.util.List;
import net.neoforged.neoforge.common.ModConfigSpec;

public class HoldMyItemsClientConfig {
    public static final ModConfigSpec CLIENT_CONFIG;
    public static final ModConfigSpec.DoubleValue ANIMATION_SPEED;
    public static final ModConfigSpec.BooleanValue ENABLE_SWIMMING_ANIM;
    public static final ModConfigSpec.IntValue SWING_SPEED;
    public static final ModConfigSpec.BooleanValue ENABLE_CLIMB_AND_CRAWL;
    public static final ModConfigSpec.BooleanValue ENABLE_PUNCHING;
    public static final ModConfigSpec.DoubleValue VIEWMODEL_X_OFFSET;
    public static final ModConfigSpec.DoubleValue VIEWMODEL_Y_OFFSET;
    public static final ModConfigSpec.DoubleValue VIEWMODEL_Z_OFFSET;
    public static final ModConfigSpec.DoubleValue SWITCH_SPEED;
    public static final ModConfigSpec.BooleanValue MB3D_COMPAT;
    public static final ModConfigSpec.ConfigValue<List<? extends String>> MOD_IDS_TO_EXCLUDE;
    public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_IDS_TO_EXCLUDE;
    public static final ModConfigSpec.ConfigValue<List<? extends String>> RENDER_BLOCK_AS_ITEM;

    public static float getXOffset() {
        return ((Double)VIEWMODEL_X_OFFSET.get()).floatValue();
    }

    public static float getYOffset() {
        return ((Double)VIEWMODEL_Y_OFFSET.get()).floatValue();
    }

    public static float getZOffset() {
        return ((Double)VIEWMODEL_Z_OFFSET.get()).floatValue();
    }

    public static boolean isInRenderBlockAsItem(String itemID) {
        return ((List)RENDER_BLOCK_AS_ITEM.get()).contains(itemID);
    }

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.push("animations");
        ANIMATION_SPEED = builder.comment("Choose your preferred animation speed (0.5-1.5)").defineInRange("animationSpeed", 1.0, 0.5, 1.5);
        SWITCH_SPEED = builder.comment("Switch speed (0-10)").defineInRange("switchSpeed", 0.018, 0.0, 10.0);
        ENABLE_SWIMMING_ANIM = builder.comment("Enable or disable swimming animation").define("enableSwimmingAnimation", true);
        SWING_SPEED = builder.comment("Swing animation speed (6-12)").defineInRange("swingSpeed", 9, 6, 12);
        ENABLE_CLIMB_AND_CRAWL = builder.comment("Enable or disable climb and crawl animation").define("enableClimbAndCrawlAnimation", true);
        ENABLE_PUNCHING = builder.comment("Enable or disable punching animation").define("enablePunchingAnimation", true);
        builder.pop();
        builder.push("positions");
        VIEWMODEL_X_OFFSET = builder.comment("Viewmodel X Offset").defineInRange("viewmodelXOffset", 0.0, -10.0, 10.0);
        VIEWMODEL_Y_OFFSET = builder.comment("Viewmodel Y Offset").defineInRange("viewmodelYOffset", 0.0, -10.0, 10.0);
        VIEWMODEL_Z_OFFSET = builder.comment("Viewmodel Z Offset").defineInRange("viewmodelZOffset", 0.0, -10.0, 10.0);
        builder.pop();
        builder.push("misc");
        MB3D_COMPAT = builder.comment("Enable MB3D compatibility mode").define("mb3DCompat", false);
        builder.pop();
        builder.push("modRenderExclusions");
        MOD_IDS_TO_EXCLUDE = builder.comment("Mod IDs that should be excluded from custom rendering (entire mod).").defineListAllowEmpty("excludedModIds", List.of("pointblank", "jeg", "cataclysm"), obj -> obj instanceof String);
        ITEM_IDS_TO_EXCLUDE = builder.comment("Specific item IDs to exclude from custom rendering (e.g. 'modid:itemname').").defineListAllowEmpty("excludedItemIds", List.of(), obj -> obj instanceof String);
        RENDER_BLOCK_AS_ITEM = builder.comment("Skips the blockItem renderer, useful especially for create items because they're already 3D.").defineListAllowEmpty("renderBlockAsItem", List.of("create:cogwheel", "create:large_cogwheel", "create:shaft", "create:gearbox", "create:vertical_gearbox", "create:clutch", "create:gearshift", "create:encased_chain_drive", "create:adjustable_chain_gearshift", "create:belt_connector", "create:chain_conveyor", "create:creative_motor", "create:water_wheel", "create:large_water_wheel", "create:nozzle", "create:turntable", "create:hand_crank", "create:millstone", "create:crushing_wheel", "create:mechanical_press", "create:mechanical_mixer", "create:empty_blaze_burner", "create:blaze_burner", "create:depot", "create:weighted_ejector", "create:speedometer", "create:stressometer", "create:wooden_bracket", "create:metal_bracket", "create:schematicannon", "create:fluid_pipe", "create:mechanical_pump", "create:smart_fluid_pipe", "create:fluid_valve", "create:copper_valve_handle", "create:hose_pulley", "create:portable_fluid_interface", "create:steam_engine", "create:gantry_carriage", "create:gantry_shaft", "create:windmill_bearing", "create:mechanical_bearing", "create:clockwork_bearing", "create:rope_pulley", "create:elevator_pulley", "create:cart_assembler", "create:sticker", "create:contraption_controls", "create:mechanical_drill", "create:mechanical_saw", "create:deployer", "create:portable_storage_interface", "create:mechanical_harvester", "create:mechanical_plough", "create:mechanical_roller", "create:mechanical_crafter", "create:sequenced_gearshift", "create:flywheel", "create:rotation_speed_controller", "create:mechanical_arm", "create:controls", "create:andesite_funnel", "create:brass_funnel", "create:andesite_tunnel", "create:brass_tunnel", "create:package_frogport", "create:factory_gauge", "create:display_board", "create:peculiar_bell", "create:haunted_bell", "create:brown_toolbox", "create:clipboard"), obj -> obj instanceof String);
        builder.pop();
        CLIENT_CONFIG = builder.build();
    }
}
