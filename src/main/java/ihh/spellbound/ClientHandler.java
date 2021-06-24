package ihh.spellbound;

import ihh.spellbound.entity.SpellProjectileRenderer;
import ihh.spellbound.init.BlockInit;
import ihh.spellbound.init.EntityInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = "spellbound")
public final class ClientHandler {
    @SubscribeEvent
    public static void init(FMLClientSetupEvent e) {
        RenderTypeLookup.setRenderLayer(BlockInit.BLACK_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.GOLD_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.GRAY_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_BLUE_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.ORANGE_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.RAINBOW_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.SPECKLED_BLUE_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.SPECKLED_ORANGE_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.SPECKLED_RED_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.WHITE_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.YELLOW_MAGIC_MUSHROOM.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.AREA_LIGHTNING.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.AREA_LIGHTNING.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BREACH.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.BREACH.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.CHAOS.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.CHAOS.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.COLD_BLAST.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.COLD_BLAST.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.COLOR_SPRAY.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.COLOR_SPRAY.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DISINTEGRATE.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.DISINTEGRATE.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ELEMENTAL_FURY.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.ELEMENTAL_FURY.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FIREBALL.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.FIREBALL.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FLAMING_HANDS.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.FLAMING_HANDS.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GREATER_FIREBALL.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.GREATER_FIREBALL.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ICICLE.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.ICICLE.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ICY_GRIP.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.ICY_GRIP.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.LIGHTNING_BOLT.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.LIGHTNING_BOLT.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MISCAST_MAGIC.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.MISCAST_MAGIC.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.PUSH.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.PUSH.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SUMMON_SKELETON.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.SUMMON_SKELETON.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SUMMON_WITHER_SKELETON.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.SUMMON_WITHER_SKELETON.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SUMMON_WOLF.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.SUMMON_WOLF.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TASER.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.TASER.get()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.WAIL_OF_THE_SHE_WOLF.get(), renderer -> new SpellProjectileRenderer<>(renderer, ItemInit.WAIL_OF_THE_SHE_WOLF.get()));
    }
}
