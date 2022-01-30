package ihh.spellbound;

import ihh.spellbound.entity.SpellProjectileRenderer;
import ihh.spellbound.init.BlockInit;
import ihh.spellbound.init.EntityInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = "spellbound")
public final class ClientHandler {
    @SubscribeEvent
    static void clientSetup(FMLClientSetupEvent e) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLACK_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLD_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.GRAY_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.LIGHT_BLUE_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.ORANGE_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.PURPLE_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.RAINBOW_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.SPECKLED_BLUE_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.SPECKLED_ORANGE_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.SPECKLED_RED_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.WHITE_MAGIC_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.YELLOW_MAGIC_MUSHROOM.get(), RenderType.cutout());
    }

    @SubscribeEvent
    static void registerRenderers(EntityRenderersEvent.RegisterRenderers e) {
        e.registerEntityRenderer(EntityInit.AREA_LIGHTNING.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.AREA_LIGHTNING.get()));
        e.registerEntityRenderer(EntityInit.BREACH.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.BREACH.get()));
        e.registerEntityRenderer(EntityInit.CHAOS.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.CHAOS.get()));
        e.registerEntityRenderer(EntityInit.COLD_BLAST.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.COLD_BLAST.get()));
        e.registerEntityRenderer(EntityInit.COLOR_SPRAY.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.COLOR_SPRAY.get()));
        e.registerEntityRenderer(EntityInit.DISINTEGRATE.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.DISINTEGRATE.get()));
        e.registerEntityRenderer(EntityInit.ELEMENTAL_FURY.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.ELEMENTAL_FURY.get()));
        e.registerEntityRenderer(EntityInit.FIREBALL.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.FIREBALL.get()));
        e.registerEntityRenderer(EntityInit.FLAMING_HANDS.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.FLAMING_HANDS.get()));
        e.registerEntityRenderer(EntityInit.GREATER_FIREBALL.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.GREATER_FIREBALL.get()));
        e.registerEntityRenderer(EntityInit.ICICLE.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.ICICLE.get()));
        e.registerEntityRenderer(EntityInit.ICY_GRIP.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.ICY_GRIP.get()));
        e.registerEntityRenderer(EntityInit.LIGHTNING_BOLT.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.LIGHTNING_BOLT.get()));
        e.registerEntityRenderer(EntityInit.MISCAST_MAGIC.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.MISCAST_MAGIC.get()));
        e.registerEntityRenderer(EntityInit.PUSH.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.PUSH.get()));
        e.registerEntityRenderer(EntityInit.SUMMON_SKELETON.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.SUMMON_SKELETON.get()));
        e.registerEntityRenderer(EntityInit.SUMMON_WITHER_SKELETON.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.SUMMON_WITHER_SKELETON.get()));
        e.registerEntityRenderer(EntityInit.SUMMON_WOLF.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.SUMMON_WOLF.get()));
        e.registerEntityRenderer(EntityInit.TASER.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.TASER.get()));
        e.registerEntityRenderer(EntityInit.WAIL_OF_THE_SHE_WOLF.get(), r -> new SpellProjectileRenderer<>(r, ItemInit.WAIL_OF_THE_SHE_WOLF.get()));
    }
}
