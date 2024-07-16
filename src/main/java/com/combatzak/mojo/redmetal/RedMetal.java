package com.combatzak.mojo.redmetal;

import com.combatzak.mojo.redmetal.common.RedMetalModule;
import com.combatzak.mojo.redmetal.common.data.FluidTagProvider;
import com.combatzak.mojo.redmetal.common.data.FluidTextureProvider;
import com.combatzak.mojo.redmetal.proxy.ClientProxy;
import com.combatzak.mojo.redmetal.proxy.ServerProxy;
import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import slimeknights.tconstruct.fluids.data.FluidBlockstateModelProvider;
import slimeknights.tconstruct.fluids.data.FluidBucketModelProvider;

@Mod(RedMetal.MODID)
@Mod.EventBusSubscriber(modid = RedMetal.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedMetal {
    public static final String MODID = "mojo_redmetal";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static RedMetal INSTANCE;
    public static IEventBus BUS;

    public RedMetal() {
        BUS = FMLJavaModLoadingContext.get().getModEventBus();
        INSTANCE = this;

        MinecraftForge.EVENT_BUS.register(INSTANCE);

        RedMetalModule.initRegistries(RedMetal.BUS);

        DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        boolean server = event.includeServer();
        boolean client = event.includeClient();
        ExistingFileHelper helper = event.getExistingFileHelper();

        dataGenerator.addProvider(server, new FluidTagProvider(dataGenerator, helper));
        dataGenerator.addProvider(server, new FluidTextureProvider(dataGenerator));
        dataGenerator.addProvider(client, new FluidBucketModelProvider(dataGenerator, RedMetal.MODID));
        dataGenerator.addProvider(client, new FluidBlockstateModelProvider(dataGenerator, RedMetal.MODID));
    }
}
