package com.combatzak.mojo.redmetal.common.data;

import com.combatzak.mojo.redmetal.RedMetal;
import com.combatzak.mojo.redmetal.items.RedMetalFluids;
import net.minecraft.data.DataGenerator;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;
import static slimeknights.tconstruct.TConstruct.getResource;

public class FluidTextureProvider extends AbstractFluidTextureProvider {
    public FluidTextureProvider(DataGenerator generator) {
        super(generator, RedMetal.MODID);
    }

    @Override
    public String getName() {
        return "Mojo-RedMetal - Fluid Textures";
    }

    @Override
    public void addTextures() {
        namedTcon(RedMetalFluids.MOLTEN_REDMETAL, "molten/stone").color(0xFAC10E0E);
    }

    private FluidTexture.Builder namedTcon(FluidObject<?> fluid, String name) {
        return texture(fluid).textures(getResource("fluid/" + name + "/"), false, false);
    }
}
