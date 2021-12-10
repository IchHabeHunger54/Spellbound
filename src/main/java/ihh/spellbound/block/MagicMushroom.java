package ihh.spellbound.block;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.annotation.Nonnull;

public abstract class MagicMushroom extends BushBlock {
    private static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
    private static final ArrayList<Direction> DIRECTIONS = Lists.newArrayList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    public MagicMushroom() {
        super(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.GRASS));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPE;
    }

    @Nonnull
    @Override
    public PushReaction getPistonPushReaction(@Nonnull BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    public boolean canSurvive(BlockState state, @Nonnull LevelReader level, @Nonnull BlockPos pos) {
        return state.isSolidRender(level, pos);
    }

    @Override
    public boolean mayPlaceOn(@Nonnull BlockState state, BlockGetter level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolidRender(level, pos.below());
    }

    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos, @Nonnull Random rand) {
        if (!getMates().isEmpty()) {
            Collections.shuffle(DIRECTIONS);
            if (DIRECTIONS.get(0) == Direction.NORTH)
                if (getMates().contains(level.getBlockState(pos.north(2)).getBlock()) && level.getBlockState(pos.north()).isAir())
                    level.setBlock(pos.north(), getChild(level.getBlockState(pos.north(2)).getBlock()).defaultBlockState(), 3);
            if (DIRECTIONS.get(0) == Direction.EAST)
                if (getMates().contains(level.getBlockState(pos.east(2)).getBlock()) && level.getBlockState(pos.east()).isAir())
                    level.setBlock(pos.east(), getChild(level.getBlockState(pos.east(2)).getBlock()).defaultBlockState(), 3);
            if (DIRECTIONS.get(0) == Direction.SOUTH)
                if (getMates().contains(level.getBlockState(pos.south(2)).getBlock()) && level.getBlockState(pos.south()).isAir())
                    level.setBlock(pos.south(), getChild(level.getBlockState(pos.south(2)).getBlock()).defaultBlockState(), 3);
            if (DIRECTIONS.get(0) == Direction.WEST)
                if (getMates().contains(level.getBlockState(pos.west(2)).getBlock()) && level.getBlockState(pos.west()).isAir())
                    level.setBlock(pos.west(), getChild(level.getBlockState(pos.west(2)).getBlock()).defaultBlockState(), 3);
        }
    }

    protected abstract ArrayList<Block> getMates();

    protected abstract Block getChild(Block b);
}
