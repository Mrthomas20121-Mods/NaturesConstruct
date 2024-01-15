package mrthomas20121.natures_construct.block;

import de.ellpeck.naturesaura.blocks.tiles.ITickableBlockEntity;
import mrthomas20121.natures_construct.block.entity.AuraFuelGeneratorBlockEntity;
import mrthomas20121.natures_construct.init.NatureBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.smeltery.block.component.SearedBlock;
import slimeknights.tconstruct.smeltery.block.entity.component.TankBlockEntity;

import javax.annotation.Nonnull;

public class BlockAuraFuelGenerator extends SearedBlock implements TankBlockEntity.ITankBlock, EntityBlock {
    public BlockAuraFuelGenerator(Properties properties) {
        super(properties);
    }
    @Override
    public int getCapacity() {
        return 5000;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@Nonnull Level level, @Nonnull BlockState state, @Nonnull BlockEntityType<T> type) {
        return ITickableBlockEntity.createTickerHelper(type, NatureBlockEntities.AURA_FUEL__GENERATOR.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new AuraFuelGeneratorBlockEntity(pos, state);
    }
}
