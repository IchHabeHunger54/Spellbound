package ihh.spellbound;

import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "spellbound")
public final class EffectHandler {
    @SubscribeEvent
    public static void addPotionEffect(PotionEvent.PotionAddedEvent e) {
        if (e.getEntity().getEntityWorld().isRemote())
            return;
        if (e.getPotionEffect().getPotion() == EffectInit.flight)
            startFlight(e.getEntityLiving());
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void removePotionEffect(PotionEvent.PotionExpiryEvent e) {
        if (e.getEntity().getEntityWorld().isRemote() || e.getPotionEffect() == null) return;
        if (e.getPotionEffect().getPotion() == EffectInit.flight)
            stopFlight(e.getEntityLiving());
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void removePotionEffect(PotionEvent.PotionRemoveEvent e) {
        if (e.getEntity().getEntityWorld().isRemote())
            return;
        if (e.getPotion() == EffectInit.flight)
            stopFlight(e.getEntityLiving());
    }

    private static void startFlight(LivingEntity e) {
        if (!(e instanceof ServerPlayerEntity) || ((ServerPlayerEntity) e).isCreative()) return;
        ((ServerPlayerEntity) e).abilities.allowFlying = true;
        ((ServerPlayerEntity) e).sendPlayerAbilities();
    }

    private static void stopFlight(LivingEntity e) {
        if (!(e instanceof ServerPlayerEntity) || ((ServerPlayerEntity) e).isCreative()) return;
        ((ServerPlayerEntity) e).abilities.allowFlying = false;
        ((ServerPlayerEntity) e).abilities.isFlying = false;
        e.fallDistance = 0;
        ((ServerPlayerEntity) e).sendPlayerAbilities();
    }
}
