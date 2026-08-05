/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.client.event.RenderFrameEvent$Pre
 */
package de.bene2212.holdmyitemsnf.event;

import de.bene2212.holdmyitemsnf.Holdmyitemsnf;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderFrameEvent;

@EventBusSubscriber(modid="holdmyitemsnf", bus=EventBusSubscriber.Bus.GAME, value={Dist.CLIENT})
public class ClientEventHandler {
    @SubscribeEvent
    public static void onRender(RenderFrameEvent.Pre event) {
        Holdmyitemsnf.updateDeltatime();
    }
}
