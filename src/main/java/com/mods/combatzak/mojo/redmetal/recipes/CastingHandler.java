package com.mods.combatzak.mojo.redmetal.recipes;

import com.mods.combatzak.mojo.redmetal.fluids.FluidRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;

/**
 * Created by CombatZAK on 5/15/2018.
 */
public class CastingHandler extends HandlerBase {
    public static void registerCasting() {
        TinkerRegistry.registerTableCasting(redMetalIngot, ingotCast, FluidRegistry.redMetal, 144);
    }
}
