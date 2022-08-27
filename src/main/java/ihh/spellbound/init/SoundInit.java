package ihh.spellbound.init;

import ihh.spellbound.Spellbound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

public interface SoundInit extends IInit {
    RegistryObject<SoundEvent> ZERO_SPELL = SOUND_EVENTS.register("zero_spell", () -> new SoundEvent(new ResourceLocation(Spellbound.MOD_ID, "zero_spell")));
    RegistryObject<SoundEvent> ONE_SPELL = SOUND_EVENTS.register("one_spell", () -> new SoundEvent(new ResourceLocation(Spellbound.MOD_ID, "one_spell")));
    RegistryObject<SoundEvent> TWO_SPELL = SOUND_EVENTS.register("two_spell", () -> new SoundEvent(new ResourceLocation(Spellbound.MOD_ID, "two_spell")));
    RegistryObject<SoundEvent> THREE_SPELL = SOUND_EVENTS.register("three_spell", () -> new SoundEvent(new ResourceLocation(Spellbound.MOD_ID, "three_spell")));
    RegistryObject<SoundEvent> FOUR_SPELL = SOUND_EVENTS.register("four_spell", () -> new SoundEvent(new ResourceLocation(Spellbound.MOD_ID, "four_spell")));
    RegistryObject<SoundEvent> FIVE_SPELL = SOUND_EVENTS.register("five_spell", () -> new SoundEvent(new ResourceLocation(Spellbound.MOD_ID, "five_spell")));
    RegistryObject<SoundEvent> SURGE = SOUND_EVENTS.register("surge", () -> new SoundEvent(new ResourceLocation(Spellbound.MOD_ID, "surge")));

    static void init() {
    }
}
