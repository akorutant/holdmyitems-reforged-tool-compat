package de.bene2212.holdmyitemsnf.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.logging.LogUtils;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class HoldMyItemsClientConfig {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("holdmyitemsnf-fabric.json");

    public static final Value<Double> ANIMATION_SPEED = new Value<>(1.0);
    public static final Value<Boolean> ENABLE_SWIMMING_ANIM = new Value<>(true);
    public static final Value<Integer> SWING_SPEED = new Value<>(9);
    public static final Value<Boolean> ENABLE_CLIMB_AND_CRAWL = new Value<>(true);
    public static final Value<Boolean> ENABLE_PUNCHING = new Value<>(true);
    public static final Value<Double> VIEWMODEL_X_OFFSET = new Value<>(0.0);
    public static final Value<Double> VIEWMODEL_Y_OFFSET = new Value<>(0.0);
    public static final Value<Double> VIEWMODEL_Z_OFFSET = new Value<>(0.0);
    public static final Value<Double> SWITCH_SPEED = new Value<>(0.018);
    public static final Value<Boolean> MB3D_COMPAT = new Value<>(false);
    public static final Value<List<? extends String>> MOD_IDS_TO_EXCLUDE = new Value<>(List.of("pointblank", "jeg", "cataclysm"));
    public static final Value<List<? extends String>> ITEM_IDS_TO_EXCLUDE = new Value<>(List.of());
    public static final Value<List<? extends String>> RENDER_BLOCK_AS_ITEM = new Value<>(defaultBlockItems());

    private HoldMyItemsClientConfig() {
    }

    public static void load() {
        if (!Files.exists(CONFIG_PATH)) {
            save();
            return;
        }

        try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            ANIMATION_SPEED.set(readDouble(root, "animationSpeed", 1.0, 0.5, 1.5));
            SWITCH_SPEED.set(readDouble(root, "switchSpeed", 0.018, 0.0, 10.0));
            ENABLE_SWIMMING_ANIM.set(readBoolean(root, "enableSwimmingAnimation", true));
            SWING_SPEED.set(readInt(root, "swingSpeed", 9, 6, 12));
            ENABLE_CLIMB_AND_CRAWL.set(readBoolean(root, "enableClimbAndCrawlAnimation", true));
            ENABLE_PUNCHING.set(readBoolean(root, "enablePunchingAnimation", true));
            VIEWMODEL_X_OFFSET.set(readDouble(root, "viewmodelXOffset", 0.0, -10.0, 10.0));
            VIEWMODEL_Y_OFFSET.set(readDouble(root, "viewmodelYOffset", 0.0, -10.0, 10.0));
            VIEWMODEL_Z_OFFSET.set(readDouble(root, "viewmodelZOffset", 0.0, -10.0, 10.0));
            MB3D_COMPAT.set(readBoolean(root, "mb3DCompat", false));
            MOD_IDS_TO_EXCLUDE.set(readStrings(root, "excludedModIds", MOD_IDS_TO_EXCLUDE.get()));
            ITEM_IDS_TO_EXCLUDE.set(readStrings(root, "excludedItemIds", ITEM_IDS_TO_EXCLUDE.get()));
            RENDER_BLOCK_AS_ITEM.set(readStrings(root, "renderBlockAsItem", RENDER_BLOCK_AS_ITEM.get()));
        } catch (RuntimeException | IOException exception) {
            LOGGER.error("Could not read {}; using defaults", CONFIG_PATH, exception);
        }
    }

    private static void save() {
        JsonObject root = new JsonObject();
        root.addProperty("animationSpeed", ANIMATION_SPEED.get());
        root.addProperty("switchSpeed", SWITCH_SPEED.get());
        root.addProperty("enableSwimmingAnimation", ENABLE_SWIMMING_ANIM.get());
        root.addProperty("swingSpeed", SWING_SPEED.get());
        root.addProperty("enableClimbAndCrawlAnimation", ENABLE_CLIMB_AND_CRAWL.get());
        root.addProperty("enablePunchingAnimation", ENABLE_PUNCHING.get());
        root.addProperty("viewmodelXOffset", VIEWMODEL_X_OFFSET.get());
        root.addProperty("viewmodelYOffset", VIEWMODEL_Y_OFFSET.get());
        root.addProperty("viewmodelZOffset", VIEWMODEL_Z_OFFSET.get());
        root.addProperty("mb3DCompat", MB3D_COMPAT.get());
        root.add("excludedModIds", GSON.toJsonTree(MOD_IDS_TO_EXCLUDE.get()));
        root.add("excludedItemIds", GSON.toJsonTree(ITEM_IDS_TO_EXCLUDE.get()));
        root.add("renderBlockAsItem", GSON.toJsonTree(RENDER_BLOCK_AS_ITEM.get()));

        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
                GSON.toJson(root, writer);
            }
        } catch (IOException exception) {
            LOGGER.error("Could not write default config to {}", CONFIG_PATH, exception);
        }
    }

    public static boolean isInRenderBlockAsItem(String itemId) {
        return RENDER_BLOCK_AS_ITEM.get().contains(itemId);
    }

    private static boolean readBoolean(JsonObject root, String key, boolean fallback) {
        return root.has(key) ? root.get(key).getAsBoolean() : fallback;
    }

    private static int readInt(JsonObject root, String key, int fallback, int min, int max) {
        int value = root.has(key) ? root.get(key).getAsInt() : fallback;
        return Math.max(min, Math.min(max, value));
    }

    private static double readDouble(JsonObject root, String key, double fallback, double min, double max) {
        double value = root.has(key) ? root.get(key).getAsDouble() : fallback;
        return Math.max(min, Math.min(max, value));
    }

    private static List<? extends String> readStrings(JsonObject root, String key, List<? extends String> fallback) {
        if (!root.has(key) || !root.get(key).isJsonArray()) {
            return fallback;
        }
        List<String> result = new ArrayList<>();
        root.getAsJsonArray(key).forEach(element -> result.add(element.getAsString()));
        return List.copyOf(result);
    }

    private static List<String> defaultBlockItems() {
        return Arrays.asList(("create:cogwheel create:large_cogwheel create:shaft create:gearbox create:vertical_gearbox "
                + "create:clutch create:gearshift create:encased_chain_drive create:adjustable_chain_gearshift create:belt_connector "
                + "create:chain_conveyor create:creative_motor create:water_wheel create:large_water_wheel create:nozzle "
                + "create:turntable create:hand_crank create:millstone create:crushing_wheel create:mechanical_press "
                + "create:mechanical_mixer create:empty_blaze_burner create:blaze_burner create:depot create:weighted_ejector "
                + "create:speedometer create:stressometer create:wooden_bracket create:metal_bracket create:schematicannon "
                + "create:fluid_pipe create:mechanical_pump create:smart_fluid_pipe create:fluid_valve create:copper_valve_handle "
                + "create:hose_pulley create:portable_fluid_interface create:steam_engine create:gantry_carriage create:gantry_shaft "
                + "create:windmill_bearing create:mechanical_bearing create:clockwork_bearing create:rope_pulley create:elevator_pulley "
                + "create:cart_assembler create:sticker create:contraption_controls create:mechanical_drill create:mechanical_saw "
                + "create:deployer create:portable_storage_interface create:mechanical_harvester create:mechanical_plough create:mechanical_roller "
                + "create:mechanical_crafter create:sequenced_gearshift create:flywheel create:rotation_speed_controller create:mechanical_arm "
                + "create:controls create:andesite_funnel create:brass_funnel create:andesite_tunnel create:brass_tunnel "
                + "create:package_frogport create:factory_gauge create:display_board create:peculiar_bell create:haunted_bell "
                + "create:brown_toolbox create:clipboard").split(" "));
    }

    public static final class Value<T> {
        private T value;

        private Value(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }

        private void set(T value) {
            this.value = value;
        }
    }
}
