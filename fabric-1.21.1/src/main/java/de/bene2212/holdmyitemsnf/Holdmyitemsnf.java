package de.bene2212.holdmyitemsnf;

import com.mojang.blaze3d.platform.InputConstants;
import de.bene2212.holdmyitemsnf.config.HoldMyItemsClientConfig;
import de.bene2212.holdmyitemsnf.util.SkullHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import org.lwjgl.glfw.GLFW;

public final class Holdmyitemsnf implements ClientModInitializer {
    public static final String MODID = "holdmyitemsnf";
    public static double deltaTime;
    public static KeyMapping CUSTOM_KEY;

    private static double previousTime;

    @Override
    public void onInitializeClient() {
        HoldMyItemsClientConfig.load();

        CUSTOM_KEY = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.holdmyitemsnf.inspect",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                "key.categories.holdmyitemsnf"
        ));

        ClientLifecycleEvents.CLIENT_STARTED.register(client -> previousTime = GLFW.glfwGetTime());
        WorldRenderEvents.START.register(context -> updateDeltatime());
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, renderer, helper, context) -> {
            if (SkullHelper.SKULL_MODELS == null) {
                SkullHelper.init(context.getModelSet());
            }
        });

        FabricLoader.getInstance().getModContainer(MODID).ifPresent(container ->
                ResourceManagerHelper.registerBuiltinResourcePack(
                        ResourceLocation.fromNamespaceAndPath(MODID, "hmi_3d_buckets"),
                        container,
                        Component.literal("HMI 3D Buckets"),
                        ResourcePackActivationType.ALWAYS_ENABLED
                )
        );
    }

    public static void updateDeltatime() {
        double currentTime = GLFW.glfwGetTime();
        deltaTime = previousTime == 0.0 ? 0.0 : currentTime - previousTime;
        previousTime = currentTime;
        deltaTime = Minecraft.getInstance().isPaused() ? 0.0 : Math.min(0.05, deltaTime);
    }
}
