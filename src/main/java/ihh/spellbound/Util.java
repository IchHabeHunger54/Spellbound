package ihh.spellbound;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public final class Util {
    public static ArrayList<BlockPos> getBlocksInRange(World world, double x, double y, double z, int hDistance, int vDistance, BiPredicate<BlockState, BlockPos> predicate) {
        ArrayList<BlockPos> list = new ArrayList<>();
        for (Block block : ForgeRegistries.BLOCKS) {
            double dx = x - hDistance;
            while (dx <= x + hDistance) {
                double dz = z - hDistance;
                while (dz <= z + hDistance) {
                    double dy = y + vDistance;
                    while (dy >= y) {
                        BlockPos pos = new BlockPos(dx, dy, dz);
                        BlockState state = world.getBlockState(pos);
                        if (state.getBlock() == block && predicate.test(state, pos))
                            list.add(new BlockPos(dx, dy, dz));
                        dy--;
                    }
                    dz++;
                }
                dx++;
            }
        }
        return list;
    }

    public static List<LivingEntity> getMobsInRange(World world, PlayerEntity player, double hRange, double vRange) {
        List<Entity> l = world.getEntitiesWithinAABB((EntityType<Entity>) null, new AxisAlignedBB(player.getPosX() - hRange, player.getPosY() - vRange, player.getPosZ() - hRange, player.getPosX() + hRange, player.getPosY() + vRange, player.getPosZ() + hRange), EntityPredicates.IS_ALIVE);
        l.removeIf(e -> !(e instanceof LivingEntity) || e instanceof ArmorStandEntity || e == player);
        List<LivingEntity> r = new ArrayList<>();
        for (Entity e : l) if (e instanceof LivingEntity) r.add((LivingEntity) e);
        return r;
    }

    public static boolean replaceAir(World world, BlockPos pos, Block block) {
        if (world.getBlockState(pos).isAir(world, pos)) {
            world.setBlockState(pos, block.getDefaultState());
            return true;
        }
        return false;
    }

    public static boolean replaceBlock(World world, BlockPos pos, Block block, boolean drop) {
        if (drop)
            for (ItemStack i : world.getBlockState(pos).getDrops((new LootContext.Builder((ServerWorld) world)).withRandom(world.rand).withParameter(LootParameters.ORIGIN, new Vector3d(pos.getX(), pos.getY(), pos.getZ()))))
                world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), i));
        world.setBlockState(pos, block.getDefaultState());
        return true;
    }

    public static void spawnLightning(World world, double x, double y, double z) {
        LightningBoltEntity lightning = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
        lightning.setPosition(x, y, z);
        lightning.setEffectOnly(true);
        world.addEntity(lightning);
    }
}
