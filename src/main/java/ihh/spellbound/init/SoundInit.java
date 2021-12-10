package ihh.spellbound.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

public interface SoundInit extends IInit {
    RegistryObject<SoundEvent> ZERO_SPELL = SOUNDS.register("zero_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "zero_spell")));
    RegistryObject<SoundEvent> ONE_SPELL = SOUNDS.register("one_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "one_spell")));
    RegistryObject<SoundEvent> TWO_SPELL = SOUNDS.register("two_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "two_spell")));
    RegistryObject<SoundEvent> THREE_SPELL = SOUNDS.register("three_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "three_spell")));
    RegistryObject<SoundEvent> FOUR_SPELL = SOUNDS.register("four_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "four_spell")));
    RegistryObject<SoundEvent> FIVE_SPELL = SOUNDS.register("five_spell", () -> new SoundEvent(new ResourceLocation("spellbound", "five_spell")));
    RegistryObject<SoundEvent> SURGE = SOUNDS.register("surge", () -> new SoundEvent(new ResourceLocation("spellbound", "surge")));

    static void init() {
    }
}
