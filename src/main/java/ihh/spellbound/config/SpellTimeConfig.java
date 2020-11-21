package ihh.spellbound.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SpellTimeConfig {
    public static ForgeConfigSpec.IntValue ADVANCE_TIME;
    public static ForgeConfigSpec.IntValue ARCHMAGIC;
    public static ForgeConfigSpec.IntValue AREA_LIGHTNING;
    public static ForgeConfigSpec.IntValue BEDROCK_WALL;
    public static ForgeConfigSpec.IntValue BLINK;
    public static ForgeConfigSpec.IntValue BREACH;
    public static ForgeConfigSpec.IntValue CHANGE_WEATHER;
    public static ForgeConfigSpec.IntValue CHAOS;
    public static ForgeConfigSpec.IntValue COLD_BLAST;
    public static ForgeConfigSpec.IntValue COLD_SHIELD;
    public static ForgeConfigSpec.IntValue COLOR_SPRAY;
    public static ForgeConfigSpec.IntValue COOKIE_CHEST;
    public static ForgeConfigSpec.IntValue DIMENSION_DOOR;
    public static ForgeConfigSpec.IntValue DISINTEGRATE;
    public static ForgeConfigSpec.IntValue ELEMENTAL_FURY;
    public static ForgeConfigSpec.IntValue FIREBALL;
    public static ForgeConfigSpec.IntValue FIRE_SHIELD;
    public static ForgeConfigSpec.IntValue FISH_FORM;
    public static ForgeConfigSpec.IntValue FLAMING_HANDS;
    public static ForgeConfigSpec.IntValue FLIGHT;
    public static ForgeConfigSpec.IntValue GREATER_FIREBALL;
    public static ForgeConfigSpec.IntValue HASTE;
    public static ForgeConfigSpec.IntValue ICICLE;
    public static ForgeConfigSpec.IntValue ICY_GRIP;
    public static ForgeConfigSpec.IntValue INSTANT_LEVITATION;
    public static ForgeConfigSpec.IntValue LIGHTNING_BOLT;
    public static ForgeConfigSpec.IntValue LIGHTNING_SHIELD;
    public static ForgeConfigSpec.IntValue MISCAST_MAGIC;
    public static ForgeConfigSpec.IntValue OBSIDIAN_WALL;
    public static ForgeConfigSpec.IntValue PANIC_ROOM;
    public static ForgeConfigSpec.IntValue PUSH;
    public static ForgeConfigSpec.IntValue SPELL_SHIELD;
    public static ForgeConfigSpec.IntValue STONE_WALL;
    public static ForgeConfigSpec.IntValue SUMMON_SKELETON;
    public static ForgeConfigSpec.IntValue SUMMON_WITHER_SKELETON;
    public static ForgeConfigSpec.IntValue SUMMON_WOLF;
    public static ForgeConfigSpec.IntValue SURGE_SHIELD;
    public static ForgeConfigSpec.IntValue TASER;
    public static ForgeConfigSpec.IntValue TORCHLIGHT;
    public static ForgeConfigSpec.IntValue WAIL_OF_THE_SHE_WOLF;

    public static void init(ForgeConfigSpec.Builder b) {
        b.comment("How long the spells need to be charged.");
        b.push("spell_time");
        ADVANCE_TIME = defineTime(b, "advance_time", 1);
        ARCHMAGIC = defineTime(b, "archmagic", 5);
        AREA_LIGHTNING = defineTime(b, "area_lightning", 3);
        BEDROCK_WALL = defineTime(b, "bedrock_wall", 4);
        BLINK = defineTime(b, "blink", 3);
        BREACH = defineTime(b, "breach", 2);
        CHANGE_WEATHER = defineTime(b, "change_weather", 3);
        CHAOS = defineTime(b, "chaos", 3);
        COLD_BLAST = defineTime(b, "cold_blast", 3);
        COLD_SHIELD = defineTime(b, "cold_shield", 1);
        COLOR_SPRAY = defineTime(b, "color_spray", 2);
        COOKIE_CHEST = defineTime(b, "cookie_chest", 5);
        DIMENSION_DOOR = defineTime(b, "dimension_door", 4);
        DISINTEGRATE = defineTime(b, "disintegrate", 5);
        ELEMENTAL_FURY = defineTime(b, "elemental_fury", 5);
        FIREBALL = defineTime(b, "fireball", 2);
        FIRE_SHIELD = defineTime(b, "fire_shield", 1);
        FISH_FORM = defineTime(b, "fish_form", 3);
        FLAMING_HANDS = defineTime(b, "flaming_hands", 1);
        FLIGHT = defineTime(b, "flight", 4);
        GREATER_FIREBALL = defineTime(b, "greater_fireball", 3);
        HASTE = defineTime(b, "haste", 2);
        ICICLE = defineTime(b, "icicle", 2);
        ICY_GRIP = defineTime(b, "icy_grip", 1);
        INSTANT_LEVITATION = defineTime(b, "instant_levitation", 0);
        LIGHTNING_BOLT = defineTime(b, "lightning_bolt", 2);
        LIGHTNING_SHIELD = defineTime(b, "lightning_shield", 1);
        MISCAST_MAGIC = defineTime(b, "miscast_magic", 3);
        OBSIDIAN_WALL = defineTime(b, "obsidian_wall", 4);
        PANIC_ROOM = defineTime(b, "panic_room", 5);
        PUSH = defineTime(b, "push", 1);
        SPELL_SHIELD = defineTime(b, "spell_shield", 5);
        STONE_WALL = defineTime(b, "stone_wall", 4);
        SUMMON_SKELETON = defineTime(b, "summon_skeleton", 2);
        SUMMON_WITHER_SKELETON = defineTime(b, "summon_wither_skeleton", 3);
        SUMMON_WOLF = defineTime(b, "summon_wolf", 1);
        SURGE_SHIELD = defineTime(b, "surge_shield", 1);
        TASER = defineTime(b, "taser", 1);
        TORCHLIGHT = defineTime(b, "torchlight", 0);
        WAIL_OF_THE_SHE_WOLF = defineTime(b, "wail_of_the_she_wolf", 5);
        b.pop();
    }

    private static ForgeConfigSpec.IntValue defineTime(ForgeConfigSpec.Builder b, String s, int i) {
        return b.defineInRange(s, i, 0, 5);
    }
}
