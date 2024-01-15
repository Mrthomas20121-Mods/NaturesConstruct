package mrthomas20121.natures_construct.modifier;

import de.ellpeck.naturesaura.Helper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class MobAuraModifier extends Modifier {

    @Override
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {

        // if damaged add 10 aura to the chunk
        if(damageDealt > 0) {
            LivingEntity target = context.getAttacker();
            BlockPos pos = target.getOnPos();
            Helper.getAuraChunksWithSpotsInArea(target.getLevel(), pos, 4, auraChunk -> {
                auraChunk.storeAura(pos, 10);
            });
        }

        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
