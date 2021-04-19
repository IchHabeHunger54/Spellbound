package ihh.spellbound;

import ihh.spellbound.init.BlockInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
    }
}
