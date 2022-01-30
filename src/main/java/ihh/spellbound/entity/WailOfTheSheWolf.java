package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class WailOfTheSheWolf extends SpellProjectile {
    public WailOfTheSheWolf(EntityType<? extends WailOfTheSheWolf> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        for (LivingEntity e : Util.getEntitiesInRange(level, this, Config.AREA_LIGHTNING_RANGE.get())) {
            if (!e.hasEffect(EffectInit.SPELL_SHIELD.get())) {
                e.hurt(DamageSource.MAGIC, Config.WAIL_OF_THE_SHE_WOLF_DAMAGE.get());
            }
        }
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.WAIL_OF_THE_SHE_WOLF.get());
    }
}
