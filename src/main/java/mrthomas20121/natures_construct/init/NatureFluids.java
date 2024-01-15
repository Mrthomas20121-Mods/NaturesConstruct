package mrthomas20121.natures_construct.init;

import mrthomas20121.natures_construct.NaturesConstruct;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;

public class NatureFluids {

    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(NaturesConstruct.MOD_ID);

    public static FluidObject<ForgeFlowingFluid> INFUSED_IRON = register("infused_iron", 1100);
    public static FluidObject<ForgeFlowingFluid> SKY = register("sky", 1000);
    public static FluidObject<ForgeFlowingFluid> TAINTED_GOLD = register("tained_gold", 1200);
    public static FluidObject<ForgeFlowingFluid> POLYAURALLUM = register("polyaurallum", 1200);

    public static FluidObject<ForgeFlowingFluid> AURA = register("aura", 1000);

    private static FluidObject<ForgeFlowingFluid> register(String name, int temp) {
        String still = String.format("%s:block/fluid/%s/still", NaturesConstruct.MOD_ID, name);
        String flow = String.format("%s:block/fluid/%s/flowing", NaturesConstruct.MOD_ID, name);
        return FLUIDS.register(name, FluidAttributes.builder(new ResourceLocation(still), new ResourceLocation(flow)).density(2000).viscosity(10000).temperature(temp).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA), Material.LAVA, 15);
    }
}
