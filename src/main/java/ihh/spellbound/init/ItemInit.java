package ihh.spellbound.init;

import ihh.spellbound.Spellbound;
import ihh.spellbound.item.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public final class ItemInit implements IInit {
    public static final Item.Properties GROUP = new Item.Properties().group(Spellbound.GROUP);
    public static final RegistryObject<Item> DECAYING_BEDROCK = ITEMS.register("decaying_bedrock", () -> new BlockItem(BlockInit.DECAYING_BEDROCK.get(), GROUP));
    public static final RegistryObject<Item> DECAYING_OBSIDIAN = ITEMS.register("decaying_obsidian", () -> new BlockItem(BlockInit.DECAYING_OBSIDIAN.get(), GROUP));
    public static final RegistryObject<Item> SPECKLED_RED_MAGIC_MUSHROOM = ITEMS.register("speckled_red_magic_mushroom", () -> new BlockItem(BlockInit.SPECKLED_RED_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> SPECKLED_ORANGE_MAGIC_MUSHROOM = ITEMS.register("speckled_orange_magic_mushroom", () -> new BlockItem(BlockInit.SPECKLED_ORANGE_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> SPECKLED_PINK_MAGIC_MUSHROOM = ITEMS.register("speckled_pink_magic_mushroom", () -> new BlockItem(BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> SPECKLED_BLUE_MAGIC_MUSHROOM = ITEMS.register("speckled_blue_magic_mushroom", () -> new BlockItem(BlockInit.SPECKLED_BLUE_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> LIGHT_BLUE_MAGIC_MUSHROOM = ITEMS.register("light_blue_magic_mushroom", () -> new BlockItem(BlockInit.LIGHT_BLUE_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> ORANGE_MAGIC_MUSHROOM = ITEMS.register("orange_magic_mushroom", () -> new BlockItem(BlockInit.ORANGE_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> YELLOW_MAGIC_MUSHROOM = ITEMS.register("yellow_magic_mushroom", () -> new BlockItem(BlockInit.YELLOW_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> PURPLE_MAGIC_MUSHROOM = ITEMS.register("purple_magic_mushroom", () -> new BlockItem(BlockInit.PURPLE_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> RAINBOW_MAGIC_MUSHROOM = ITEMS.register("rainbow_magic_mushroom", () -> new BlockItem(BlockInit.RAINBOW_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> GOLD_MAGIC_MUSHROOM = ITEMS.register("gold_magic_mushroom", () -> new BlockItem(BlockInit.GOLD_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> GRAY_MAGIC_MUSHROOM = ITEMS.register("gray_magic_mushroom", () -> new BlockItem(BlockInit.GRAY_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> BLACK_MAGIC_MUSHROOM = ITEMS.register("black_magic_mushroom", () -> new BlockItem(BlockInit.BLACK_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> WHITE_MAGIC_MUSHROOM = ITEMS.register("white_magic_mushroom", () -> new BlockItem(BlockInit.WHITE_MAGIC_MUSHROOM.get(), GROUP));
    public static final RegistryObject<Item> BASE_TABLET = ITEMS.register("base_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> COLD_TABLET = ITEMS.register("cold_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> FIRE_TABLET = ITEMS.register("fire_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> LIGHTNING_TABLET = ITEMS.register("lightning_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> SUMMON_TABLET = ITEMS.register("summon_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> DISRUPTION_TABLET = ITEMS.register("disruption_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> DIVINATION_TABLET = ITEMS.register("divination_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> PROTECTION_TABLET = ITEMS.register("protection_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> MUNDANE_TABLET = ITEMS.register("mundane_tablet", () -> new Item(GROUP));
    public static final RegistryObject<Item> ICY_GRIP = ITEMS.register("icy_grip", IcyGrip::new);
    public static final RegistryObject<Item> ICICLE = ITEMS.register("icicle", Icicle::new);
    public static final RegistryObject<Item> COLD_BLAST = ITEMS.register("cold_blast", ColdBlast::new);
    public static final RegistryObject<Item> COLD_SHIELD = ITEMS.register("cold_shield", ColdShield::new);
    public static final RegistryObject<Item> FLAMING_HANDS = ITEMS.register("flaming_hands", FlamingHands::new);
    public static final RegistryObject<Item> FIREBALL = ITEMS.register("fireball", Fireball::new);
    public static final RegistryObject<Item> GREATER_FIREBALL = ITEMS.register("greater_fireball", GreaterFireball::new);
    public static final RegistryObject<Item> FIRE_SHIELD = ITEMS.register("fire_shield", FireShield::new);
    public static final RegistryObject<Item> TASER = ITEMS.register("taser", Taser::new);
    public static final RegistryObject<Item> LIGHTNING_BOLT = ITEMS.register("lightning_bolt", LightningBolt::new);
    public static final RegistryObject<Item> AREA_LIGHTNING = ITEMS.register("area_lightning", AreaLightning::new);
    public static final RegistryObject<Item> LIGHTNING_SHIELD = ITEMS.register("lightning_shield", LightningShield::new);
    public static final RegistryObject<Item> SUMMON_WOLF = ITEMS.register("summon_wolf", SummonWolf::new);
    public static final RegistryObject<Item> SUMMON_SKELETON = ITEMS.register("summon_skeleton", SummonSkeleton::new);
    public static final RegistryObject<Item> SUMMON_WITHER_SKELETON = ITEMS.register("summon_wither_skeleton", SummonWitherSkeleton::new);
    public static final RegistryObject<Item> SURGE_SHIELD = ITEMS.register("surge_shield", SurgeShield::new);
    public static final RegistryObject<Item> SPELL_SHIELD = ITEMS.register("spell_shield", SpellShield::new);
    public static final RegistryObject<Item> ARCHMAGIC = ITEMS.register("archmagic", Archmagic::new);
    public static final RegistryObject<Item> DISINTEGRATE = ITEMS.register("disintegrate", Disintegrate::new);
    public static final RegistryObject<Item> ELEMENTAL_FURY = ITEMS.register("elemental_fury", ElementalFury::new);
    public static final RegistryObject<Item> PANIC_ROOM = ITEMS.register("panic_room", PanicRoom::new);
    public static final RegistryObject<Item> WAIL_OF_THE_SHE_WOLF = ITEMS.register("wail_of_the_she_wolf", WailOfTheSheWolf::new);
    public static final RegistryObject<Item> BREACH = ITEMS.register("breach", Breach::new);
    public static final RegistryObject<Item> CHAOS = ITEMS.register("chaos", Chaos::new);
    public static final RegistryObject<Item> MISCAST_MAGIC = ITEMS.register("miscast_magic", MiscastMagic::new);
    public static final RegistryObject<Item> DIMENSION_DOOR = ITEMS.register("dimension_door", DimensionDoor::new);
    public static final RegistryObject<Item> COOKIE_CHEST = ITEMS.register("cookie_chest", CookieChest::new);
    public static final RegistryObject<Item> BEDROCK_WALL = ITEMS.register("bedrock_wall", BedrockWall::new);
    public static final RegistryObject<Item> OBSIDIAN_WALL = ITEMS.register("obsidian_wall", ObsidianWall::new);
    public static final RegistryObject<Item> STONE_WALL = ITEMS.register("stone_wall", StoneWall::new);
    public static final RegistryObject<Item> BLINK = ITEMS.register("blink", Blink::new);
    public static final RegistryObject<Item> COLOR_SPRAY = ITEMS.register("color_spray", ColorSpray::new);
    public static final RegistryObject<Item> PUSH = ITEMS.register("push", Push::new);
    public static final RegistryObject<Item> ADVANCE_TIME = ITEMS.register("advance_time", AdvanceTime::new);
    public static final RegistryObject<Item> CHANGE_WEATHER = ITEMS.register("change_weather", ChangeWeather::new);
    public static final RegistryObject<Item> FISH_FORM = ITEMS.register("fish_form", FishForm::new);
    public static final RegistryObject<Item> FLIGHT = ITEMS.register("flight", Flight::new);
    public static final RegistryObject<Item> HASTE = ITEMS.register("haste", Haste::new);
    public static final RegistryObject<Item> INSTANT_LEVITATION = ITEMS.register("instant_levitation", InstantLevitation::new);
    public static final RegistryObject<Item> TORCHLIGHT = ITEMS.register("torchlight", Torchlight::new);

    public static void init() {
    }
}
