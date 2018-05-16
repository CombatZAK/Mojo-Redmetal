package com.mods.combatzak.mojo.redmetal.recipes;

import com.mods.combatzak.mojo.redmetal.fluids.FluidRegistry;
import mrtjp.projectred.core.PartDefs;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.events.TinkerRegisterEvent;

/**
 * Adds melting recipes to the Smeltery
 * Created by CombatZAK on 5/15/2018.
 */
public class MeltingHandler extends HandlerBase {
    public static void registerMelting() {
        TinkerRegistry.registerMelting(redMetalIngot, FluidRegistry.redMetal, 144);
    }
}
