package ihh.spellbound.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public interface IInit {
    DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "spellbound");
    DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "spellbound");
    DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, "spellbound");
    DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "spellbound");

    static void init(IEventBus bus) {
        ItemInit.init();
        BlockInit.init();
        EffectInit.init();
        SoundInit.init();
        ITEMS.register(bus);
        BLOCKS.register(bus);
        EFFECTS.register(bus);
        SOUNDS.register(bus);
    }
}
