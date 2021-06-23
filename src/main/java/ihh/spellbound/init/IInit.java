package ihh.spellbound.init;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public interface IInit {
    DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "spellbound");
    DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "spellbound");
    DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, "spellbound");
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
