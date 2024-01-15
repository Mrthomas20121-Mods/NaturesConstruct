package mrthomas20121.natures_construct.modifier;

import de.ellpeck.naturesaura.Helper;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class HellishRepairModifier extends Modifier {
    @Override
    public int onDamageTool(@Nonnull IToolStackView tool, int level, int amount, @Nullable LivingEntity holder) {
        if(holder != null && amount > 0) {
            Helper.getAuraChunksWithSpotsInArea(holder.getLevel(), holder.getOnPos(), 4, auraChunk -> {
                auraChunk.storeAura(holder.getOnPos(), (amount+1)*level);
            });
        }
        return super.onDamageTool(tool, level, amount, holder);
    }
}
