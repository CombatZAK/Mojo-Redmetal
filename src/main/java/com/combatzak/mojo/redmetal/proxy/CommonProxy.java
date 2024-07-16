package com.combatzak.mojo.redmetal.proxy;

import net.minecraft.core.Registry;

import com.combatzak.mojo.redmetal.items.RedMetalFluids;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

public class CommonProxy {
    CommonProxy() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RedMetalFluids.init();
        registerListeners(bus);
    }

    public void registerListeners(IEventBus bus) {
        bus.register(Listeners.class);
    }

    public static final class Listeners {
        @SubscribeEvent
        public static void setup(FMLCommonSetupEvent event) {
            RedMetalFluids.setup(event);
        }
    }
}
