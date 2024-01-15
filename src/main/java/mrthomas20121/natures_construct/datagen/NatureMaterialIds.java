package mrthomas20121.natures_construct.datagen;

import mrthomas20121.natures_construct.NaturesConstruct;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

import static slimeknights.tconstruct.library.materials.definition.MaterialVariantId.create;

public class NatureMaterialIds {

    public static MaterialVariantId ancient_wood = create(MaterialIds.wood, "ancient_wood");
    public static MaterialId infused_iron = id("infused_iron");
    public static MaterialId tainted_gold = id("tainted_gold");
    public static MaterialId polyaurallum = id("polyaurallum");
    public static MaterialId sky = id("sky");
    public static MaterialId gold_leaf = id("gold_leaf");

    private static MaterialId id(String name) {
        return new MaterialId(NaturesConstruct.MOD_ID, name);
    }
}
