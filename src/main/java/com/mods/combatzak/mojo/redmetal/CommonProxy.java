package com.mods.combatzak.mojo.redmetal;

import com.mods.combatzak.mojo.redmetal.fluids.FluidRegistry;
import com.mods.combatzak.mojo.redmetal.recipes.AlloyHandler;
import com.mods.combatzak.mojo.redmetal.recipes.CastingHandler;
import com.mods.combatzak.mojo.redmetal.recipes.MeltingHandler;

/**
 * Main proxy class used for server registrations
 * Created by CombatZAK on 5/15/2018.
 */
public class CommonProxy {
    public void registerFluid() {
        FluidRegistry.registerFluids();
    }

    public void registerRecipes() {
        MeltingHandler.registerMelting();
        AlloyHandler.registerAlloys();
        CastingHandler.registerCasting();
    }
}
