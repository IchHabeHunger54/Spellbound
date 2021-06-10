package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import ihh.spellbound.init.SoundInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
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
    private final Type type;

    protected Spell(ForgeConfigSpec.IntValue timeConfig, Type type) {
        super(ItemInit.GROUP);
        this.timeConfig = timeConfig;
        this.type = type;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, World world, List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
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
        if (type == Type.SELF && player.isPotionActive(EffectInit.ARCHMAGIC.get()) || timeConfig.get() == 0)
            onItemUseFinish(player.getHeldItem(hand), world, player);
        player.setActiveHand(hand);
        return super.onItemRightClick(world, player, hand);
    }

    @Nonnull
    @Override
    public ItemStack onItemUseFinish(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull LivingEntity entity) {
        if (entity instanceof PlayerEntity && !world.isRemote) {
            boolean b;
            LivingEntity target = getTarget((PlayerEntity) entity);
            if (!entity.isPotionActive(EffectInit.MISCAST_MAGIC.get()) && target != null)
                b = use(stack, target, (ServerWorld) world);
            else return super.onItemUseFinish(stack, world, entity);
            entity.setActiveHand(entity.getActiveHand());
            doSurge((PlayerEntity) entity, world);
            if (!((PlayerEntity) entity).isCreative() && b) stack.shrink(1);
            world.playSound((PlayerEntity) entity, entity.getPosition(), getTimeSound(), SoundCategory.PLAYERS, 1, 1);
        }
        return super.onItemUseFinish(stack, world, entity);
    }

    private void doSurge(PlayerEntity entity, World world) {
        int i = entity.isPotionActive(EffectInit.chaos) ? Config.SURGE_CHAOS_CHANCE.get() : Config.SURGE_CHANCE.get();
        if (!entity.isCreative() && !entity.isPotionActive(EffectInit.SURGE_SHIELD.get()) && i > 0 && world.rand.nextInt(i) == 1) {
            if (!Config.SURGE_POTION.get() || Config.SURGE_FIRE.get() > 0 && world.rand.nextBoolean())
                entity.setFire(Config.SURGE_FIRE.get());
            else {
                Collections.shuffle(Config.SURGE_EFFECTS);
                entity.addPotionEffect(Config.SURGE_EFFECTS.get(0));
            }
            world.playSound(entity, entity.getPosition(), SoundInit.SURGE.get(), SoundCategory.PLAYERS, 1, 1);
        }
    }

    protected SoundEvent getTimeSound() {
        if (timeConfig.get() < 20) return SoundInit.ZERO_SPELL.get();
        else if (timeConfig.get() < 40) return SoundInit.ONE_SPELL.get();
        else if (timeConfig.get() < 60) return SoundInit.TWO_SPELL.get();
        else if (timeConfig.get() < 80) return SoundInit.THREE_SPELL.get();
        else if (timeConfig.get() < 100) return SoundInit.FOUR_SPELL.get();
        else return SoundInit.FIVE_SPELL.get();
    }

    protected abstract boolean use(ItemStack stack, LivingEntity target, ServerWorld world);

    private LivingEntity getTarget(PlayerEntity player) {
        if (type == Type.SELF) return player;
        if (type == Type.TARGET) {
            LivingEntity result = null;
            Vector3d vec = player.getPositionVec().add(0, player.getEyeHeight(), 0);
            Vector3d lookVec = player.getLookVec();
            for (Entity entity : player.world.getEntitiesWithinAABBExcludingEntity(player, player.getBoundingBox().expand(lookVec.getX() * 8, lookVec.getY() * 8, lookVec.getZ() * 8).grow(1, 1, 1))) {
                if (entity.canBeCollidedWith()) {
                    float f = Math.max(1, entity.getCollisionBorderSize());
                    AxisAlignedBB aabb = entity.getBoundingBox().grow(f, f, f);
                    if ((aabb.intersects(lookVec.add(vec), vec)) || aabb.intersects(lookVec.subtract(vec), vec) && entity instanceof LivingEntity && (result == null || Math.abs(player.getDistance(entity)) < Math.abs(player.getDistance(result))))
                        result = (LivingEntity) entity;
                }
            }
            return result;
        }
        return null;
    }

    public enum Type {
        SELF,
        TARGET;
    }
}
