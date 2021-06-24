package ihh.spellbound.item;

import ihh.spellbound.entity.SpellProjectile;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class ProjectileSpell extends Spell {
    private final Supplier<EntityType<? extends SpellProjectile>> ENTITY;

    public ProjectileSpell(ForgeConfigSpec.IntValue timeConfig, Supplier<EntityType<? extends SpellProjectile>> entityType) {
        super(timeConfig);
        ENTITY = entityType;
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        SpellProjectile entity = ENTITY.get().create(world);
        entity.setDirectionAndMovement(player, player.rotationPitch, player.rotationYaw, -20.0F, 0.7F, 1.0F);
        entity.setPositionAndUpdate(player.getPosX(), player.getPosY() + player.getEyeHeight(), player.getPosZ());
        entity.setShooter(player);
        world.addEntity(entity);
        return true;
    }
}
