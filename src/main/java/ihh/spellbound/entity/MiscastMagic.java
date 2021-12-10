package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class MiscastMagic extends SpellProjectile {
    public MiscastMagic(EntityType<? extends MiscastMagic> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.spell_shield))
            ((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(EffectInit.miscast_magic, Config.MISCAST_MAGIC_DURATION.get()));
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.MISCAST_MAGIC.get());
    }
}
