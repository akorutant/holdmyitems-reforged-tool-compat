/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.InputConstants$Type
 *  com.mojang.logging.LogUtils
 *  net.minecraft.client.KeyMapping
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.packs.PackLocationInfo
 *  net.minecraft.server.packs.PackSelectionConfig
 *  net.minecraft.server.packs.PackType
 *  net.minecraft.server.packs.PathPackResources$PathResourcesSupplier
 *  net.minecraft.server.packs.repository.Pack
 *  net.minecraft.server.packs.repository.Pack$Position
 *  net.minecraft.server.packs.repository.Pack$ResourcesSupplier
 *  net.minecraft.server.packs.repository.PackSource
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.ModContainer
 *  net.neoforged.fml.ModList
 *  net.neoforged.fml.common.Mod
 *  net.neoforged.fml.config.IConfigSpec
 *  net.neoforged.fml.config.ModConfig$Type
 *  net.neoforged.neoforge.client.event.EntityRenderersEvent$AddLayers
 *  net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent
 *  net.neoforged.neoforge.event.AddPackFindersEvent
 *  org.lwjgl.glfw.GLFW
 *  org.slf4j.Logger
 */
package de.bene2212.holdmyitemsnf;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.logging.LogUtils;
import de.bene2212.holdmyitemsnf.config.HoldMyItemsClientConfig;
import de.bene2212.holdmyitemsnf.util.SkullHelper;
import java.nio.file.Path;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;

@Mod(value="holdmyitemsnf")
public class Holdmyitemsnf {
    private static double prevTime = 0.0;
    public static double deltaTime = 0.0;
    public static KeyMapping CUSTOM_KEY;
    public static final String MODID = "holdmyitemsnf";
    private static final Logger LOGGER;

    public static void updateDeltatime() {
        double currentTime = GLFW.glfwGetTime();
        deltaTime = currentTime - prevTime;
        prevTime = currentTime;
        deltaTime = Minecraft.getInstance().isPaused() ? 0.0 : Math.min(0.05, deltaTime);
    }

    public Holdmyitemsnf(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::registerKeyMappings);
        modEventBus.addListener(this::onAddLayers);
        modEventBus.addListener(this::addPackFinders);
        modContainer.registerConfig(ModConfig.Type.CLIENT, (IConfigSpec)HoldMyItemsClientConfig.CLIENT_CONFIG);
    }

    @SubscribeEvent
    public void onAddLayers(EntityRenderersEvent.AddLayers event) {
        SkullHelper.init(Minecraft.getInstance().getEntityModels());
    }

    @SubscribeEvent
    public void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById(MODID).getFile().findResource(new String[]{"test_nested_resource_pack"});
            PathPackResources.PathResourcesSupplier supplier = new PathPackResources.PathResourcesSupplier(resourcePath);
            String id = "builtin/add_pack_finders_test";
            PackLocationInfo location = new PackLocationInfo(id, (Component)Component.literal((String)"HMI 3D Buckets"), PackSource.BUILT_IN, null);
            PackSelectionConfig selectionConfig = new PackSelectionConfig(true, Pack.Position.TOP, false);
            Pack pack = Pack.readMetaAndCreate((PackLocationInfo)location, (Pack.ResourcesSupplier)supplier, (PackType)PackType.CLIENT_RESOURCES, (PackSelectionConfig)selectionConfig);
            event.addRepositorySource(packConsumer -> packConsumer.accept(pack));
        }
    }

    private void registerKeyMappings(RegisterKeyMappingsEvent event) {
        CUSTOM_KEY = new KeyMapping("key.holdmyitemsnf.inspect", InputConstants.Type.KEYSYM, 74, "key.categories.holdmyitemsnf");
        event.register(CUSTOM_KEY);
    }

    static {
        LOGGER = LogUtils.getLogger();
    }
}
