package ihh.spellbound.init;

import ihh.spellbound.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;

public interface EntityInit extends IInit {
    RegistryObject<EntityType<IcyGrip>> ICY_GRIP = ENTITY_TYPES.register("icy_grip", () -> EntityType.Builder.of(IcyGrip::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("icy_grip"));
    RegistryObject<EntityType<Icicle>> ICICLE = ENTITY_TYPES.register("icicle", () -> EntityType.Builder.of(Icicle::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("icicle"));
    RegistryObject<EntityType<ColdBlast>> COLD_BLAST = ENTITY_TYPES.register("cold_blast", () -> EntityType.Builder.of(ColdBlast::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("cold_blast"));
    RegistryObject<EntityType<FlamingHands>> FLAMING_HANDS = ENTITY_TYPES.register("flaming_hands", () -> EntityType.Builder.of(FlamingHands::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("flaming_hands"));
    RegistryObject<EntityType<Fireball>> FIREBALL = ENTITY_TYPES.register("fireball", () -> EntityType.Builder.of(Fireball::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("fireball"));
    RegistryObject<EntityType<GreaterFireball>> GREATER_FIREBALL = ENTITY_TYPES.register("greater_fireball", () -> EntityType.Builder.of(GreaterFireball::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("greater_fireball"));
    RegistryObject<EntityType<Taser>> TASER = ENTITY_TYPES.register("taser", () -> EntityType.Builder.of(Taser::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("taser"));
    RegistryObject<EntityType<LightningBolt>> LIGHTNING_BOLT = ENTITY_TYPES.register("lightning_bolt", () -> EntityType.Builder.of(LightningBolt::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("lightning_bolt"));
    RegistryObject<EntityType<AreaLightning>> AREA_LIGHTNING = ENTITY_TYPES.register("area_lightning", () -> EntityType.Builder.of(AreaLightning::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("area_lightning"));
    RegistryObject<EntityType<SummonWolf>> SUMMON_WOLF = ENTITY_TYPES.register("summon_wolf", () -> EntityType.Builder.of(SummonWolf::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("summon_wolf"));
    RegistryObject<EntityType<SummonSkeleton>> SUMMON_SKELETON = ENTITY_TYPES.register("summon_skeleton", () -> EntityType.Builder.of(SummonSkeleton::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("summon_skeleton"));
    RegistryObject<EntityType<SummonWitherSkeleton>> SUMMON_WITHER_SKELETON = ENTITY_TYPES.register("summon_wither_skeleton", () -> EntityType.Builder.of(SummonWitherSkeleton::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("summon_wither_skeleton"));
    RegistryObject<EntityType<Disintegrate>> DISINTEGRATE = ENTITY_TYPES.register("disintegrate", () -> EntityType.Builder.of(Disintegrate::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("disintegrate"));
    RegistryObject<EntityType<ElementalFury>> ELEMENTAL_FURY = ENTITY_TYPES.register("elemental_fury", () -> EntityType.Builder.of(ElementalFury::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("elemental_fury"));
    RegistryObject<EntityType<WailOfTheSheWolf>> WAIL_OF_THE_SHE_WOLF = ENTITY_TYPES.register("wail_of_the_she_wolf", () -> EntityType.Builder.of(WailOfTheSheWolf::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("wail_of_the_she_wolf"));
    RegistryObject<EntityType<Breach>> BREACH = ENTITY_TYPES.register("breach", () -> EntityType.Builder.of(Breach::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("breach"));
    RegistryObject<EntityType<ColorSpray>> COLOR_SPRAY = ENTITY_TYPES.register("color_spray", () -> EntityType.Builder.of(ColorSpray::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("color_spray"));
    RegistryObject<EntityType<Push>> PUSH = ENTITY_TYPES.register("push", () -> EntityType.Builder.of(Push::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("push"));
    RegistryObject<EntityType<Chaos>> CHAOS = ENTITY_TYPES.register("chaos", () -> EntityType.Builder.of(Chaos::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("chaos"));
    RegistryObject<EntityType<MiscastMagic>> MISCAST_MAGIC = ENTITY_TYPES.register("miscast_magic", () -> EntityType.Builder.of(MiscastMagic::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("miscast_magic"));

    static void init() {
    }
}
