package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
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

public class Breach extends SpellProjectile {
    public Breach(EntityType<? extends Breach> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        for (int x = -Config.BREACH_RANGE.get(); x <= Config.BREACH_RANGE.get(); x++)
            for (int z = -Config.BREACH_RANGE.get(); z <= Config.BREACH_RANGE.get(); z++)
                Util.replaceBlock(getItem(), world, new BlockPos(result.getPos().getX() + x, result.getPos().getY(), result.getPos().getZ() + z), Blocks.AIR, true);
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        if (((LivingEntity) result.getEntity()).isPotionActive(EffectInit.spell_shield))
            ((LivingEntity) result.getEntity()).removeActivePotionEffect(EffectInit.spell_shield);
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.BREACH.get());
    }
}
