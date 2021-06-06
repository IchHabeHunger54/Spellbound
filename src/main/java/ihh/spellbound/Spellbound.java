package ihh.spellbound;

import ihh.spellbound.config.Config;
import ihh.spellbound.init.IInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nonnull;

@Mod("spellbound")
public final class Spellbound {
    public static final ItemGroup GROUP = new ItemGroup("spellbound") {
        @Nonnull
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.BASE_TABLET.get());
        }
    };

    public Spellbound() {
        IInit.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.config);
    }
}
