package com.combatzak.mojo.redmetal.common.data;

import com.combatzak.mojo.redmetal.RedMetal;
import com.combatzak.mojo.redmetal.items.RedMetalFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.mantle.registration.object.FlowingFluidObject;

public class FluidTagProvider extends FluidTagsProvider {
    public FluidTagProvider(DataGenerator generatorIn, ExistingFileHelper helper) {
        super(generatorIn, RedMetal.MODID, helper);
    }

    @Override
    public void addTags() {
        tagAll(RedMetalFluids.MOLTEN_REDMETAL);
    }

    @Override
    public String getName() {
        return "Mojo-Redmetal Fluid Tags";
    }

    private void tagLocal(FlowingFluidObject<?> fluid) {
        String name = fluid.getLocalTag().location().getPath();
        tag(fluid.getLocalTag()).addOptional(resource(name)).addOptional(resource("flowing_" + name));
    }

    private void tagAll(FlowingFluidObject<?> fluid) {
        tagLocal(fluid);
        tag(fluid.getForgeTag()).addOptionalTag(fluid.getLocalTag().location());
    }

    public static ResourceLocation resource(String path) {
        return location(RedMetal.MODID, path);
    }

    public static ResourceLocation location(String modid, String name) {
        return new ResourceLocation(modid, name);
    }
}
