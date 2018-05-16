package com.mods.combatzak.mojo.redmetal;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * Mod class for Mojo-Redmetal
 * Created by CombatZAK on 5/15/2018.
 */
@Mod(modid = RedMetal.MODID, useMetadata = true)
public class RedMetal {
    public static final String MODID = "mojo-redmetal";

    public static Logger logger;

    @SidedProxy(serverSide = "com.mods.combatzak.mojo.redmetal.CommonProxy", clientSide = "com.mods.combatzak.mojo.redmetal.client.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.registerFluid();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRecipes();
    }
}
