package mrthomas20121.natures_construct.modifier;

import de.ellpeck.naturesaura.Helper;
import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class AuraModifier extends Modifier {

    @Override
    public void onInventoryTick(@Nonnull IToolStackView tool, int level, @Nonnull Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {

        // only execute if the tool is damageable
        if(tool.getDamage() > 0 && !tool.isUnbreakable()) {
            if(holder instanceof Player player) {
                int aura = NaturesAuraAPI.instance().getAuraInArea(world, holder.getOnPos(), 16);
                // make sure there is at least 10 aura in the chunk
                if(aura > 10) {
                    // try to extract aura from player, if it returns false, extract aura from the world instead
                    if(!NaturesAuraAPI.instance().extractAuraFromPlayer(player, 10, false)) {
                        Helper.getAuraChunksWithSpotsInArea(world, holder.getOnPos(), 16, auraChunk -> {
                            auraChunk.drainAura(holder.getOnPos(), 10);
                            ToolDamageUtil.repair(tool, 20);
                        });
                    }
                    else {
                        ToolDamageUtil.repair(tool, 20);
                    }
                }
            }
        }
    }
}
