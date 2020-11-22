package ihh.spellbound.block;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraftforge.registries.ForgeRegistries;

public final class Util {
    public static ArrayList<BlockPos> getBlocksInRange(World world, double x, double y, double z, int distance) {
        ArrayList<BlockPos> list = new ArrayList<>();
        for (Block block : ForgeRegistries.BLOCKS.getValues().toArray(new Block[]{}))
            getBlocksInRange(world, (int) x, (int) y, (int) z, distance, list, block);
        return list;
    }

    public static ArrayList<BlockPos> getBlocksInRange(World world, double x, double y, double z, int distance, Block... blocks) {
        ArrayList<BlockPos> list = new ArrayList<>();
        for (Block block : blocks) getBlocksInRange(world, (int) x, (int) y, (int) z, distance, list, block);
        return list;
    }

    private static void getBlocksInRange(World world, int x, int y, int z, int distance, ArrayList<BlockPos> list, Block block) {
        int dx = x - distance;
        while (dx <= x + distance) {
            int dz = z - distance;
            while (dz <= z + distance) {
                int dy = y + 3;
                while (dy >= y) {
                    if (world.getBlockState(new BlockPos(dx, dy, dz)).getBlock() == block)
                        list.add(new BlockPos(dx, dy, dz));
                    dy--;
                }
                dz++;
            }
            dx++;
        }
    }

    public static List<LivingEntity> getEntitiesInRange(World world, PlayerEntity player, double hRange, double vRange) {
        List<LivingEntity> l = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(player.getPosX() - hRange, player.getPosY() - vRange, player.getPosZ() - hRange, player.getPosX() + hRange, player.getPosY() + vRange, player.getPosZ() + hRange));
        l.removeIf(e -> e == player);
        l.removeIf(e -> e instanceof ArmorStandEntity);
        return l;
    }

    public static boolean replaceBlock(World world, BlockPos pos, Block block, boolean drop) {
        return replaceBlock(world, pos, block.getDefaultState(), drop);
    }

    public static boolean replaceBlock(World world, BlockPos pos, BlockState block, boolean drop) {
        if (world.getBlockState(pos).getBlockHardness(world, pos) >= 0) {
            if (drop)
                for (ItemStack i : new ArrayList<>(world.getBlockState(pos).getDrops((new LootContext.Builder((ServerWorld) world)).withRandom(world.rand).withParameter(LootParameters.POSITION, pos))))
                    world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), i));
            world.setBlockState(pos, block);
            return true;
        }
        return false;
    }

    public static boolean replaceAirBlock(World world, BlockPos pos, Block block) {
        return replaceAirBlock(world, pos, block.getDefaultState());
    }

    public static boolean replaceAirBlock(World world, BlockPos pos, BlockState block) {
        if (world.getBlockState(pos).isAir(world, pos)) {
            world.setBlockState(pos, block);
            return true;
        }
        return false;
    }
}
