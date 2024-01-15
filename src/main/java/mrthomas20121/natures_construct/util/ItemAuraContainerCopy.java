package mrthomas20121.natures_construct.util;

import de.ellpeck.naturesaura.api.aura.container.IAuraContainer;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

/**
 * Exact copy of {@link de.ellpeck.naturesaura.api.aura.container.ItemAuraContainer} but with setAura protected instead of private
 */
public class ItemAuraContainerCopy implements IAuraContainer {
    protected final ItemStack stack;
    protected final IAuraType type;
    protected final int maxAura;

    public ItemAuraContainerCopy(ItemStack stack, IAuraType type, int maxAura) {
        this.stack = stack;
        this.type = type;
        this.maxAura = maxAura;
    }

    public int storeAura(int amountToStore, boolean simulate) {
        int aura = this.getStoredAura();
        int actual = Math.min(amountToStore, this.getMaxAura() - aura);
        if (!simulate) {
            this.setAura(aura + actual);
        }

        return actual;
    }

    public int drainAura(int amountToDrain, boolean simulate) {
        int aura = this.getStoredAura();
        int actual = Math.min(amountToDrain, aura);
        if (!simulate) {
            this.setAura(aura - actual);
        }

        return actual;
    }

    protected void setAura(int amount) {
        if (!this.stack.hasTag()) {
            this.stack.setTag(new CompoundTag());
        }

        this.stack.getTag().putInt("aura", amount);
    }

    public int getStoredAura() {
        return this.stack.hasTag() ? this.stack.getTag().getInt("aura") : 0;
    }

    public int getMaxAura() {
        return this.maxAura;
    }

    public int getAuraColor() {
        return 4368060;
    }

    public boolean isAcceptableType(IAuraType type) {
        return this.type == null || this.type == type;
    }
}
