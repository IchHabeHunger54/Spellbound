package ihh.spellbound.init;

import ihh.spellbound.entity.BreachEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public final class EntityInit implements IInit {
    public static final RegistryObject<EntityType<? extends BreachEntity>> BREACH = ENTITIES.register("breach", () -> EntityType.Builder.<BreachEntity>create(BreachEntity::new, EntityClassification.MISC).size(1, 1).trackingRange(4).build("breach"));

    public static void init() {
    }
}
