package ihh.spellbound.entity;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public abstract class SpellProjectile extends ThrowableProjectile implements ItemSupplier {
    public SpellProjectile(EntityType<? extends ThrowableProjectile> type, Level level) {
        super(type, level);
    }

    @Override
    protected void onHit(@Nonnull HitResult result) {
        super.onHit(result);
        if (!level.isClientSide()) {
            if (result instanceof EntityHitResult && ((EntityHitResult) result).getEntity() instanceof LivingEntity && !(((EntityHitResult) result).getEntity() instanceof ArmorStand)) {
                affectEntity((EntityHitResult) result);
                affectBlock(new BlockHitResult(((EntityHitResult) result).getEntity().getLookAngle(), Direction.UP, ((EntityHitResult) result).getEntity().getOnPos().below(), false));
                remove(RemovalReason.KILLED);
            }
            if (result instanceof BlockHitResult) {
                affectBlock((BlockHitResult) result);
                remove(RemovalReason.KILLED);
            }
        }
    }

    protected abstract void affectBlock(BlockHitResult result);

    protected abstract void affectEntity(EntityHitResult result);

    @Override
    protected void defineSynchedData() {
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
    }

    @Override
    public CompoundTag serializeNBT() {
        return super.serializeNBT();
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        return getItem();
    }

    @Override
    public boolean canRiderInteract() {
        return false;
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return false;
    }

    @Override
    public MobCategory getClassification(boolean forSpawnCount) {
        return MobCategory.MISC;
    }

    @Override
    public boolean isMultipartEntity() {
        return false;
    }

    @Override
    public PartEntity<?>[] getParts() {
        return null;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        return super.getCapability(cap);
    }

    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
