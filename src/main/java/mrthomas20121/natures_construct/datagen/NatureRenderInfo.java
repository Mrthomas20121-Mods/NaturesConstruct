package mrthomas20121.natures_construct.datagen;

import net.minecraft.data.DataGenerator;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

import javax.annotation.Nonnull;

public class NatureRenderInfo extends AbstractMaterialRenderInfoProvider {


    public NatureRenderInfo(DataGenerator gen, @Nullable AbstractMaterialSpriteProvider materialSprites) {
        super(gen, materialSprites);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(NatureMaterialIds.gold_leaf).color(0x0).fallbacks("string");
    }

    @Nonnull
    @Override
    public String getName() {
        return "Nature's Construct Render Info";
    }
}
