package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import java.util.Arrays;
import javax.annotation.Nonnull;

public class ColorSpray extends SpellProjectile {
    private static final Block[] WOOL = {Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL};

    public ColorSpray(EntityType<? extends ColorSpray> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        for (int x = -Config.COLOR_SPRAY_RANGE.get(); x <= Config.COLOR_SPRAY_RANGE.get(); x++)
            for (int z = -Config.COLOR_SPRAY_RANGE.get(); z <= Config.COLOR_SPRAY_RANGE.get(); z++) {
                BlockPos pos = result.getPos().add(x, 0, z);
                if (Arrays.asList(WOOL).contains(world.getBlockState(pos).getBlock())) world.setBlockState(pos, WOOL[world.rand.nextInt(16)].getDefaultState());
            }
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        ((LivingEntity) result.getEntity()).addPotionEffect(new EffectInstance(Effects.BLINDNESS, Config.COLOR_SPRAY_DURATION.get()));
        for (LivingEntity e : Util.getEntitiesInRange(world, result.getEntity(), Config.COLOR_SPRAY_RANGE.get()))
            if (!e.isPotionActive(EffectInit.spell_shield) && e instanceof SheepEntity)
                ((SheepEntity) e).setFleeceColor(DyeColor.byId(world.rand.nextInt(16)));
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.COLOR_SPRAY.get());
    }
}
