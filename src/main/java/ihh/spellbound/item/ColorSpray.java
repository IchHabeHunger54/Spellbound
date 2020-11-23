package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import java.util.Arrays;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ColorSpray extends AbstractSelfSpell {
    private static final Block[] WOOL = {Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL};

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        int i = SpellConfig.COLOR_SPRAY_HORIZONTAL.get();
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getEntitiesInRange(world, (PlayerEntity) target, i, SpellConfig.COLOR_SPRAY_VERTICAL.get()))
                if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                    b = true;
                    e.addPotionEffect(new EffectInstance(Effects.BLINDNESS, SpellConfig.COLOR_SPRAY_DURATION.get()));
                    if (e instanceof SheepEntity) {
                        SheepEntity s = (SheepEntity) e;
                        s.setFleeceColor(DyeColor.byId(world.rand.nextInt(16)));
                    }
                }
        for (int x = -i; x <= i; x++)
            for (int z = -i; z <= i; z++) {
                BlockPos pos = target.getPosition().add(x, -1, z);
                if (Arrays.asList(WOOL).contains(world.getBlockState(pos).getBlock())) {
                    world.setBlockState(pos, WOOL[world.rand.nextInt(16)].getDefaultState());
                    b = true;
                }
            }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.COLOR_SPRAY;
    }
}
