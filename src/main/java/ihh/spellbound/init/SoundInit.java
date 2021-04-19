package ihh.spellbound.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public final class SoundInit implements IInit {
    public static final RegistryObject<SoundEvent> SURGE = SOUNDS.register("surge", () -> new SoundEvent(new ResourceLocation("spellbound", "surge")));

    public static void init() {
    }
}
