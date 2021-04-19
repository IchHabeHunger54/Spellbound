package ihh.spellbound.block;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class MagicMushroom extends BushBlock {
    private static final VoxelShape SHAPE = Block.makeCuboidShape(5, 0, 5, 11, 6, 11);
    private static final ArrayList<Direction> DIRECTIONS = Lists.newArrayList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    public MagicMushroom() {
        super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return SHAPE;
    }

    @Nonnull
    @Override
    public PushReaction getPushReaction(@Nonnull BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    protected boolean isValidGround(BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos pos) {
        return state.isOpaqueCube(world, pos);
    }

    @Override
    public boolean isValidPosition(@Nonnull BlockState state, IWorldReader world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOpaqueCube(world, pos.down());
    }

    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerWorld world, @Nonnull BlockPos pos, @Nonnull Random rand) {
        if (!getMates().isEmpty()) {
            Collections.shuffle(DIRECTIONS);
            if (DIRECTIONS.get(0) == Direction.NORTH)
                if (getMates().contains(world.getBlockState(pos.north(2)).getBlock()) && world.getBlockState(pos.north()).isAir(world, pos.north()))
                    world.setBlockState(pos.north(), getChild(world.getBlockState(pos.north(2)).getBlock()).getDefaultState());
            if (DIRECTIONS.get(0) == Direction.EAST)
                if (getMates().contains(world.getBlockState(pos.east(2)).getBlock()) && world.getBlockState(pos.east()).isAir(world, pos.east()))
                    world.setBlockState(pos.east(), getChild(world.getBlockState(pos.east(2)).getBlock()).getDefaultState());
            if (DIRECTIONS.get(0) == Direction.SOUTH)
                if (getMates().contains(world.getBlockState(pos.south(2)).getBlock()) && world.getBlockState(pos.south()).isAir(world, pos.south()))
                    world.setBlockState(pos.south(), getChild(world.getBlockState(pos.south(2)).getBlock()).getDefaultState());
            if (DIRECTIONS.get(0) == Direction.WEST)
                if (getMates().contains(world.getBlockState(pos.west(2)).getBlock()) && world.getBlockState(pos.west()).isAir(world, pos.west()))
                    world.setBlockState(pos.west(), getChild(world.getBlockState(pos.west(2)).getBlock()).getDefaultState());
        }
    }

    protected abstract ArrayList<Block> getMates();

    protected abstract Block getChild(Block b);
}
