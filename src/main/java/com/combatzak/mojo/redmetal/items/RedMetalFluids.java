package com.combatzak.mojo.redmetal.items;

import com.combatzak.mojo.redmetal.RedMetal;
import com.combatzak.mojo.redmetal.common.RedMetalModule;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static slimeknights.tconstruct.fluids.block.BurningLiquidBlock.createBurning;

public class RedMetalFluids extends RedMetalModule {
    public static FlowingFluidObject<ForgeFlowingFluid> MOLTEN_REDMETAL;

    public static void init() {
        MOLTEN_REDMETAL = FLUID_REGISTRY.register("redmetal").type(hot("redmetal").temperature(1050).lightLevel(10)).block(createBurning(10, 10, 5f)).bucket().flowing();
    }

    public static void setup(FMLCommonSetupEvent event) {
        DispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            @Override
            public ItemStack execute(BlockSource source, ItemStack stack) {
                DispensibleContainerItem container = (DispensibleContainerItem)stack.getItem();
                BlockPos blockPos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
                Level level = source.getLevel();

                if (container.emptyContents(null, level, blockPos, null)) {
                    container.checkExtraContent(null, level, stack, blockPos);

                    return new ItemStack(Items.BUCKET);
                }
                else {
                    return this.defaultDispenseItemBehavior.dispense(source, stack);
                }
            }
        };

        event.enqueueWork(() -> {
            DispenserBlock.registerBehavior(MOLTEN_REDMETAL, dispenseItemBehavior);
        });
    }

    public static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .descriptionId(makeDescriptionId("fluid", name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA);
    }

    public static String makeDescriptionId(String type, String name) {
        return type + "." + RedMetal.MODID + "." + name;
    }
}
