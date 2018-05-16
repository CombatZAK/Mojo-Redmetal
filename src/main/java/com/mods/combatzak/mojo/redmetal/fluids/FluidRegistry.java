package com.mods.combatzak.mojo.redmetal.fluids;

import net.minecraft.item.EnumRarity;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.fluid.FluidColored;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

/**
 * Created by CombatZAK on 5/15/2018.
 */
public class FluidRegistry {
    /**
     * Redmetal fluid reference
     */
    public static FluidMolten redMetal;

    public static BlockMolten blockRedMetal;

    public static void registerFluids() {
        net.minecraftforge.fluids.FluidRegistry.enableUniversalBucket();

        redMetal = new FluidMolten("redmetal", 0xF00912, FluidMolten.ICON_LiquidStill, FluidMolten.ICON_LiquidFlowing);
        redMetal.setTemperature(575);
        redMetal.setRarity(EnumRarity.RARE);

        redMetal.setUnlocalizedName(Util.prefix(redMetal.getName()));
        net.minecraftforge.fluids.FluidRegistry.registerFluid(redMetal);
        blockRedMetal = TinkerFluids.registerMoltenBlock(ForgeRegistries.BLOCKS, redMetal);
    }
}
