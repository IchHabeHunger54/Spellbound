package ihh.spellbound.init;

import ihh.spellbound.entity.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public final class EntityInit implements IInit {
    public static final RegistryObject<EntityType<? extends SpellProjectile>> AREA_LIGHTNING = ENTITIES.register("area_lightning", () -> EntityType.Builder.create(AreaLightning::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("area_lightning"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> BREACH = ENTITIES.register("breach", () -> EntityType.Builder.create(Breach::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("breach"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> CHAOS = ENTITIES.register("chaos", () -> EntityType.Builder.create(Chaos::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("chaos"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> COLD_BLAST = ENTITIES.register("cold_blast", () -> EntityType.Builder.create(ColdBlast::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("cold_blast"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> COLOR_SPRAY = ENTITIES.register("color_spray", () -> EntityType.Builder.create(ColorSpray::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("color_spray"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> DISINTEGRATE = ENTITIES.register("disintegrate", () -> EntityType.Builder.create(Disintegrate::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("disintegrate"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> ELEMENTAL_FURY = ENTITIES.register("elemental_fury", () -> EntityType.Builder.create(ElementalFury::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("elemental_fury"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> FIREBALL = ENTITIES.register("fireball", () -> EntityType.Builder.create(Fireball::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("fireball"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> FLAMING_HANDS = ENTITIES.register("flaming_hands", () -> EntityType.Builder.create(FlamingHands::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("flaming_hands"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> GREATER_FIREBALL = ENTITIES.register("greater_fireball", () -> EntityType.Builder.create(GreaterFireball::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("greater_fireball"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> ICY_GRIP = ENTITIES.register("icy_grip", () -> EntityType.Builder.create(IcyGrip::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("icy_grip"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> ICICLE = ENTITIES.register("icicle", () -> EntityType.Builder.create(Icicle::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("icicle"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> LIGHTNING_BOLT = ENTITIES.register("lightning_bolt", () -> EntityType.Builder.create(LightningBolt::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("lightning_bolt"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> MISCAST_MAGIC = ENTITIES.register("miscast_magic", () -> EntityType.Builder.create(MiscastMagic::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("miscast_magic"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> PUSH = ENTITIES.register("push", () -> EntityType.Builder.create(Push::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("push"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> SUMMON_SKELETON = ENTITIES.register("summon_skeleton", () -> EntityType.Builder.create(SummonSkeleton::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("summon_skeleton"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> SUMMON_WITHER_SKELETON = ENTITIES.register("summon_wither_skeleton", () -> EntityType.Builder.create(SummonWitherSkeleton::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("summon_wither_skeleton"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> SUMMON_WOLF = ENTITIES.register("summon_wolf", () -> EntityType.Builder.create(SummonWolf::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("summon_wolf"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> TASER = ENTITIES.register("taser", () -> EntityType.Builder.create(Taser::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("taser"));
    public static final RegistryObject<EntityType<? extends SpellProjectile>> WAIL_OF_THE_SHE_WOLF = ENTITIES.register("wail_of_the_she_wolf", () -> EntityType.Builder.create(WailOfTheSheWolf::new, EntityClassification.MISC).size(0.2f, 0.2f).trackingRange(4).build("wail_of_the_she_wolf"));

    public static void init() {
    }
}
