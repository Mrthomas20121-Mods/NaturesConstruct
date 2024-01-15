package mrthomas20121.natures_construct.modifier;

import mrthomas20121.natures_construct.util.AuraCacheTool;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import javax.annotation.Nonnull;
import java.util.List;

public class AuraCacheModifier extends Modifier {

    @Override
    public void addVolatileData(@Nonnull ToolRebuildContext context, int level, ModDataNBT volatileData) {
        volatileData.putInt(AuraCacheTool.MAX_AURA, 100*level);
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if(tool.getVolatileData().contains(AuraCacheTool.MAX_AURA, Tag.TAG_INT) && tool instanceof ToolStack toolStack) {
           tooltip.add(new TranslatableComponent("tooltip.natures_construct.aura_cache", toolStack.getPersistentData().get(AuraCacheTool.STORED_AURA)).withStyle(style -> style.withColor(TextColor.fromRgb(getColor()))));
        }
    }
}
