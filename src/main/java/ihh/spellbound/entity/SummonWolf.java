package ihh.spellbound.entity;

import ihh.spellbound.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SummonWolf extends SpellProjectile {
    public SummonWolf(EntityType<? extends SummonWolf> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        WolfEntity e = new WolfEntity(EntityType.WOLF, world);
        e.setHealth(20);
        e.setOwnerId(getShooter().getUniqueID());
        e.setPosition(getPosX(), getPosY(), getPosZ());
        e.setTamed(true);
        world.addEntity(e);
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.SUMMON_WOLF.get());
    }
}
