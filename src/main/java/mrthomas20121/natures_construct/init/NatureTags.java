package mrthomas20121.natures_construct.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class NatureTags {

    public static class Blocks {

        public TagKey<Block> BlockPolyaurallum = create("forge:storage_blocks/polyaurallum");
        private static TagKey<Block> create(String str) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(str));
        }
    }

    public static class Items {

        public TagKey<Item> BlockPolyaurallum = create("forge:storage_blocks/polyaurallum");
        public TagKey<Item> ingotPolyaurallum = create("forge:ingots/polyaurallum");
        public TagKey<Item> nuggetPolyaurallum = create("forge:nuggets/polyaurallum");
        public TagKey<Item> nuggetInfusedIron = create("forge:nuggets/infused_iron");
        public TagKey<Item> nuggetSky = create("forge:nuggets/sky");
        public TagKey<Item> nuggetTaintedGold = create("forge:nuggets/tainted_gold");
        private static TagKey<Item> create(String str) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(str));
        }
    }

    public static class Fluids {
        private static TagKey<Fluid> create(String str) {
            return TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation(str));
        }
    }
}
