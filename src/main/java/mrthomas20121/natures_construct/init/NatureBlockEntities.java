package mrthomas20121.natures_construct.init;

import mrthomas20121.natures_construct.NaturesConstruct;
import mrthomas20121.natures_construct.block.entity.AuraFuelGeneratorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.BlockEntityTypeDeferredRegister;

public class NatureBlockEntities {

    public static BlockEntityTypeDeferredRegister BLOCK_ENTITIES = new BlockEntityTypeDeferredRegister(NaturesConstruct.MOD_ID);

    public static RegistryObject<BlockEntityType<AuraFuelGeneratorBlockEntity>> AURA_FUEL__GENERATOR = BLOCK_ENTITIES.register("aura_fuel_generator", AuraFuelGeneratorBlockEntity::new, NatureBlocks.aura_fuel_generator);
}
