package com.misanthropy.linggango.celestisynth_fix;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.thecelestialworkshop.celestisynth.api.animation.player.CSAnimator;

@Mod(Celestisynth_memory_leak_fix.MODID)
@Mod.EventBusSubscriber(modid = Celestisynth_memory_leak_fix.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class Celestisynth_memory_leak_fix {

    public static final String MODID = "celestisynth_fix";

    public Celestisynth_memory_leak_fix() {
    }

    @SubscribeEvent
    public static void onWorldUnload(LevelEvent.Unload event) {
        if (event.getLevel().isClientSide()) {
            CSAnimator.animationData.clear();
            CSAnimator.otherAnimationData.clear();
            CSAnimator.mirroredAnimationData.clear();
        }
    }

    @SubscribeEvent
    public static void onPlayerLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        CSAnimator.animationData.clear();
        CSAnimator.otherAnimationData.clear();
        CSAnimator.mirroredAnimationData.clear();
    }
}