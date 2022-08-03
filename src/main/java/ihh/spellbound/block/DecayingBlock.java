package ihh.spellbound.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class DecayingBlock extends Block {
    public DecayingBlock(Block b) {
        super(Block.Properties.of(b.defaultBlockState().getMaterial()).randomTicks());
    }

    @Override
    public void randomTick(@Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos, @Nonnull RandomSource rand) {
        super.randomTick(state, level, pos, rand);
        if (rand.nextBoolean()) {
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }
    }
}
