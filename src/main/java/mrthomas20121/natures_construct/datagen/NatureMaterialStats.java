package mrthomas20121.natures_construct.datagen;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

import javax.annotation.Nonnull;

import static net.minecraft.world.item.Tiers.*;

public class NatureMaterialStats extends AbstractMaterialStatsDataProvider {

    public NatureMaterialStats(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    protected void addMaterialStats() {
        addMaterialStats(NatureMaterialIds.infused_iron,
                new HeadMaterialStats(300, 6.1f, IRON, 2.1f),
                HandleMaterialStats.DEFAULT.withDurability(1.15f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(NatureMaterialIds.sky,
                new HeadMaterialStats(300, 6.5f, DIAMOND, 2.5f),
                HandleMaterialStats.DEFAULT.withAttackSpeed(1.1f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(NatureMaterialIds.polyaurallum,
                new HeadMaterialStats(900, 6.3f, DIAMOND, 3f),
                HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.05f).withAttackSpeed(1.05f),
                ExtraMaterialStats.DEFAULT);

        // Bows
        addMaterialStats(NatureMaterialIds.sky,
                new LimbMaterialStats(300, 0.01f, 0.1f, 0.05f),
                new GripMaterialStats(1.2f, 0.05f, 2.2f));

        addMaterialStats(NatureMaterialIds.infused_iron,
                new LimbMaterialStats(300, -0.1f, 0.1f, 0.01f),
                new GripMaterialStats(1.1f, 0.01f, 2.1f));

        addMaterialStats(NatureMaterialIds.polyaurallum,
                new LimbMaterialStats(900, 0.09f, 0.09f, 0.09f),
                new GripMaterialStats(1.05f, 0.09f, 2.20f));

        addMaterialStats(NatureMaterialIds.gold_leaf, BowstringMaterialStats.DEFAULT);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Nature's Aura Materials Stats";
    }
}
