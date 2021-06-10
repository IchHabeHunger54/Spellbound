package ihh.spellbound.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import javax.annotation.Nonnull;

public class DecayingBlock extends Block {
    public DecayingBlock(Block b) {
        super(Block.Properties.from(b).tickRandomly());
    }

    @Override
    public void randomTick(@Nonnull BlockState state, @Nonnull ServerWorld worldIn, @Nonnull BlockPos pos, Random rand) {
        if (rand.nextBoolean()) worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
    }
}
