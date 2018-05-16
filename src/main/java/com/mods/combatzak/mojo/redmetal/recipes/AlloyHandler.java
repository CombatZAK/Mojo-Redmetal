package com.mods.combatzak.mojo.redmetal.recipes;

import cofh.thermalfoundation.init.TFFluids;
import com.mods.combatzak.mojo.redmetal.RedMetal;
import com.mods.combatzak.mojo.redmetal.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.shared.TinkerFluids;

/**
 * Adds alloy recipes to the smeltery
 * Created by CombatZAK on 5/15/2018.
 */
public class AlloyHandler extends HandlerBase {
    public static void registerAlloys() {
        TinkerRegistry.registerAlloy(new FluidStack(FluidRegistry.redMetal, 144), new FluidStack(TinkerFluids.iron, 144), new FluidStack(TFFluids.fluidRedstone, 400));
        TinkerRegistry.registerAlloy(new FluidStack(FluidRegistry.redMetal, 144), new FluidStack(TinkerFluids.copper, 288), new FluidStack(TFFluids.fluidRedstone, 300));
        TinkerRegistry.registerAlloy(new FluidStack(FluidRegistry.redMetal, 144), new FluidStack(TinkerFluids.tin, 432), new FluidStack(TFFluids.fluidRedstone, 200));
        TinkerRegistry.registerAlloy(new FluidStack(FluidRegistry.redMetal, 144), new FluidStack(TinkerFluids.aluminum, 576), new FluidStack(TFFluids.fluidRedstone, 100));
    }
}
