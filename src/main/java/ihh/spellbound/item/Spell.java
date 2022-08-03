package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import ihh.spellbound.init.SoundInit;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public abstract class Spell extends Item {
    private final ForgeConfigSpec.IntValue timeConfig;

    protected Spell(ForgeConfigSpec.IntValue timeConfig) {
        super(ItemInit.GROUP);
        this.timeConfig = timeConfig;
    }

    @Override
    public final void appendHoverText(@Nonnull ItemStack stack, Level level, List<Component> tooltip, @Nonnull TooltipFlag flag) {
        tooltip.add(Component.translatable("spellbound.useTime", timeConfig.get() / 20f));
    }

    @Nonnull
    @Override
    public final UseAnim getUseAnimation(@Nonnull ItemStack s) {
        return UseAnim.BOW;
    }

    @Override
    public final int getUseDuration(@Nonnull ItemStack s) {
        return 72000;
    }

    @Nonnull
    @Override
    public final InteractionResultHolder<ItemStack> use(@Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
        if (player.hasEffect(EffectInit.ARCHMAGIC.get()) || timeConfig.get() == 0) {
            releaseUsing(player.getItemInHand(hand), level, player, 0);
        } else {
            player.startUsingItem(hand);
        }
        level.playSound(null, player.blockPosition(), getTimeSound(), SoundSource.PLAYERS, 1f, 0.2f);
        return super.use(level, player, hand);
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        if (!player.getLevel().isClientSide() && count <= 72000 - timeConfig.get()) {
            releaseUsing(stack, player.getLevel(), player, count);
        }
        super.onUsingTick(stack, player, count);
    }

    @Override
    public void releaseUsing(@Nonnull ItemStack stack, @Nonnull Level level, LivingEntity entity, int count) {
        if (entity.hasEffect(EffectInit.MISCAST_MAGIC.get())) return;
        if (!level.isClientSide() && entity instanceof Player player && count <= 72000 - timeConfig.get()) {
            if (use(stack, player, (ServerLevel) level) && !player.isCreative()) {
                stack.shrink(1);
            }
            entity.setItemInHand(entity.getUsedItemHand(), entity.getItemInHand(entity.getUsedItemHand()));
            player.stopUsingItem();
            player.awardStat(Stats.ITEM_USED.get(this));
            doSurge(player, level);
        }
    }

    public final SoundEvent getTimeSound() {
        if (timeConfig.get() < 20) return SoundInit.ZERO_SPELL.get();
        if (timeConfig.get() < 40) return SoundInit.ONE_SPELL.get();
        if (timeConfig.get() < 60) return SoundInit.TWO_SPELL.get();
        if (timeConfig.get() < 80) return SoundInit.THREE_SPELL.get();
        if (timeConfig.get() < 100) return SoundInit.FOUR_SPELL.get();
        return SoundInit.FIVE_SPELL.get();
    }

    private void doSurge(Player entity, Level level) {
        int i = entity.hasEffect(EffectInit.CHAOS.get()) ? Config.SURGE_CHAOS_CHANCE.get() : Config.SURGE_CHANCE.get();
        if (!entity.isCreative() && !entity.hasEffect(EffectInit.SURGE_SHIELD.get()) && i > 0 && level.random.nextInt(i) == 1) {
            Collections.shuffle(Config.SURGE_EFFECTS);
            if (!Config.SURGE_POTION.get() || Config.SURGE_FIRE.get() > 0 && level.random.nextBoolean()) {
                entity.setRemainingFireTicks(Config.SURGE_FIRE.get());
            } else {
                entity.addEffect(Config.SURGE_EFFECTS.get(0));
            }
            level.playSound(null, entity.blockPosition(), SoundInit.SURGE.get(), SoundSource.PLAYERS, 1f, 0.2f);
        }
    }

    protected abstract boolean use(ItemStack stack, Player player, ServerLevel level);
}
