package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.Arrays;
import javax.annotation.Nonnull;

public class ColorSpray extends SpellProjectile {
    private static final Block[] WOOL = {Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL};

    public ColorSpray(EntityType<? extends ColorSpray> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        for (int x = -Config.COLOR_SPRAY_RANGE.get(); x <= Config.COLOR_SPRAY_RANGE.get(); x++) {
            for (int z = -Config.COLOR_SPRAY_RANGE.get(); z <= Config.COLOR_SPRAY_RANGE.get(); z++) {
                BlockPos pos = result.getBlockPos().offset(x, 0, z);
                if (Arrays.asList(WOOL).contains(level.getBlockState(pos).getBlock())) {
                    level.setBlock(pos, WOOL[level.random.nextInt(16)].defaultBlockState(), 3);
                }
            }
        }
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        ((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, Config.COLOR_SPRAY_DURATION.get()));
        for (LivingEntity e : Util.getEntitiesInRange(level, result.getEntity(), Config.COLOR_SPRAY_RANGE.get())) {
            if (!e.hasEffect(EffectInit.SPELL_SHIELD.get()) && e instanceof Sheep) {
                ((Sheep) e).setColor(DyeColor.byId(level.random.nextInt(16)));
            }
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.COLOR_SPRAY.get());
    }
}
