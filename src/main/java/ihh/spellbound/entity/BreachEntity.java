package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BreachEntity extends SpellProjectileEntity {
    public BreachEntity(EntityType<? extends BreachEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public BreachEntity(EntityType<? extends BreachEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    public BreachEntity(EntityType<? extends BreachEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void onBlockImpact(BlockRayTraceResult result) {
        for (int x = -Config.BREACH_RANGE.get(); x <= Config.BREACH_RANGE.get(); x++)
            for (int z = -Config.BREACH_RANGE.get(); z <= Config.BREACH_RANGE.get(); z++)
                Util.replaceBlock(getItem(), world, new BlockPos(result.getPos().getX() + x, result.getPos().getY(), result.getPos().getZ() + z), Blocks.AIR, true);
    }

    @Override
    protected void onEntityImpact(EntityRayTraceResult result) {
        for (int x = -Config.BREACH_RANGE.get(); x <= Config.BREACH_RANGE.get(); x++)
            for (int z = -Config.BREACH_RANGE.get(); z <= Config.BREACH_RANGE.get(); z++)
                Util.replaceBlock(getItem(), world, new BlockPos(result.getEntity().getPosition().down().getX() + x, result.getEntity().getPosition().down().getY(), result.getEntity().getPosition().down().getZ() + z), Blocks.AIR, true);
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.BREACH.get());
    }
}
