package mrthomas20121.natures_construct.datagen;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

import javax.annotation.Nonnull;

public class NatureMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Nonnull
    @Override
    public String getName() {
        return "Nature's Construct Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {
        buildMaterial(NatureMaterialIds.sky)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF336278).addARGB(102, 0xFF427C96).addARGB(140, 0xFF5599B2).addARGB(178, 0xFF72BBC5).addARGB(216, 0xFF99EDE4).addARGB(255, 0xFFB3FFF2).build());
        buildMaterial(NatureMaterialIds.infused_iron)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF202B01).addARGB(102, 0xFF2D4905).addARGB(140, 0xFF286009).addARGB(178, 0xFF2D750F).addARGB(216, 0xFF2BA325).addARGB(255, 0xFF38C241).build());
        buildMaterial(NatureMaterialIds.tainted_gold)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF2D2516).addARGB(102, 0xFF563A13).addARGB(140, 0xFF89571A).addARGB(178, 0xFFA06521).addARGB(216, 0xFFC4762D).addARGB(255, 0xFFE58130).build());
    }
}
