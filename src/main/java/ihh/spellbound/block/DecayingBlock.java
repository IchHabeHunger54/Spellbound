package ihh.spellbound.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.Random;

public class DecayingBlock extends Block {
    public DecayingBlock(Block b) {
        super(Block.Properties.from(b).tickRandomly());
    }

    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerWorld worldIn, @Nonnull BlockPos pos, Random rand) {
        if (rand.nextBoolean()) worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
    }
}
