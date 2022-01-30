package ihh.spellbound.effect;

import ihh.spellbound.init.EffectInit;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "spellbound")
public final class EffectHandler {
    @SubscribeEvent
    static void addPotionMobEffect(PotionEvent.PotionAddedEvent e) {
        if (e.getEntity().getLevel().isClientSide()) return;
        if (e.getPotionEffect().getEffect() == EffectInit.FLIGHT.get()) {
            startFlight(e.getEntityLiving());
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    static void removePotionMobEffect(PotionEvent.PotionExpiryEvent e) {
        if (e.getEntity().getLevel().isClientSide() || e.getPotionEffect() == null) return;
        if (e.getPotionEffect().getEffect() == EffectInit.FLIGHT.get()) {
            stopFlight(e.getEntityLiving());
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    static void removePotionMobEffect(PotionEvent.PotionRemoveEvent e) {
        if (e.getEntity().getLevel().isClientSide()) return;
        if (e.getPotion() == EffectInit.FLIGHT.get()) {
            stopFlight(e.getEntityLiving());
        }
    }

    private static void startFlight(LivingEntity e) {
        if (!(e instanceof ServerPlayer) || ((ServerPlayer) e).isCreative()) return;
        ((ServerPlayer) e).getAbilities().mayfly = true;
        ((ServerPlayer) e).onUpdateAbilities();
    }

    private static void stopFlight(LivingEntity e) {
        if (!(e instanceof ServerPlayer) || ((ServerPlayer) e).isCreative()) return;
        ((ServerPlayer) e).getAbilities().mayfly = false;
        ((ServerPlayer) e).getAbilities().flying = false;
        e.fallDistance = 0;
        ((ServerPlayer) e).onUpdateAbilities();
    }
}
