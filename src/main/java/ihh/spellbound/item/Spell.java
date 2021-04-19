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
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public abstract class Spell extends Item {
    private final ForgeConfigSpec.IntValue duration;

    public Spell(ForgeConfigSpec.IntValue config) {
        super(ItemInit.PROP);
        duration = config;
    }

    @Override
    public final void addInformation(@Nonnull ItemStack stack, World world, List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("spellbound.useTime", duration.get() / 20f));
    }

    @Nonnull
    @Override
    public final UseAction getUseAction(@Nonnull ItemStack s) {
        return duration.get() == 0 ? UseAction.NONE : UseAction.BOW;
    }

    @Override
    public final int getUseDuration(@Nonnull ItemStack s) {
        return duration.get();
    }

    @Nonnull
    @Override
    public final ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull Hand hand) {
        if (this instanceof SelfSpell && player.isPotionActive(EffectInit.ARCHMAGIC.get()) || duration.get() == 0)
            onItemUseFinish(player.getHeldItem(hand), world, player);
        player.setActiveHand(hand);
        return super.onItemRightClick(world, player, hand);
    }

    @Nonnull
    @Override
    public final ItemStack onItemUseFinish(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull LivingEntity entity) {
        if (entity instanceof PlayerEntity && !world.isRemote && !entity.isPotionActive(EffectInit.MISCAST_MAGIC.get()) && getTarget(world, (PlayerEntity) entity) != null) {
            boolean b = use(stack, getTarget(world, (PlayerEntity) entity), (ServerWorld) world);
            entity.setActiveHand(entity.getActiveHand());
            if (!((PlayerEntity) entity).isCreative() && b) {
                stack.shrink(1);
                doSurge((PlayerEntity) entity, world);
            }
        }
        return super.onItemUseFinish(stack, world, entity);
    }

    private void doSurge(PlayerEntity entity, World world) {
        int i = entity.isPotionActive(EffectInit.chaos) ? Config.SURGE_CHAOS_CHANCE.get() : Config.SURGE_CHANCE.get();
        if (i > 0 && world.rand.nextInt(i) == 1 && !entity.isCreative() && !entity.isPotionActive(EffectInit.SURGE_SHIELD.get())) {
            if (!Config.getEffects().isEmpty()) {
                Collections.shuffle(Config.getEffects());
                entity.addPotionEffect(Config.getEffects().get(0));
            } else if (Config.SURGE_FIRE.get() > 0 && world.rand.nextBoolean()) entity.setFire(Config.SURGE_FIRE.get());
            world.playSound(entity, entity.getPosition(), SoundInit.SURGE.get(), SoundCategory.PLAYERS, 1, 1);
        }
    }

    protected abstract boolean use(ItemStack stack, LivingEntity target, ServerWorld world);

    protected abstract LivingEntity getTarget(World world, PlayerEntity player);
}
