package ihh.spellbound.init;

import ihh.spellbound.Spellbound;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public interface IInit {
    DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Spellbound.MOD_ID);
    DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Spellbound.MOD_ID);
    DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Spellbound.MOD_ID);
    DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Spellbound.MOD_ID);
    DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Spellbound.MOD_ID);

    static void init(IEventBus bus) {
        BlockInit.init();
        ItemInit.init();
        EffectInit.init();
        EntityInit.init();
        SoundInit.init();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        MOB_EFFECTS.register(bus);
        ENTITY_TYPES.register(bus);
        SOUND_EVENTS.register(bus);
    }
}
