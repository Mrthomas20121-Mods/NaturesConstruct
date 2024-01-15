package mrthomas20121.natures_construct.modifier;

import de.ellpeck.naturesaura.Helper;
import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class InfusedModifier extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        if(context.getAttacker() instanceof Player player) {
            BlockPos pos = player.getOnPos();
            int aura = NaturesAuraAPI.instance().getAuraInArea(player.getLevel(), pos, 16);
            if(aura > 10) {
                // try to extract aura from player, if it returns false, extract aura from the world instead
                if(!NaturesAuraAPI.instance().extractAuraFromPlayer(player, 10, false)) {
                    Helper.getAuraChunksWithSpotsInArea(player.getLevel(), pos, 16, auraChunk -> auraChunk.drainAura(pos, 10));
                    return super.getEntityDamage(tool, level, context, baseDamage, damage)*1.5f;
                }
                else {
                    // bonus damage is lower when extracting aura from the player inventory
                    return super.getEntityDamage(tool, level, context, baseDamage, damage)*1.2f;
                }
            }
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
