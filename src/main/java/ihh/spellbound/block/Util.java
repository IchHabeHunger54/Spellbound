package ihh.spellbound.block;

import ihh.spellbound.entity.SpellProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public final class Util {
    public static List<BlockPos> getBlocksInRange(Level level, double x, double y, double z, int distance, Block... blocks) {
        return getBlocksInRange(level, x, y, z, distance, s -> Arrays.stream(blocks).anyMatch(b -> s.getBlock() == b));
    }

    public static List<BlockPos> getBlocksInRange(Level level, double x, double y, double z, int distance, Predicate<BlockState> predicate) {
        List<BlockPos> list = new ArrayList<>();
        double dx = x - distance;
        while (dx <= x + distance) {
            double dz = z - distance;
            while (dz <= z + distance) {
                double dy = y + 3;
                while (dy >= y) {
                    if (predicate.test(level.getBlockState(new BlockPos(dx, dy, dz)))) {
                        list.add(new BlockPos(dx, dy, dz));
                    }
                    dy--;
                }
                dz++;
            }
            dx++;
        }
        return list;
    }

    public static List<LivingEntity> getEntitiesInRange(Level level, Entity entity, double range) {
        return level.getEntitiesOfClass(LivingEntity.class, new AABB(entity.getX() - range, entity.getY() - range, entity.getZ() - range, entity.getX() + range, entity.getY() + range, entity.getZ() + range)).stream().filter(e -> e != entity && (!(entity instanceof SpellProjectile projectile) || e != projectile.getOwner()) && (e instanceof Player || e instanceof Mob)).toList();
    }

    public static void replaceBlock(ItemStack stack, Level level, BlockPos pos, Block block, boolean drop) {
        if (level.getBlockState(pos).getDestroySpeed(level, pos) >= 0) {
            if (drop) {
                for (ItemStack is : level.getBlockState(pos).getDrops((new LootContext.Builder((ServerLevel) level)).withRandom(level.random).withParameter(LootContextParams.TOOL, stack).withParameter(LootContextParams.ORIGIN, new Vec3(pos.getX(), pos.getY(), pos.getZ())))) {
                    level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), is));
                }
            }
            level.setBlock(pos, block.defaultBlockState(), 3);
        }
    }

    public static boolean replaceAirBlock(Level level, BlockPos pos, Block block) {
        if (level.getBlockState(pos).isAir()) {
            level.setBlock(pos, block.defaultBlockState(), 3);
            return true;
        }
        return false;
    }
}
