package ihh.spellbound.block;

import ihh.spellbound.entity.SpellProjectile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public final class Util {
    public static ArrayList<BlockPos> getBlocksInRange(World world, double x, double y, double z, int distance, Block... blocks) {
        return getBlocksInRange(world, x, y, z, distance, s -> Arrays.stream(blocks).anyMatch(b -> s.getBlock() == b));
    }

    public static ArrayList<BlockPos> getBlocksInRange(World world, double x, double y, double z, int distance, Predicate<BlockState> predicate) {
        ArrayList<BlockPos> l = new ArrayList<>();
        double dx = x - distance;
        while (dx <= x + distance) {
            double dz = z - distance;
            while (dz <= z + distance) {
                double dy = y + 3;
                while (dy >= y) {
                    if (predicate.test(world.getBlockState(new BlockPos(dx, dy, dz)))) l.add(new BlockPos(dx, dy, dz));
                    dy--;
                }
                dz++;
            }
            dx++;
        }
        return l;
    }

    public static List<LivingEntity> getEntitiesInRange(World world, Entity entity, double range) {
        List<LivingEntity> l = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(entity.getPosX() - range, entity.getPosY() - range, entity.getPosZ() - range, entity.getPosX() + range, entity.getPosY() + range, entity.getPosZ() + range));
        l.removeIf(e -> e == entity || entity instanceof SpellProjectile && e == ((SpellProjectile) entity).getShooter() || e instanceof ArmorStandEntity);
        return l;
    }

    public static void replaceBlock(ItemStack stack, World world, BlockPos pos, Block block, boolean drop) {
        if (world.getBlockState(pos).getBlockHardness(world, pos) >= 0) {
            if (drop)
                for (ItemStack i : new ArrayList<>(world.getBlockState(pos).getDrops((new LootContext.Builder((ServerWorld) world)).withRandom(world.rand).withParameter(LootParameters.TOOL, stack).withParameter(LootParameters.ORIGIN, new Vector3d(pos.getX(), pos.getY(), pos.getZ())))))
                    world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), i));
            world.setBlockState(pos, block.getDefaultState());
        }
    }

    public static boolean replaceAirBlock(World world, BlockPos pos, Block block) {
        if (world.isAirBlock(pos)) {
            world.setBlockState(pos, block.getDefaultState());
            return true;
        }
        return false;
    }
}
