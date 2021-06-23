package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import ihh.spellbound.init.SoundInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

public abstract class Spell extends Item {
    private final ForgeConfigSpec.IntValue timeConfig;

    protected Spell(ForgeConfigSpec.IntValue timeConfig) {
        super(ItemInit.GROUP);
        this.timeConfig = timeConfig;
    }

    @Override
    public final void addInformation(@Nonnull ItemStack stack, World world, List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("spellbound.useTime", timeConfig.get() / 20f));
    }

    @Nonnull
    @Override
    public final UseAction getUseAction(@Nonnull ItemStack s) {
        return UseAction.BOW;
    }

    @Override
    public final int getUseDuration(@Nonnull ItemStack s) {
        return timeConfig.get();
    }

    @Nonnull
    @Override
    public final ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull Hand hand) {
        if (player.isPotionActive(EffectInit.ARCHMAGIC.get()) || timeConfig.get() == 0)
            onItemUseFinish(player.getHeldItem(hand), world, player);
        player.setActiveHand(hand);
        return super.onItemRightClick(world, player, hand);
    }

    @Nonnull
    @Override
    public final ItemStack onItemUseFinish(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull LivingEntity entity) {
        if (entity.isPotionActive(EffectInit.MISCAST_MAGIC.get())) return super.onItemUseFinish(stack, world, entity);
        if (entity instanceof PlayerEntity && !world.isRemote) {
            boolean b = use(stack, (PlayerEntity) entity, (ServerWorld) world);
            entity.setActiveHand(entity.getActiveHand());
            doSurge((PlayerEntity) entity, world);
            if (!((PlayerEntity) entity).isCreative() && b) stack.shrink(1);
            world.playSound((PlayerEntity) entity, entity.getPosition(), getTimeSound(), SoundCategory.PLAYERS, 1, 1);
            ((PlayerEntity) entity).addStat(Stats.ITEM_USED.get(this));
        }
        return super.onItemUseFinish(stack, world, entity);
    }

    public final SoundEvent getTimeSound() {
        if (timeConfig.get() < 20) return SoundInit.ZERO_SPELL.get();
        else if (timeConfig.get() < 40) return SoundInit.ONE_SPELL.get();
        else if (timeConfig.get() < 60) return SoundInit.TWO_SPELL.get();
        else if (timeConfig.get() < 80) return SoundInit.THREE_SPELL.get();
        else if (timeConfig.get() < 100) return SoundInit.FOUR_SPELL.get();
        else return SoundInit.FIVE_SPELL.get();
    }

    private void doSurge(PlayerEntity entity, World world) {
        int i = entity.isPotionActive(EffectInit.chaos) ? Config.SURGE_CHAOS_CHANCE.get() : Config.SURGE_CHANCE.get();
        if (!entity.isCreative() && !entity.isPotionActive(EffectInit.SURGE_SHIELD.get()) && i > 0 && world.rand.nextInt(i) == 1) {
            Collections.shuffle(Config.SURGE_EFFECTS);
            if (!Config.SURGE_POTION.get() || Config.SURGE_FIRE.get() > 0 && world.rand.nextBoolean()) entity.setFire(Config.SURGE_FIRE.get());
            else entity.addPotionEffect(Config.SURGE_EFFECTS.get(0));
            world.playSound(entity, entity.getPosition(), SoundInit.SURGE.get(), SoundCategory.PLAYERS, 1, 1);
        }
    }

    protected abstract boolean use(ItemStack stack, PlayerEntity player, ServerWorld world);
}
