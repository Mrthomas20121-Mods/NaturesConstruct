package mrthomas20121.natures_construct.datagen;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

import javax.annotation.Nonnull;

public class NatureMaterials extends AbstractMaterialDataProvider {

    public NatureMaterials(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void addMaterials() {
        addMaterial(NatureMaterialIds.gold_leaf, 1, ORDER_COMPAT + ORDER_GENERAL, true);
        addMaterial(NatureMaterialIds.infused_iron, 2, ORDER_COMPAT + ORDER_GENERAL, false);
        addMaterial(NatureMaterialIds.sky, 2, ORDER_COMPAT + ORDER_GENERAL, false);
        addMaterial(NatureMaterialIds.polyaurallum, 3, ORDER_COMPAT + ORDER_GENERAL, false);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Nature's Aura Materials";
    }
}
