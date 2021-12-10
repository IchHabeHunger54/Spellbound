package ihh.spellbound.init;

import ihh.spellbound.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;

public interface EntityInit extends IInit {
    RegistryObject<EntityType<? extends SpellProjectile>> AREA_LIGHTNING = ENTITIES.register("area_lightning", () -> EntityType.Builder.of(AreaLightning::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("area_lightning"));
    RegistryObject<EntityType<? extends SpellProjectile>> BREACH = ENTITIES.register("breach", () -> EntityType.Builder.of(Breach::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("breach"));
    RegistryObject<EntityType<? extends SpellProjectile>> CHAOS = ENTITIES.register("chaos", () -> EntityType.Builder.of(Chaos::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("chaos"));
    RegistryObject<EntityType<? extends SpellProjectile>> COLD_BLAST = ENTITIES.register("cold_blast", () -> EntityType.Builder.of(ColdBlast::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("cold_blast"));
    RegistryObject<EntityType<? extends SpellProjectile>> COLOR_SPRAY = ENTITIES.register("color_spray", () -> EntityType.Builder.of(ColorSpray::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("color_spray"));
    RegistryObject<EntityType<? extends SpellProjectile>> DISINTEGRATE = ENTITIES.register("disintegrate", () -> EntityType.Builder.of(Disintegrate::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("disintegrate"));
    RegistryObject<EntityType<? extends SpellProjectile>> ELEMENTAL_FURY = ENTITIES.register("elemental_fury", () -> EntityType.Builder.of(ElementalFury::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("elemental_fury"));
    RegistryObject<EntityType<? extends SpellProjectile>> FIREBALL = ENTITIES.register("fireball", () -> EntityType.Builder.of(Fireball::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("fireball"));
    RegistryObject<EntityType<? extends SpellProjectile>> FLAMING_HANDS = ENTITIES.register("flaming_hands", () -> EntityType.Builder.of(FlamingHands::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("flaming_hands"));
    RegistryObject<EntityType<? extends SpellProjectile>> GREATER_FIREBALL = ENTITIES.register("greater_fireball", () -> EntityType.Builder.of(GreaterFireball::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("greater_fireball"));
    RegistryObject<EntityType<? extends SpellProjectile>> ICY_GRIP = ENTITIES.register("icy_grip", () -> EntityType.Builder.of(IcyGrip::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("icy_grip"));
    RegistryObject<EntityType<? extends SpellProjectile>> ICICLE = ENTITIES.register("icicle", () -> EntityType.Builder.of(Icicle::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("icicle"));
    RegistryObject<EntityType<? extends SpellProjectile>> LIGHTNING_BOLT = ENTITIES.register("lightning_bolt", () -> EntityType.Builder.of(LightningBolt::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("lightning_bolt"));
    RegistryObject<EntityType<? extends SpellProjectile>> MISCAST_MAGIC = ENTITIES.register("miscast_magic", () -> EntityType.Builder.of(MiscastMagic::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("miscast_magic"));
    RegistryObject<EntityType<? extends SpellProjectile>> PUSH = ENTITIES.register("push", () -> EntityType.Builder.of(Push::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("push"));
    RegistryObject<EntityType<? extends SpellProjectile>> SUMMON_SKELETON = ENTITIES.register("summon_skeleton", () -> EntityType.Builder.of(SummonSkeleton::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("summon_skeleton"));
    RegistryObject<EntityType<? extends SpellProjectile>> SUMMON_WITHER_SKELETON = ENTITIES.register("summon_wither_skeleton", () -> EntityType.Builder.of(SummonWitherSkeleton::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("summon_wither_skeleton"));
    RegistryObject<EntityType<? extends SpellProjectile>> SUMMON_WOLF = ENTITIES.register("summon_wolf", () -> EntityType.Builder.of(SummonWolf::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("summon_wolf"));
    RegistryObject<EntityType<? extends SpellProjectile>> TASER = ENTITIES.register("taser", () -> EntityType.Builder.of(Taser::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("taser"));
    RegistryObject<EntityType<? extends SpellProjectile>> WAIL_OF_THE_SHE_WOLF = ENTITIES.register("wail_of_the_she_wolf", () -> EntityType.Builder.of(WailOfTheSheWolf::new, MobCategory.MISC).sized(0.2f, 0.2f).setTrackingRange(4).build("wail_of_the_she_wolf"));

    static void init() {
    }
}
