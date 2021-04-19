package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Arrays;

public final class ColorSpray extends SelfSpell {
    public ColorSpray() {
        super(Config.COLOR_SPRAY_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        int i = Config.COLOR_SPRAY_HORIZONTAL.get();
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getMobsInRange(world, (PlayerEntity) target, i, Config.COLOR_SPRAY_VERTICAL.get()))
                if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                    b = true;
                    e.addPotionEffect(new EffectInstance(Effects.BLINDNESS, Config.COLOR_SPRAY_DURATION.get()));
                    if (e instanceof SheepEntity) {
                        SheepEntity s = (SheepEntity) e;
                        s.setFleeceColor(DyeColor.byId(world.rand.nextInt(16)));
                    }
                }
        for (int x = -i; x <= i; x++)
            for (int z = -i; z <= i; z++) {
                BlockPos pos = target.getPosition().add(x, -1, z);
                if (BlockTags.WOOL.contains(world.getBlockState(pos).getBlock())) {
                    world.setBlockState(pos, BlockTags.WOOL.getRandomElement(world.rand).getDefaultState());
                    b = true;
                }
            }
        return b;
    }
}
