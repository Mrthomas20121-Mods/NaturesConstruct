package mrthomas20121.natures_construct;

import mrthomas20121.natures_construct.init.*;
import mrthomas20121.natures_construct.util.AuraCacheTool;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.tools.capability.ToolCapabilityProvider;

@Mod(NaturesConstruct.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NaturesConstruct {

public static final String MOD_ID = "natures_construct";
	public static final Logger LOGGER = LogManager.getLogger();

	public NaturesConstruct() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		NatureBlocks.BLOCKS.register(bus);
		NatureItems.ITEMS.register(bus);
		NatureFluids.FLUIDS.register(bus);
		NatureBlockEntities.BLOCK_ENTITIES.register(bus);
		NatureModifiers.MODIFIERS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		ToolCapabilityProvider.register(AuraCacheTool::new);
	}
	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if (event.includeServer()) {
//			BlockTagsProvider blockTagsProvider = new BlueBlockTags(gen, fileHelper);
//			gen.addProvider(blockTagsProvider);
//			gen.addProvider(new BlueItemTags(gen, blockTagsProvider, fileHelper));
			//BlueMaterials materials = new BlueMaterials(gen);
			//gen.addProvider(materials);
			//gen.addProvider(new BlueMaterials.BlueSkiesMaterialStats(gen, materials));
			//gen.addProvider(new BlueMaterials.BlueSkiesTraits(gen, materials));
//			gen.addProvider(new BlueFluidTags(gen, fileHelper));
//			gen.addProvider(new BlueRecipes(gen));
		}
		if(event.includeClient()) {
//			gen.addProvider(new BlueLang(gen));
//			gen.addProvider(new BlueBlockStates(gen, fileHelper));
//			gen.addProvider(new BlueItemModels(gen, fileHelper));
			//AbstractMaterialSpriteProvider provider = new BlueMaterialSpriteProvider();
			//gen.addProvider(new BlueRenderInfo(gen, provider));
			//gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, new TinkerPartSpriteProvider(), provider));
		}
	}
}
