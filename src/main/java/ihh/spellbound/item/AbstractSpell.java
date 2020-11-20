package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import ihh.spellbound.init.SoundInit;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public abstract class AbstractSpell extends Item {
    protected AbstractSpell() {
        super(ItemInit.GROUP);
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, World world, List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent(getTime().key));
    }

    @Nonnull
    @Override
    public UseAction getUseAction(@Nonnull ItemStack s) {
        return UseAction.BOW;
    }

    @Override
    public final int getUseDuration(@Nonnull ItemStack s) {
        return getTime().duration;
    }

    @Override
    public final ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull Hand hand) {
        if (this instanceof AbstractSelfSpell && player.isPotionActive(EffectInit.ARCHMAGIC.get()) || getTime().duration == 0)
            onItemUseFinish(player.getHeldItem(hand), world, player);
        player.setActiveHand(hand);
        return super.onItemRightClick(world, player, hand);
    }

    @Nonnull
    @Override
    public ItemStack onItemUseFinish(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull LivingEntity entity) {
        if (entity instanceof PlayerEntity) {
            boolean b;
            if (!world.isRemote && !entity.isPotionActive(EffectInit.MISCAST_MAGIC.get()) && getTarget((PlayerEntity) entity) != null)
                b = use(stack, getTarget((PlayerEntity)entity), (ServerWorld) world);
            else return super.onItemUseFinish(stack, world, entity);
            entity.setActiveHand(entity.getActiveHand());
            if (!entity.isPotionActive(EffectInit.SURGE_SHIELD.get()) && world.rand.nextInt(entity.isPotionActive(EffectInit.CHAOS.get()) ? 3 : 200) == 1) {
                if (world.rand.nextInt(8) == 1) entity.setFire(10);
                else entity.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200));
                world.playSound((PlayerEntity) entity, entity.getPosition(), SoundInit.SURGE.get(), SoundCategory.PLAYERS, 1, 1);
            }
            if (!((PlayerEntity) entity).isCreative() && b) stack.shrink(1);
            world.playSound((PlayerEntity) entity, entity.getPosition(), getTime().sound.get(), SoundCategory.PLAYERS, 1, 1);
        }
        return super.onItemUseFinish(stack, world, entity);
    }

    protected abstract boolean use(ItemStack stack, LivingEntity target, ServerWorld world);

    protected abstract Time getTime();

    protected abstract LivingEntity getTarget(PlayerEntity caster);

    public enum Time {
        ZERO(0, "spellbound.useTime.zero", SoundInit.ZERO_SPELL),
        ONE(20, "spellbound.useTime.one", SoundInit.ONE_SPELL),
        TWO(40, "spellbound.useTime.two", SoundInit.TWO_SPELL),
        THREE(60, "spellbound.useTime.three", SoundInit.THREE_SPELL),
        FOUR(80, "spellbound.useTime.four", SoundInit.FOUR_SPELL),
        FIVE(100, "spellbound.useTime.five", SoundInit.FIVE_SPELL);

        public final int duration;
        public final String key;
        public final Supplier<SoundEvent> sound;

        Time(int durationIn, String keyIn, Supplier<SoundEvent> soundIn) {
            duration = durationIn;
            key = keyIn;
            sound = soundIn;
        }
    }
}
