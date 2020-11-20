package ihh.spellbound.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public final class SoundInit implements IInit {
    public static final RegistryObject<SoundEvent> ZERO_SPELL = SOUNDS.register("zero_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "zero_spell")));
    public static final RegistryObject<SoundEvent> ONE_SPELL = SOUNDS.register("one_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "one_spell")));
    public static final RegistryObject<SoundEvent> TWO_SPELL = SOUNDS.register("two_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "two_spell")));
    public static final RegistryObject<SoundEvent> THREE_SPELL = SOUNDS.register("three_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "three_spell")));
    public static final RegistryObject<SoundEvent> FOUR_SPELL = SOUNDS.register("four_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "four_spell")));
    public static final RegistryObject<SoundEvent> FIVE_SPELL = SOUNDS.register("five_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "five_spell")));
    public static final RegistryObject<SoundEvent> SURGE = SOUNDS.register("surge", () -> new SoundEvent(new ResourceLocation("spellbound", "surge")));

    public static void init() {
    }
}
