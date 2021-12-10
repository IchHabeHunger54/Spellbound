package ihh.spellbound.item;

import ihh.spellbound.entity.SpellProjectile;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class ProjectileSpell extends Spell {
    private final Supplier<EntityType<? extends SpellProjectile>> ENTITY;

    public ProjectileSpell(ForgeConfigSpec.IntValue timeConfig, Supplier<EntityType<? extends SpellProjectile>> entityType) {
        super(timeConfig);
        ENTITY = entityType;
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        SpellProjectile entity = ENTITY.get().create(level);
        entity.shootFromRotation(player, player.getXRot(), player.getYRot(), -20.0F, 0.7F, 1F);
        entity.setPos(player.getX(), player.getY() + player.getEyeHeight(), player.getZ());
        entity.setOwner(player);
        level.addFreshEntity(entity);
        return true;
    }
}
