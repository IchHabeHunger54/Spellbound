package ihh.spellbound.init;

import ihh.spellbound.block.DecayingBlock;
import ihh.spellbound.block.PassiveMagicMushroom;
import ihh.spellbound.block.SpeckledBlueMagicMushroom;
import ihh.spellbound.block.SpeckledOrangeMagicMushroom;
import ihh.spellbound.block.SpeckledPinkMagicMushroom;
import ihh.spellbound.block.SpeckledRedMagicMushroom;
import ihh.spellbound.block.WhiteMagicMushroom;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

public interface BlockInit extends IInit {
    RegistryObject<Block> DECAYING_BEDROCK = BLOCKS.register("decaying_bedrock", () -> new DecayingBlock(Blocks.BEDROCK));
    RegistryObject<Block> DECAYING_OBSIDIAN = BLOCKS.register("decaying_obsidian", () -> new DecayingBlock(Blocks.OBSIDIAN));
    RegistryObject<Block> SPECKLED_RED_MAGIC_MUSHROOM = BLOCKS.register("speckled_red_magic_mushroom", SpeckledRedMagicMushroom::new);
    RegistryObject<Block> SPECKLED_ORANGE_MAGIC_MUSHROOM = BLOCKS.register("speckled_orange_magic_mushroom", SpeckledOrangeMagicMushroom::new);
    RegistryObject<Block> SPECKLED_PINK_MAGIC_MUSHROOM = BLOCKS.register("speckled_pink_magic_mushroom", SpeckledPinkMagicMushroom::new);
    RegistryObject<Block> SPECKLED_BLUE_MAGIC_MUSHROOM = BLOCKS.register("speckled_blue_magic_mushroom", SpeckledBlueMagicMushroom::new);
    RegistryObject<Block> LIGHT_BLUE_MAGIC_MUSHROOM = BLOCKS.register("light_blue_magic_mushroom", PassiveMagicMushroom::new);
    RegistryObject<Block> ORANGE_MAGIC_MUSHROOM = BLOCKS.register("orange_magic_mushroom", PassiveMagicMushroom::new);
    RegistryObject<Block> YELLOW_MAGIC_MUSHROOM = BLOCKS.register("yellow_magic_mushroom", PassiveMagicMushroom::new);
    RegistryObject<Block> PURPLE_MAGIC_MUSHROOM = BLOCKS.register("purple_magic_mushroom", PassiveMagicMushroom::new);
    RegistryObject<Block> RAINBOW_MAGIC_MUSHROOM = BLOCKS.register("rainbow_magic_mushroom", PassiveMagicMushroom::new);
    RegistryObject<Block> GOLD_MAGIC_MUSHROOM = BLOCKS.register("gold_magic_mushroom", PassiveMagicMushroom::new);
    RegistryObject<Block> GRAY_MAGIC_MUSHROOM = BLOCKS.register("gray_magic_mushroom", PassiveMagicMushroom::new);
    RegistryObject<Block> BLACK_MAGIC_MUSHROOM = BLOCKS.register("black_magic_mushroom", PassiveMagicMushroom::new);
    RegistryObject<Block> WHITE_MAGIC_MUSHROOM = BLOCKS.register("white_magic_mushroom", WhiteMagicMushroom::new);

    static void init() {
    }
}
