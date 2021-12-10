package ihh.spellbound.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public interface IInit {
    DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "spellbound");
    DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "spellbound");
    DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "spellbound");
    DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, "spellbound");
    DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "spellbound");

    static void init(IEventBus bus) {
        BlockInit.init();
        ItemInit.init();
        EffectInit.init();
        EntityInit.init();
        SoundInit.init();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        EFFECTS.register(bus);
        ENTITIES.register(bus);
        SOUNDS.register(bus);
    }
}
