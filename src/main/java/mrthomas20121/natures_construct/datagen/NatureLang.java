package mrthomas20121.natures_construct.datagen;

import mrthomas20121.natures_construct.NaturesConstruct;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class NatureLang extends LanguageProvider {

    public NatureLang(DataGenerator gen) {
        super(gen, NaturesConstruct.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

    }

    private void addModifier(String modifierName, String desc, String flavor) {

        add(String.format("modifier.natures_construct.%s.name", modifierName.toLowerCase()), modifierName);
        add(String.format("modifier.natures_construct.%s.desc", modifierName.toLowerCase()), desc);
        add(String.format("modifier.natures_construct.%s.flavor", modifierName.toLowerCase()), flavor);
    }
}
