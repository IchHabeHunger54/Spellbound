package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class Breach extends SpellProjectile {
    public Breach(EntityType<? extends Breach> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        for (int x = -Config.BREACH_RANGE.get(); x <= Config.BREACH_RANGE.get(); x++)
            for (int z = -Config.BREACH_RANGE.get(); z <= Config.BREACH_RANGE.get(); z++)
                Util.replaceBlock(getItem(), level, new BlockPos(result.getBlockPos().getX() + x, result.getBlockPos().getY(), result.getBlockPos().getZ() + z), Blocks.AIR, true);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (((LivingEntity) result.getEntity()).hasEffect(EffectInit.spell_shield))
            ((LivingEntity) result.getEntity()).removeEffect(EffectInit.spell_shield);
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.BREACH.get());
    }
}
