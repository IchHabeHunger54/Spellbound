package ihh.spellbound;

import ihh.spellbound.init.IInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nonnull;

@Mod("spellbound")
public final class Spellbound {
    public static final CreativeModeTab GROUP = new CreativeModeTab("spellbound") {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.BASE_TABLET.get());
        }
    };

    public Spellbound() {
        IInit.init(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.config);
    }
}
