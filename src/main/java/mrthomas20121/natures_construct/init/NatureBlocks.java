package mrthomas20121.natures_construct.init;

import mrthomas20121.natures_construct.NaturesConstruct;
import mrthomas20121.natures_construct.block.BlockAuraFuelGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NatureBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NaturesConstruct.MOD_ID);

    public static RegistryObject<Block> polyaurallum_block = register("polyaurallum_block", BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.1f));
    public static RegistryObject<Block> aura_fuel_generator = register("aura_fuel_generator", () -> new BlockAuraFuelGenerator(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).randomTicks().strength(3f)));

    public static RegistryObject<Block> register(String name, BlockBehaviour.Properties properties) {
        RegistryObject<Block> blockData =  BLOCKS.register(name, () -> new Block(properties));
        NatureItems.ITEMS.register(name, () -> new BlockItem(blockData.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
        return blockData;
    }

    public static RegistryObject<Block> register(String name, Supplier<Block> block) {
        RegistryObject<Block> blockData =  BLOCKS.register(name, block);
        NatureItems.ITEMS.register(name, () -> new BlockItem(blockData.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
        return blockData;
    }
}
