package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class GreaterFireball extends SpellProjectile {
    public GreaterFireball(EntityType<? extends GreaterFireball> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        world.createExplosion(this, getPosX(), getPosY(), getPosZ(), 4, true, Explosion.Mode.BREAK);
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).isPotionActive(EffectInit.fire_shield))
            result.getEntity().attackEntityFrom(DamageSource.ON_FIRE, Config.GREATER_FIREBALL_DAMAGE.get());
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.GREATER_FIREBALL.get());
    }
}
