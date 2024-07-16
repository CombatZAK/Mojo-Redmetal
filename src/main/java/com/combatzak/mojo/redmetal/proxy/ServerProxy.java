package com.combatzak.mojo.redmetal.proxy;

import com.combatzak.mojo.redmetal.RedMetal;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

public final class ServerProxy extends CommonProxy {
    public ServerProxy() {
        RedMetal.BUS.addListener(this::serverSetup);
    }

    public void serverSetup(FMLDedicatedServerSetupEvent event) {
    }
}
