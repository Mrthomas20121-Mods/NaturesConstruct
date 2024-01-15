package mrthomas20121.natures_construct.util;

import mrthomas20121.natures_construct.init.NatureFluids;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.block.entity.MantleBlockEntity;
import slimeknights.tconstruct.library.fluid.FluidTankAnimated;

public class NatureFluidTank extends FluidTankAnimated {


    public NatureFluidTank(int capacity, MantleBlockEntity parent) {
        super(capacity, parent);
    }

    @Override
    public boolean isFluidValid(FluidStack stack) {
        return stack.getFluid().isSame(NatureFluids.AURA.get().getSource());
    }
}
