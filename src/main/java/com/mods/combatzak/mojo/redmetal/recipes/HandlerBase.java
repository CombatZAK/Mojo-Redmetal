package com.mods.combatzak.mojo.redmetal.recipes;

import mrtjp.projectred.core.PartDefs;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.world.TinkerWorld;

/**
 * Base class for handler operations
 * Created by CombatZAK on 5/15/2018.
 */
public class HandlerBase {
    protected static ItemStack redMetalIngot = PartDefs.REDINGOT().makeStack();
    protected static ItemStack ingotCast = TinkerSmeltery.castIngot;
}
