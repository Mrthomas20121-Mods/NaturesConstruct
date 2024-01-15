package mrthomas20121.natures_construct.datagen;

import mrthomas20121.natures_construct.init.NatureModifiers;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;

import javax.annotation.Nonnull;

public class NatureTraits extends AbstractMaterialTraitDataProvider {

    public NatureTraits(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(NatureMaterialIds.infused_iron, NatureModifiers.aura);
        addDefaultTraits(NatureMaterialIds.sky, NatureModifiers.infused);
        addDefaultTraits(NatureMaterialIds.polyaurallum, NatureModifiers.mob_aura);
        addDefaultTraits(NatureMaterialIds.tainted_gold, NatureModifiers.hellish_repair);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Nature's Construct Traits";
    }
}
