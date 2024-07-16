package com.combatzak.mojo.redmetal.common;

import com.combatzak.mojo.redmetal.RedMetal;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import net.minecraftforge.eventbus.api.IEventBus;

public abstract class RedMetalModule {
    protected static FluidDeferredRegister FLUID_REGISTRY;

    public static void initRegistries(IEventBus bus) {
        FLUID_REGISTRY = new FluidDeferredRegister(RedMetal.MODID);

        FLUID_REGISTRY.register(bus);
    }
}
