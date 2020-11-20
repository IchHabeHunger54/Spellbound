package ihh.spellbound;

import ihh.spellbound.init.IInit;
import ihh.spellbound.init.ItemInit;
import javax.annotation.Nonnull;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("spellbound")
public class Spellbound {
    public static final ItemGroup GROUP = new ItemGroup("spellbound") {
        @Nonnull
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.BASE_TABLET.get());
        }
    };

    public Spellbound() {
        IInit.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
