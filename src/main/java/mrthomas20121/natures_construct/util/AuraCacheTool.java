package mrthomas20121.natures_construct.util;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.container.IAuraContainer;
import de.ellpeck.naturesaura.api.aura.container.ItemAuraContainer;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import mrthomas20121.natures_construct.NaturesConstruct;
import mrthomas20121.natures_construct.init.NatureModifiers;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import slimeknights.tconstruct.library.tools.capability.ToolCapabilityProvider;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class AuraCacheTool implements ToolCapabilityProvider.IToolCapabilityProvider {

    private final LazyOptional<ItemToolAuraContainer> cap;

    public static ResourceLocation MAX_AURA = new ResourceLocation(NaturesConstruct.MOD_ID, "max_aura");
    public static ResourceLocation STORED_AURA = new ResourceLocation(NaturesConstruct.MOD_ID, "stored_aura");

    public AuraCacheTool(ItemStack stack, Supplier<? extends IToolStackView> toolStack) {
        this.cap = LazyOptional.of(() -> new ItemToolAuraContainer(stack, toolStack.get(), null));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull IToolStackView tool, @Nonnull Capability<T> cap) {
        if(tool.getVolatileData().contains(MAX_AURA, Tag.TAG_INT) && (cap == NaturesAuraAPI.CAP_AURA_CONTAINER)) {
            return this.cap.cast();
        }

        return LazyOptional.empty();
    }

    /**
     * Extension of {@link ItemAuraContainerCopy} to work with tinkers tools
     */
    public static class ItemToolAuraContainer extends ItemAuraContainerCopy implements IAuraContainer {
        protected final IToolStackView toolstack;

        public ItemToolAuraContainer(ItemStack stack, IToolStackView toolstack, IAuraType type) {
            super(stack, type, 200);
            this.toolstack = toolstack;
        }

        protected void setAura(int amount) {
            if (!this.toolstack.getPersistentData().contains(STORED_AURA, Tag.TAG_INT)) {
                this.toolstack.getPersistentData().putInt(STORED_AURA, 0);
            }

            this.toolstack.getPersistentData().putInt(STORED_AURA, this.toolstack.getPersistentData().getInt(STORED_AURA)+amount);
            super.setAura(amount);
        }

        public int getMaxAura() {
            return this.toolstack.getVolatileData().getInt(MAX_AURA);
        }
    }
}
