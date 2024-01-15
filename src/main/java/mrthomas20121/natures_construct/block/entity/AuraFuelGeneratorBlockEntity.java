package mrthomas20121.natures_construct.block.entity;

import de.ellpeck.naturesaura.Helper;
import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.blocks.tiles.ITickableBlockEntity;
import mrthomas20121.natures_construct.init.NatureFluids;
import mrthomas20121.natures_construct.util.NatureFluidTank;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import slimeknights.tconstruct.library.fluid.FluidTankAnimated;
import slimeknights.tconstruct.library.fluid.IFluidTankUpdater;
import slimeknights.tconstruct.library.utils.NBTTags;
import slimeknights.tconstruct.smeltery.block.entity.ITankBlockEntity;
import slimeknights.tconstruct.smeltery.block.entity.component.SmelteryComponentBlockEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AuraFuelGeneratorBlockEntity extends SmelteryComponentBlockEntity implements ITickableBlockEntity, ITankBlockEntity {

    private final FluidTankAnimated tank;
    private final LazyOptional<IFluidHandler> holder;

    private int strength;
    public AuraFuelGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
        tank = new FluidTankAnimated(5000, this);
        holder = LazyOptional.of(() -> tank);
    }

    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return holder.cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void tick() {
        if(this.level != null) {
            if (!this.level.isClientSide) {
                if(NaturesAuraAPI.instance().getAuraInArea(this.level, this.worldPosition, 16) >= 20) {
                    Helper.getAuraChunksWithSpotsInArea(this.level, this.worldPosition, 16, auraChunk -> {
                        auraChunk.drainAura(this.worldPosition, 20);
                        tank.fill(new FluidStack(NatureFluids.AURA.get().getSource(), 50), IFluidHandler.FluidAction.EXECUTE);
                    });
                }
            }
        }
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        holder.invalidate();
    }

    @Nonnull
    @Override
    public FluidTankAnimated getTank() {
        return this.tank;
    }

    @Override
    public void updateFluidTo(FluidStack fluid) {
        ITankBlockEntity.super.updateFluidTo(fluid);
    }

    /**
     * Updates the tank from an NBT tag, used in the block
     * @param nbt  tank NBT
     */
    public void updateTank(CompoundTag nbt) {
        if (nbt.isEmpty()) {
            tank.setFluid(FluidStack.EMPTY);
        } else {
            tank.readFromNBT(nbt);
            if (level != null) {
                level.getLightEngine().checkBlock(worldPosition);
            }
        }
    }

    @Override
    protected boolean shouldSyncOnUpdate() {
        return true;
    }

    @Override
    public void load(CompoundTag tag) {
        tank.setCapacity(5000);
        updateTank(tag.getCompound(NBTTags.TANK));
        super.load(tag);
    }

    @Override
    public void saveSynced(@Nonnull CompoundTag tag) {
        super.saveSynced(tag);
        // want tank on the client on world load
        if (!tank.isEmpty()) {
            tag.put(NBTTags.TANK, tank.writeToNBT(new CompoundTag()));
        }
    }

    @Override
    public int getLastStrength() {
        return this.strength;
    }

    @Override
    public void setLastStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void onTankContentsChanged() {
        ITankBlockEntity.super.onTankContentsChanged();
    }
}
