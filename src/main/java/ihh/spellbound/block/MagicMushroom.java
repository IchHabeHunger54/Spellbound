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
    private static final VoxelShape SHAPE = Block.box(5D, 0D, 5D, 11D, 6D, 11D);
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
            BlockPos pos1 = pos, pos2 = pos;
            Collections.shuffle(DIRECTIONS);
            switch (DIRECTIONS.get(0)) {
                case NORTH -> {
                    pos1 = pos.north();
                    pos2 = pos1.north();
                }
                case EAST -> {
                    pos1 = pos.east();
                    pos2 = pos1.east();
                }
                case SOUTH -> {
                    pos1 = pos.south();
                    pos2 = pos1.south();
                }
                case WEST -> {
                    pos1 = pos.west();
                    pos2 = pos1.west();
                }
            }
            BlockState block1 = level.getBlockState(pos1), block2 = level.getBlockState(pos2);
            if (getMates().contains(block1.getBlock()) && block2.isAir()) {
                level.setBlock(pos1, getChild(block2.getBlock()).defaultBlockState(), 3);
            }
        }
    }

    protected abstract ArrayList<Block> getMates();

    protected abstract Block getChild(Block b);
}
